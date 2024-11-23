class Solution {
    public int[] findCordinates(int cell,int n){
        int row=n-1-(cell-1)/n;
        int col=(cell-1)%n;
        if((n-row)%2==0){
            col=n-1-col;
        }
        return new int[]{row,col};
    }
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        boolean visited[]=new boolean[n*n+1];
        int dice_rolls=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            dice_rolls++;
            for(int i=0;i<size;i++){
                int curr_cell=queue.poll();
                for(int dice=1;dice<=6;dice++){
                    int next_cell=curr_cell+dice;
                    if(next_cell>n*n){
                        break;
                    }
                    int []position=findCordinates(next_cell,n);
                    int row=position[0];
                    int col=position[1];
                    if(board[row][col]!=-1){
                        next_cell=board[row][col];
                    }
                    if(next_cell==n*n){
                        return dice_rolls;
                    }
                    if(!visited[next_cell]){
                        visited[next_cell]=true;
                        queue.add(next_cell);
                    }
                }
            }
        }
        return -1;
    }
}