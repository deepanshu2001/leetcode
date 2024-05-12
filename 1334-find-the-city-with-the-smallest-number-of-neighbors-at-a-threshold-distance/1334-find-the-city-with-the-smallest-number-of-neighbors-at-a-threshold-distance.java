class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        int m=edges.length;
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  dist[i][j]=Integer.MAX_VALUE;
              }
          }
          for(int j=0;j<m;j++){
              
              int u=edges[j][0];
              int v=edges[j][1];
              int wt=edges[j][2];
              dist[u][v]=wt;
              dist[v][u]=wt;
              
              
          }
          for(int i=0;i<n;i++){
              dist[i][i]=0;
          }
          for(int k=0;k<n;k++){
              for(int i=0;i<n;i++){
                  for(int j=0;j<n;j++){
                      if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                      dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                  }
              }
          }
          int city=-1;
          int citycnt=distanceThreshold+1;
          for(int i=0;i<n;i++){
              int cnt=0;
              for(int j=0;j<n;j++){
                  if(dist[i][j]<=distanceThreshold){
                      cnt++;
                  }
              }
              if(cnt<=citycnt){
                  citycnt=cnt;
                  city=i;
              }
          }
          return city;
    }
}