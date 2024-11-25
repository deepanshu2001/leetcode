public class Codec {
    StringBuilder sb=new StringBuilder();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        for(String str:strs){
            sb.append(str.replace("/","//")).append("/:");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans=new ArrayList<>();
        int j=0;
        StringBuilder sb=new StringBuilder();
        while(j<s.length()){
           char ch=s.charAt(j);
           if(j+1<s.length() && ch=='/' && s.charAt(j+1)=='/'){
             sb.append(ch);
             j=j+2;
           }
           else if(j+1<s.length() && ch=='/' && s.charAt(j+1)==':'){
            ans.add(sb.toString());
            sb=new StringBuilder();
            j=j+2;
           }
           else{
            sb.append(ch);
            j++;
           }
        }
      
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));