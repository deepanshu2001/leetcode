/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate=0;
        for(int i=1;i<n;i++){
            if(i!=candidate && knows(candidate,i)){
                candidate=i;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=candidate){
                if(!knows(i,candidate)||knows(candidate,i)==true){
                    return -1;
                }
            }
        }
        return candidate;
    }
}