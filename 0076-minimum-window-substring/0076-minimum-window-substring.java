class Solution {
    public String minWindow(String s, String t) {
        String ans="";
        int min=Integer.MAX_VALUE;
        int j=0;
        int i=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int k=0;k<t.length();k++){
            char c=t.charAt(k);
            map.put(c,map.getOrDefault(c,0)+1);
        }
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
                    char c=s.charAt(i);
                    if(map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                        if(map.get(c)>0){
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