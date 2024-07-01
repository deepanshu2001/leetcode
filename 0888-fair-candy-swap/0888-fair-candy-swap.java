class Solution {
    public boolean bs(int arr[],int target){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(target==arr[m]){
                return true;
            }
            if(target>arr[m]){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
        return false;
    }
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int alicetotal=0;
        int bobtotal=0;
        int n=aliceSizes.length;
        int m=bobSizes.length;
        for(int i=0;i<n;i++){
            alicetotal+=aliceSizes[i];
        }
        for(int i=0;i<m;i++){
            bobtotal+=bobSizes[i];
        }
        Arrays.sort(bobSizes);
        for(int i=0;i<n;i++){
            int target=(bobtotal-alicetotal+2*aliceSizes[i])/2;
            if(bs(bobSizes,target)){
                return new int[]{aliceSizes[i],target};
            }
        }
        return new int[]{};
    }
}