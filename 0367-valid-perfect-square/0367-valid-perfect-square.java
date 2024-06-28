class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<=1){
            return true;
        }
        int s=0;
        int e=num;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid<num/mid){
                s=mid+1;
            }
            else if(mid>num/mid){
                e=mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}