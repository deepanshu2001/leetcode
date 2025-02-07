class Solution {
    public void swap(int i,int j,char []arr){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int minMovesToMakePalindrome(String s) {
        char arr[]=s.toCharArray();
        int i=0;
        int ans=0;
        int j=s.length()-1;
        while(i<j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }
            else{
                char ch=arr[i];
                int k=j-1;
                while(arr[k]!=ch){
                    k--;
                }
                ans+=j-k;
                int swapped=j-k;
                while(swapped>0){
                    swap(k,k+1,arr);
                    k++;
                    swapped--;
                }
                i++;
                j--;
            }
        }
        return ans;
    }
}