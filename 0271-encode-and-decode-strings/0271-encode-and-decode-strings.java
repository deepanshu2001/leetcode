public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str.replace("/","//")).append("/:");
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans=new ArrayList<>();
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<s.length()){
            char ch=s.charAt(i);
            if(i+1<s.length() && ch=='/' && s.charAt(i+1)=='/'){
                sb.append("/");
                i=i+2;
            }
            else if(i+1<s.length()&&ch=='/' && s.charAt(i+1)==':'){
                ans.add(sb.toString());
                sb=new StringBuilder();
                i=i+2;
            }
            else{
                sb.append(ch);
                i++;
            }
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));