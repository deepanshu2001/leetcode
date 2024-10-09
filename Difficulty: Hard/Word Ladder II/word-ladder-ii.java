//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        if(!set.contains(targetWord)){
            return ans;
        }
        Queue<ArrayList<String>> queue=new LinkedList<>();
        ArrayList<String> temp=new ArrayList<>();
        temp.add(startWord);
        queue.add(temp);
        ArrayList<String> usedOnlevel=new ArrayList<>();
        usedOnlevel.add(startWord);
        int level=0;
        while(!queue.isEmpty()){
            ArrayList<String> arr=queue.remove();
            String word=arr.get(arr.size()-1);
           
            if(arr.size()>level){
                level++;
                for(String it:usedOnlevel){
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
                        arr.add(new_word);
                        queue.add(new ArrayList<>(arr));
                        usedOnlevel.add(new_word);
                        arr.remove(arr.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}