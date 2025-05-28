class Solution {
    class PAIR{
        String first;
        int second;
        PAIR(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<PAIR> q=new LinkedList<>();
        q.add(new PAIR(beginWord,1));
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        while(!q.isEmpty()){
            PAIR pair=q.remove();
            String word=pair.first;
            int second=pair.second;
            if(word.equals(endWord)){
                return second;
            }
            
            for(int i=0;i<word.length();i++){
               String new_word="";
               for(char ch='a';ch<='z';ch++){
                new_word=word.substring(0,i)+ch+word.substring(i+1);
                if(set.contains(new_word)){
                    q.add(new PAIR(new_word, second+1));
                    set.remove(new_word);
                }
               }

            }
        }
        return 0;
    }
}