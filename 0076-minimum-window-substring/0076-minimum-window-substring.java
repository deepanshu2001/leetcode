class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int min=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i=0;
        int j=0;
        int cnt=map.size();
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)==false){
                j++;
                continue;
            }
            else{
               map.put(ch,map.get(ch)-1);
               if(map.get(ch)==0){
                cnt--;
               }
            }
            if(cnt==0){
                if(min>j-i+1){
                    ans=s.substring(i,j+1);
                    min=j-i+1;
                }
                while(cnt==0){
                    char new_char=s.charAt(i);
                    if(map.containsKey(new_char)){
                        map.put(new_char,map.get(new_char)+1);
                        if(map.get(new_char)>0){
                            cnt++;
                        }
                    }
                    i++;
                    if(cnt==0){
                        if(min>j-i+1){
                            ans=s.substring(i,j+1);
                            min=j-i+1;
                        }
                    }
                }
            }
            j++;
        }
        return ans;
    }
}