class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
       
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<wordsDict.length;i++){
            if(word1.equals(wordsDict[i])){
                for(int j=i+1;j<wordsDict.length;j++){
                    if(word2.equals(wordsDict[j])){
                       ans=Math.min(ans,j-i);
                    }
                }
            }
        }
        for(int i=0;i<wordsDict.length;i++){
            if(word2.equals(wordsDict[i])){
                for(int j=i+1;j<wordsDict.length;j++){
                    if(word1.equals(wordsDict[j])){
                       ans=Math.min(ans,j-i);
                    }
                }
            }
        }
        return ans;
    }
}