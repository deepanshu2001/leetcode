class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y==target){
            return true;
        }
        if(x+y<target){
            return false;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        Set<String> set=new HashSet<>();
        while(!q.isEmpty()){
            Pair pair=q.remove();
            int x1=pair.first;
            int y1=pair.second;
            if(x1+y1==target){
                return true;
            }
            set.add(x1+"->"+y1);
            //case1 empty x;
            int new_x=0;
            int new_y=y1;
            if(!set.contains(new_x+"->"+new_y)){
                q.add(new Pair(new_x,new_y));
            }
            //case 2 empty y;
            new_x=x1;
            new_y=0;
            if(!set.contains(new_x+"->"+new_y)){
                q.add(new Pair(new_x,new_y));
            }
            //case 3 fill x completely
            new_x=x;
            new_y=y1;
            if(!set.contains(new_x+"->"+new_y)){
                q.add(new Pair(new_x,new_y));
            }
            //case 4 fill y completely
            new_x=x1;
            new_y=y;
            if(!set.contains(new_x+"->"+new_y)){
                q.add(new Pair(new_x,new_y));
            }
            //case 5 x->y x fills y;
            new_x=x1-Math.min(x1,y-y1);
            new_y=y1+Math.min(x1,y-y1);
            if(!set.contains(new_x+"->"+new_y)){
                q.add(new Pair(new_x,new_y));
            }
            //case 6 x<-y y fills x completely
            new_x=x1+Math.min(y1,y-y1);
            new_y=y1-Math.min(y1,x-x1);
            if(!set.contains(new_x+"->"+new_y)){
                q.add(new Pair(new_x,new_y));
            }
        }
        return false;
    }
}