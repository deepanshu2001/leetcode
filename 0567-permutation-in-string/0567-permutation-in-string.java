class Solution {
    public void f(String s,List<String> str,String p){
        if(s.isEmpty()){
            str.add(p);
            return;
        }
        char ch=s.charAt(0);
        for(int i=0;i<=p.length();i++){
            String s1=p.substring(0,i);
            String s2=p.substring(i);
            f(s.substring(1),str,s1+ch+s2);
        }
    }
    public boolean checkInclusion(String s1, String s2) {
        List<String> str=new ArrayList<>();
        f(s1,str,"");
        for(int i=0;i<str.size();i++){
            String p=str.get(i);
            if(s2.contains(p)){
                return true;
            }
        }
        return false;
    }
}