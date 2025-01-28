class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<Pair> queue=new LinkedList<>();
        if(x+y==target){
            return true;
        }
        if(x+y<target){
            return false;
        }
        queue.add(new Pair(0,0));
        Set<String> set=new HashSet<>();
        while(!queue.isEmpty()){
            Pair p=queue.remove();
            int curr_x=p.first;
            int curr_y=p.second;
            if(curr_x+curr_y==target){
                return true;
            }
            set.add(curr_x+","+curr_y);
            //case 1 x->y
            int new_x=curr_x-Math.min(curr_x,y-curr_y);
            int new_y=curr_y+Math.min(curr_x,y-curr_y);
            if(!set.contains(new_x+","+new_y)){
                queue.add(new Pair(new_x,new_y));
            }
            new_x=0;
            new_y=0;
            //case 2 x<-y
            new_x=curr_x+Math.min(curr_x,x-curr_x);
            new_y=curr_y-Math.min(curr_y,x-curr_x);
            if(!set.contains(new_x+","+new_y)){
                queue.add(new Pair(new_x,new_y));
            }
            new_x=0;
            new_y=0;
            //case 3 empty x;
            new_x=0;
            new_y=curr_y;
            if(!set.contains(new_x+","+new_y)){
                queue.add(new Pair(new_x,new_y));
            }
           
            new_x=0;
            new_y=0;
             //case 4 empty y;
             new_x=curr_x;
             new_y=0;
             if(!set.contains(new_x+","+new_y)){
                queue.add(new Pair(new_x,new_y));
             }
             new_x=0;
             new_y=0;
             //case 5 fill x complexty;
             new_x=x;
             new_y=curr_y;
             if(!set.contains(new_x+","+new_y)){
                queue.add(new Pair(new_x,new_y));
             }

             new_x=0;
             new_y=0;
             //case 6 fill y complexty;
             new_x=curr_x;
             new_y=y;
             if(!set.contains(new_x+","+new_y)){
                queue.add(new Pair(new_x,new_y));
             }


            
            
        }
        return false;
    }
}