
import java.util.Collection;class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(freq[i]);
            }
        }
        int time=0;
        while(!pq.isEmpty()){
            int cycle=n+1;
            int totaltask=0;
            List<Integer> list=new ArrayList<>();
            while(cycle>0 && !pq.isEmpty()){
                int maxF=pq.remove();
                if(maxF>1){
                    list.add(maxF-1);
                }
                cycle--;
                totaltask++;
            }
            pq.addAll(list);
            time+=pq.isEmpty()?totaltask:n+1;
        }
        return time;
    }
}