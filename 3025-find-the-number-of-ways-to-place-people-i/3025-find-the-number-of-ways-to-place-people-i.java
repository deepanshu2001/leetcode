class Solution {
    public int numberOfPairs(int[][] points) {
        int ans=0;
        for(int i=0;i<points.length;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            for(int j=0;j<points.length;j++){
                int x2=points[j][0];
                int y2=points[j][1];
                if(i==j){
                    continue;
                }
                if(!(x1<=x2 && y1>=y2)){
                    continue;
                }
                boolean flag=false;
                for(int k=0;k<points.length;k++){
                    int x3=points[k][0];
                    int y3=points[k][1];
                    if(k==i||k==j){
                        continue;
                    }
                    if(x1<=x3 && x3<=x2 && y3<=y1 && y3>=y2){
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    ans++;
                }
            }
        }
        return ans;
    }
}