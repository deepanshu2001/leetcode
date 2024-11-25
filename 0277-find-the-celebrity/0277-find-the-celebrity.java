/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && knows(i,j)==true){
                   adj.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(adj.get(i).isEmpty()){
                boolean is_celebrity=true;
                for(int j=0;j<n;j++){
                    if(i!=j && knows(j,i)==false){
                      is_celebrity=false;
                      break;
                    }
                }
                if(is_celebrity){
                    return i;
                }
            }
        }
        return -1;

    }
}