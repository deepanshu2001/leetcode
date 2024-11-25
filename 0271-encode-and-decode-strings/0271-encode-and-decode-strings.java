public class Codec {
    String s="";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(String str:strs){
            s+=str;
            s+="π";
        }
        s=s.substring(0,s.length()-1);
        return s;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(ch=='π'){
                ans.add(new String(s.substring(i,j)));
                i=j+1;
                
            }
            j++;
        }
        ans.add(new String(s.substring(i,j)));
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));