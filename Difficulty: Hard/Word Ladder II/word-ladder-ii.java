// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        Set<String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        Queue<ArrayList<String>> queue=new LinkedList<>();
        ArrayList<String> temp=new ArrayList<>();
        temp.add(startWord);
        queue.add(temp);
        int level=0;
        ArrayList<String> usedOnLevel=new ArrayList<>();
        usedOnLevel.add(startWord);
        while(!queue.isEmpty()){
            ArrayList<String> arr=queue.remove();
            String word=arr.get(arr.size()-1);
            if(arr.size()>level){
                level++;
                for(String it:usedOnLevel){
                    set.remove(it);
                }
            }
            if(word.equals(targetWord)){
                if(ans.size()==0){
                    ans.add(arr);
                }
                else if(ans.get(0).size()==arr.size()){
                    ans.add(arr);
                }
            }
            for(int i=0;i<word.length();i++){
                String new_word="";
                for(char ch='a';ch<='z';ch++){
                    new_word=word.substring(0,i)+ch+word.substring(i+1);
                    if(set.contains(new_word)){
                        ArrayList<String> tt=new ArrayList<>(arr);
                        tt.add(new_word);
                        queue.add(tt);
                        usedOnLevel.add(new_word);
                    }
                }
            }
        }
        return ans;
    }
}