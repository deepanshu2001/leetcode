class Solution {
    public boolean Compare(int num1,int num2){
        String s1=String.valueOf(num1)+String.valueOf(num2);
        String s2=String.valueOf(num2)+String.valueOf(num1);
        return s1.compareTo(s2)>0;
    }
    public void merge(int nums[],int s,int mid,int e){
        int mix[]=new int[e-s+1];
        int i=s;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=e){
            if(Compare(nums[i],nums[j])){
                mix[k]=nums[i];
                i++;
                k++;
            }
            else{
                mix[k]=nums[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            mix[k]=nums[i];
            i++;
            k++;
        }
        while(j<=e){
            mix[k]=nums[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            nums[l+s]=mix[l];
        }
    }
    public void sort(int nums[],int s,int e){
        if(s>=e){
            return;
        }
        int mid=s+(e-s)/2;
        sort(nums, s,mid);
        sort(nums,mid+1,e);
        merge(nums,s,mid,e);
    }
    public String largestNumber(int[] nums) {
        sort(nums,0,nums.length-1);
        String str[]=new String[nums.length];
        String ans="";
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            ans+=str[i];
        }
        return ans.startsWith("0")?"0":ans;
    }
}