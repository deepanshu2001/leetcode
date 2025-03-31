class Solution {
    public int partitionString(String s) {
        int cnt=0;
        Set<Character> set=new HashSet<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(set.contains(ch)){
               cnt++;
               while(i<j){
                set.remove(s.charAt(i));
                i++;
               }
            }
            set.add(ch);
            j++;
        }
        if(!set.isEmpty()){
            cnt++;
        }
        return cnt;
    }
}