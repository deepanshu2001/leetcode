class Solution {
    public int candy(int[] ratings) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<ratings.length;i++){
            if(i==0){
                map.put(i,1);
                continue;
            }
            if(ratings[i]>ratings[i-1]){
               map.put(i,map.get(i-1)+1);
            }
            else{
                map.put(i, 1);
            }

        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                map.put(i,map.get(i+1)+1);
            }
        }
        int cnt=0;
        for(int i=0;i<ratings.length;i++){
            cnt+=map.get(i);
        }
        return cnt;
    }
}