class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int []> list=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            int id1=nums1[i][0];
            int id2=nums2[j][0];
            if(id1==id2){
               list.add(new int[]{id1,nums1[i][1]+nums2[j][1]});
               i++;
               j++;
            }
            else if(id1<id2){
                list.add(new int[]{id1,nums1[i][1]});
                i++;
            }
            else{
                 list.add(new int[]{id2,nums2[j][1]});
                 j++;
            }
        }
        while(i<nums1.length){
            list.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while(j<nums2.length){
            list.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        int ans[][]=new int[list.size()][2];
        
        int k=0;
        for(int l=0;l<list.size();l++){
            ans[k][0]=list.get(l)[0];
            ans[k][1]=list.get(l)[1];
            k++;
        }
        return ans;
    }
}