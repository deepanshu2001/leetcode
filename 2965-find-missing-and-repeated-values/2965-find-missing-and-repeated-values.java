class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer,Integer> map=new HashMap<>();
        int a=0;
        int b=0;
        int n=grid.length;
        boolean flag=false;
        for(int arr[]:grid){
            for(int num:arr){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        for(int i=1;i<=n*n;i++){
          if(!map.containsKey(i)){
            b=i;
          }
          else if(map.get(i)==2){
            a=i;
          }
        }
        return new int[]{a,b};
    }
}