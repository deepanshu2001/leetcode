class Solution {
    public int [] seive(int upperlimit){
        int primes[]=new int[upperlimit+1];
        Arrays.fill(primes,1);
        primes[0]=0;
        primes[1]=0;
        for(int i=2;i*i<=upperlimit;i++){
            if(primes[i]==1){
                for(int multiple=i*i;multiple<=upperlimit;multiple+=i){
                    primes[multiple]=0;
                }
            }
        }
        return primes;
    }
    public int[] closestPrimes(int left, int right) {
        int primes[]=seive(right);
        List<Integer> list=new ArrayList<>();
        for(int num=left;num<=right;num++){
            if(primes[num]==1){
                list.add(num);
            }
        }
        if(list.size()<2){
            return new int[]{-1,-1};
        }
        int ans[]=new int[2];
        Arrays.fill(ans,-1);
        int min_diff=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            int min=list.get(i)-list.get(i-1);
            if(min<min_diff){
                min_diff=min;
                ans[0]=list.get(i-1);
                ans[1]=list.get(i);
            }
        }
        return ans;
    }
}