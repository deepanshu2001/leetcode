class Solution {
    class Pair{
        String first;
        int second;
        public Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        Set<String> s=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            s.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        if(s.contains(beginWord)){
            s.remove(beginWord);
        }
        while(!q.isEmpty()){
            Pair p=q.remove();
            String word=p.first;
            int level=p.second;
            if(word.equals(endWord)){
                return level;
            }
            for(int i=0;i<word.length();i++){
                String new_word="";
                for(char ch='a';ch<='z';ch++){
                    new_word=word.substring(0,i)+ch+word.substring(i+1);
                    if(s.contains(new_word)){
                    q.add(new Pair(new_word,level+1));
                    s.remove(new_word);
                }
                }
                
            }
        
        }
        return 0;
    }
}