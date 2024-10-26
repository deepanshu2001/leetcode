class Solution {
    public int evalRPN(String[] tokens) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<tokens.length;i++){
            list.add(tokens[i]);
        }
        int i=0;
        while(!"+".equals(list.get(i))||!"-".equals(list.get(i))||!"*".equals(list.get(i))||!"/".equals(list.get(i))){
            i++;
        }
        int ans=0;
        String s1=list.get(i-1);
        String s2=list.get(i-2);
        if(list.get(i)=="+"){
            ans+=Integer.parseInt(s1)+Integer.parseInt(s2);
        }
        if(list.get(i)=="-"){
            ans-=Integer.parseInt(s1)-Integer.parseInt(s2);
        }
        if(list.get(i)=="/"){
            ans/=Integer.parseInt(s1)/Integer.parseInt(s2);
        }
        if(list.get(i)=="*"){
            ans*=Integer.parseInt(s1)*Integer.parseInt(s2);
        }
        list.remove(i-1);
        list.remove(i-2);
        list.remove(i);
        i=0;
        while(list.size()!=0){
            while(!"+".equals(list.get(i))||!"-".equals(list.get(i))||!"*".equals(list.get(i))||!"/".equals(list.get(i))){
            i++;
            }
            String s=list.get(i-1);
            if(list.get(i)=="+"){
                ans+=Integer.parseInt(s);
            }
            if(list.get(i)=="+"){
                ans+=Integer.parseInt(s);
            }
            if(list.get(i)=="+"){
                ans+=Integer.parseInt(s);
            }
            
        }
    }
}