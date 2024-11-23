class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        List<int []> list=new ArrayList<>();
        int i=0;
        int j=skill.length-1;
        while(i<j){
            list.add(new int[]{skill[i],skill[j]});
            i++;
            j--;
        }
        int arr[]=list.get(0);
        int sum=arr[0]+arr[1];
        for(int k=1;k<list.size();k++){
            int array[]=list.get(k);
            int s=array[0]+array[1];
            if(sum!=s){
                return -1;
            }
        }
        long ans=0;
        for(i=0;i<list.size();i++){
            ans+=list.get(i)[0]*list.get(i)[1];
        }
        return ans;
        
    }
}