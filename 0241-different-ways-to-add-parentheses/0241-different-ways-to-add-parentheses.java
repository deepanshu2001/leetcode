class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch=='+'||ch=='*'||ch=='-'){
                List<Integer> left=diffWaysToCompute(expression.substring(0,i));
                List<Integer> right=diffWaysToCompute(expression.substring(i+1));
                for(int x:left){
                    for(int y:right){
                        if(ch=='+'){
                            ans.add(x+y);
                        }
                        if(ch=='-'){
                            ans.add(x-y);
                        }
                        if(ch=='*'){
                            ans.add(x*y);
                        }
                    }
                }
            }
        }
        if(ans.size()==0){
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }
}