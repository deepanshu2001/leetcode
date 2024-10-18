class Solution {
    public int candy(int[] ratings) {
        int ans[]=new int[ratings.length];
        Arrays.fill(ans, 1);
        boolean haschange=true;
        while(haschange){
            haschange=false;
            for(int i=0;i<ratings.length;i++){
                if(i!=ratings.length-1 && ratings[i]>ratings[i+1] && ans[i]<=ans[i+1]){
                    haschange=true;
                    ans[i]=ans[i+1]+1;
                }
                if(i>0 && ratings[i]>ratings[i-1] && ans[i]<=ans[i-1]){
                    haschange=true;
                    ans[i]=ans[i-1]+1;
                }
            }

        }
        int cnt=0;
        for(int i=0;i<ratings.length;i++){
            cnt+=ans[i];
        }
        return cnt;
    }
}