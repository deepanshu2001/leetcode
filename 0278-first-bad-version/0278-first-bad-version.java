/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int ans=0;
        int s=1;
        int e=n;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(isBadVersion(mid)==false){
                s=mid+1;
            }
            else{
                ans=mid;
                e=mid-1;
            }
        }
        return ans;
    }
}