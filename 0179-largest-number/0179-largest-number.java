

import static java.lang.Integer.compare;

class Solution {
    public String largestNumber(int[] nums) {
        String str[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(str,(a,b)->{
            return (b+a).compareTo(a+b);
        });
        String ans="";
        
        for(int i=0;i<str.length;i++){
            ans+=str[i];
        }
        return ans.startsWith("0")?"0":ans;

    }
}