class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s=0;
        int e=numbers.length-1;
        while(s<=e){
            if(numbers[s]+numbers[e]<target){
                s=s+1;
            }
            else if(numbers[s]+numbers[e]>target){
                e=e-1;
            }
            else{
                return new int[]{s+1,e+1};
            }
        }
        return new int[]{-1,-1};
    }
}