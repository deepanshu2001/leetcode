class Solution {
    public boolean possible(int houses[],int heaters[],int radius){
        int j=0;
        for(int i=0;i<heaters.length;i++){
            while(j<houses.length && Math.abs(houses[j]-heaters[i])<=radius){
                j++;
            }
            if(j==houses.length){
                return true;
            }
        }
        return false;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int s=0;
        int ans=-1;
        int e=(int)Math.pow(10,9);
        while(s<=e){
            int mid=s+(e-s)/2;
            if(possible(houses,heaters,mid)){
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