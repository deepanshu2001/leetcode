class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int i=0;
        while(i<words.length){
            List<String> currentline=getwords(i,words,maxWidth);
            i+=currentline.size();
            ans.add(createLine(currentline,i,words,maxWidth));
        }
        return ans;
    }
    public List<String> getwords(int i,String words[],int maxWidth){
        List<String> currentLine=new ArrayList<>();
        int currlength=0;
        while(i<words.length && currlength+words[i].length()<=maxWidth){
            currentLine.add(words[i]);
            currlength+=words[i].length()+1;
            i++;
        }
        return currentLine;
    }
    public String createLine(List<String> line,int i,String words[],int maxWidth){
       int baseLength=-1;
       for(String s:line){
          baseLength+=s.length()+1;
       }
       int extraspaces=maxWidth-baseLength;
       if(line.size()==1||i==words.length){
         return String .join(" ",line)+" ".repeat(extraspaces);
       }
       int wordcnt=line.size()-1;
       int spacesperword=extraspaces/wordcnt;
       int needsextraspace=extraspaces%wordcnt;
       for(int j=0;j<needsextraspace;j++){
         line.set(j,line.get(j)+" ");
       }
       for(int j=0;j<wordcnt;j++){
        line.set(j,line.get(j)+" ".repeat(spacesperword));
       }
       return String.join(" ",line);
    }
}