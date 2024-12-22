class Solution {
    public int[] plusOne(int[] digits) {
        int ans=0;
        int arr[];
        if(digits[digits.length-1]==9 && digits[0]==9){
            arr=new int[digits.length+1];
        }
        else{
            arr=new int[digits.length];
        }
        for(int i=0;i<digits.length;i++){
            ans=ans*10+digits[i];
        }
        ans+=1;
        for(int i=arr.length-1;i>=0;i--){
            arr[i]=ans%10;
            ans=ans/10;
        }
        return arr;
    }
}