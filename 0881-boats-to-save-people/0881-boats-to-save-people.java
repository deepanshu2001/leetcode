class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if(people.length==0){
            return 0;
        }
        int boats=1;
        int num_of_people=0;
        int sum=0;
        for(int i=0;i<people.length;i++){
            sum+=people[i];
            num_of_people++;
            if(sum>limit||num_of_people>2){
                boats++;
                sum=people[i];
                num_of_people=1;
            }
        }
        return boats;
    }
}