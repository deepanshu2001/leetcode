class Solution {
    public int openLock(String[] deadends, String target) {
        Map<Character,Character> nextSlot=Map.of(
           '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        Map<Character,Character> prevSlot=Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );
        int cnt=0;
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")){
            return -1;
        }
        queue.add("0000");
        visited.add("0000");
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
              String curr=queue.poll();
              if(curr.equals(target)){
                return cnt;
              }
              for(int wheel=0;wheel<4;wheel++){
                StringBuilder sb=new StringBuilder(curr);
                sb.setCharAt(wheel,nextSlot.get(sb.charAt(wheel)));
                if(!visited.contains(sb.toString())){
                    queue.add(sb.toString());
                    visited.add(sb.toString());
                }
                sb=new StringBuilder(curr);
                sb.setCharAt(wheel,prevSlot.get(sb.charAt(wheel)));
                if(!visited.contains(sb.toString())){
                    visited.add(sb.toString());
                    queue.add(sb.toString());
                }
              }
            }
            cnt++;
        }
        return -1;
        
    }
}