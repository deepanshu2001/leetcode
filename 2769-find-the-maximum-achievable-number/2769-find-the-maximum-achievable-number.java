class Solution {
    public int theMaximumAchievableX(int num, int t) {
        int n1=num;
        int t1=t;
        int ans=0;
        while(t1>0){
            n1--;
            n1--;
            t1--;
        }
        ans=Math.max(ans,n1);
        n1=num;
        t1=t;
        while(t1>0){
            n1--;
            n1++;
            t1--;
        }
        ans=Math.max(ans,n1);
        n1=num;
        t1=t;
        while(t1>0){
            n1++;
            n1++;
            t1--;
        }
        ans=Math.max(ans,n1);
        n1=num;
        t1=t;
        while(t1>0){
            n1++;
            n1--;
            t1--;
        }
        ans=Math.max(ans,n1);
        return ans;
    }
}