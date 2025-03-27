class Solution {
    public int findMajorityElement(List<Integer> nums){
        int cnt=0;
        int elem=-1;
        for(int i=0;i<nums.size();i++){
            if(cnt==0){
                cnt++;
                elem=nums.get(i);
            }
            else if(nums.get(i)==elem){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        return elem;
    }
    public int minimumIndex(List<Integer> nums) {
        int majority_elem=findMajorityElement(nums);
      
        int cnt=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==majority_elem){
                cnt++;
            }
        }
        int xcnt=0;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==majority_elem){
                xcnt++;
            }
            int rem=cnt-xcnt;
            if(xcnt*2>i+1 && rem*2>nums.size()-i-1){
                return i;
            }
        }
        return -1;
    }
}