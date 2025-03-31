class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int start=0;
        int e=0;
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           e=Math.max(e,map.get(ch));
           if(e==i){
             int len=e-start+1;
             ans.add(len);
             start=e+1;
           }
        }
        return ans;
    }
}