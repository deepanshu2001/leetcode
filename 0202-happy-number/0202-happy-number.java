class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        
        while(n!=1){
           int new_num=n;
           int sum=0;
           while(new_num>0){
              int rem=new_num%10;
              sum+=rem*rem;
              new_num=new_num/10;
           }
           if(set.contains(sum)){
            return false;
           }
           set.add(sum);
           n=sum;
        }
        return true;
    }
}