class Solution {
    public int helper(int mat[][],int n,int m,int col){
        int ind=-1;
        int max=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col]>max){
                max=mat[i][col];
                ind=i;
            }
        }
        return ind;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int s=0;
        int e=m-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            int maxIndex=helper(mat,n,m,mid);
            int left=mid-1>=0?mat[maxIndex][mid-1]:-1;
            int right=mid+1<m?mat[maxIndex][mid+1]:-1;
            if(mat[maxIndex][mid]>left && mat[maxIndex][mid]>right){
                return new int[]{mid,maxIndex};
            }
            else if(mat[maxIndex][mid]>left){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}