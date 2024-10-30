class Solution {
    public int findMinDifference(List<String> timePoints) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<timePoints.size();i++){
            for(int j=i+1;j<timePoints.size();j++){
                int ind1=timePoints.get(i).indexOf(":");
                int ind2=timePoints.get(j).indexOf(":");
                String s1=timePoints.get(i).substring(0,ind1)+timePoints.get(i).substring(ind1+1);
                String s2=timePoints.get(j).substring(0,ind2)+timePoints.get(j).substring(ind2+1);
                Integer cal=Math.abs(Integer.parseInt(s1)-Integer.parseInt(s2));
                int c=cal%100+(cal/100)*60;
                ans=Math.min(ans,c);
                if(s2.equals("0000")){
                    cal=Math.abs(Integer.parseInt(s1)-2360);
                    c=cal%100+(cal/100)*60;
                    ans=Math.min(ans,c);
                }
                
            }
        }
        return ans;
    }
}