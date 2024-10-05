class Solution {
    public boolean Compare(int num1,int num2){
        String s1=String.valueOf(num1)+String.valueOf(num2);
        String s2=String.valueOf(num2)+String.valueOf(num1);
        return s1.compareTo(s2)>0;
    }
    public int[] merge(int arr1[],int arr2[]){
        int mix[]=new int[arr1.length+arr2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if(Compare(arr1[i],arr2[j])){
                mix[k]=arr1[i];
                i++;
                k++;
            }
            else{
                mix[k]=arr2[j];
                j++;
                k++;
            }
        }
        while(i<arr1.length){
            mix[k]=arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length){
            mix[k]=arr2[j];
            j++;
            k++;
        }
        return mix;
    }
    public int[] sort(int nums[]){
        if(nums.length==1){
            return nums;
        }
        int mid=nums.length/2;
        int left[]=sort(Arrays.copyOfRange(nums,0,mid));
        int right[]=sort(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }
    public String largestNumber(int[] nums) {
        int arr[]=sort(nums);
        String str[]=new String[nums.length];
        String ans="";
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(arr[i]);
        }
        for(int i=0;i<nums.length;i++){
            ans+=str[i];
        }
        return ans.startsWith("0")?"0":ans;
    }
}