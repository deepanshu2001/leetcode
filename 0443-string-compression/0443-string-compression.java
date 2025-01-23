class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;i++){
            char ch=chars[i];
            int cnt=0;
            int j=i;
            while(j<chars.length && ch==chars[j]){
                cnt++;
                j++;
            }
            i=j-1;
            if(cnt==1){
                sb.append(ch);
            }
            else{
                sb.append(ch);
                sb.append(cnt);
            }
        }
        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}