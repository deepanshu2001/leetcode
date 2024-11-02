class Solution {
    int sum=0;
    int prefix[];
    int prefix_sum=0;
    public Solution(int[] w) {
        prefix=new int[w.length];
        for(int i=0;i<w.length;i++){
            prefix_sum+=w[i];
            prefix[i]=prefix_sum;
        }
        sum=prefix_sum;
    }
    
    public int pickIndex() {
        double target=prefix_sum*Math.random();
        int s=0;
        int e=prefix.length;
        while(s<e){
            int mid=s+(e-s)/2;
            if(target>prefix[mid]){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */