class Solution {
    public int bsearch(int arr[]){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]<1){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return arr.length-s;
    }
    public int[] rowAndMaximumOnes(int[][] mat) {
        for(int row[]:mat){
            Arrays.sort(row);
        }
        int n=mat.length;
        int m=mat[0].length;
        int sum=Integer.MIN_VALUE;
        int ind=-1;
        int ans[]=new int[2];
        for(int arr[]:mat){
            ind++;
            int bs=bsearch(arr);
            if(sum<bs){
                sum=bs;
                ans=new int[]{ind,sum};
            }
        }
        return ans;
    }
}