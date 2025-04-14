class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            int num=i;
            List<Integer> list=new ArrayList<>();
            while(num>0){
                list.add(num%10);
                num=num/10;
            }
            if(list.size()%2!=0){
                continue;
            }
            int j=0;
            int sum1=0;
            int sum2=0;
            while(j<(list.size()/2)){
                sum1+=list.get(j);
                j++;
            }
            while(j<list.size()){
                sum2+=list.get(j);
                j++;
            }
            if(sum1==sum2){
                ans++;
            }

        }
        return ans;
    }
}