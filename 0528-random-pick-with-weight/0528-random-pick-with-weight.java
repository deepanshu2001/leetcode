class Solution {
    int prefix[];
    int totalsum=0;
    public Solution(int[] w) {
        prefix=new int[w.length];
        int prefixSum=0;
        for(int i=0;i<w.length;i++){
            prefixSum+=w[i];
            prefix[i]=prefixSum;
        }
        totalsum=prefixSum;
    }
    
    public int pickIndex() {
        double target=Math.random()*totalsum;
        int i=0;
        for(;i<prefix.length;i++){
            if(target<prefix[i]){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */