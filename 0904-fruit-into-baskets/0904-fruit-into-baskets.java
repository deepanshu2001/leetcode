class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        int ans=0;
        int k=2;
        Map<Integer,Integer> map=new HashMap<>();
        while(j<fruits.length){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size()<k){
                j++;
            }
            else if(map.size()==k){
                ans=Math.max(j-i+1,ans);
                j++;
            }
            else if(map.size()>k){
                while(map.size()>k){
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i])==0){
                        map.remove(fruits[i]);
                    }
                    i++;
                }
                j++;
            }
            
        }
        int sum=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
               int value=m.getValue();
               sum+=value;
            }
        return Math.max(ans,sum);
    }
}