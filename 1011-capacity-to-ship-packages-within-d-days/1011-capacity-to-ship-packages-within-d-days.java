class Solution {
    public int shipWithinDays(int[] weights, int days) {
       
       int max =Integer.MIN_VALUE;
       int add=0;
       int ans=0;
       for(int i=0;i<weights.length;i++){
        max=Math.max(max,weights[i]);
        add+=weights[i];
       }
       
       int s=max;
       int e=add;
       while(s<=e){
        int mid=s+(e-s)/2;
        int sum=0;
        int i=0;
        int d=0;
        while(i<weights.length){
            while(sum<=mid && i<weights.length){
                sum+=weights[i];
                i++;
            }
           d++;
           
           if(sum>mid){
              
              sum=0;
              i--;
           }
        }
        if(d<=days){
            ans=mid;
            e=mid-1;
        }
        else{
            s=mid+1;
        }
        
       }
       return ans;
    }
}