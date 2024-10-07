class Solution {
    public String reorganizeString(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        int max=0;
        char letter='a';
        for(int i=0;i<26;i++){
            if(freq[i]>max){
                max=freq[i];
                letter=(char)(i+'a');
            }
        }
        if(max>(s.length()+1)/2){
            return "";
        }
        char ch[]=new char[s.length()];
        int ind=0;
        while(max>0){
            ch[ind]=letter;
            ind=ind+2;
            max--;
        }
        freq[letter-'a']=0;
        for(int i=0;i<26;i++){
            while(freq[i]>0){
                if(ind>=s.length()){
                    ind=1;
                }
                ch[ind]=(char)(i+'a');
                ind=ind+2;
                freq[i]--;
                
            }
        }

        String str="";
        for(int i=0;i<ch.length;i++){
            str+=ch[i];
        }
        return str;
    }
}