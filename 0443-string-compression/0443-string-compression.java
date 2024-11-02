class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;i++){
            char ch=chars[i];
            int j=i;
            int cnt=0;
            while(j<chars.length && ch==chars[j]){
               cnt++;
               j++;
            }
            if(cnt==1){
                sb.append(ch);
            }
            else if(cnt>1){
                sb.append(ch);
                sb.append(cnt);
                i=j-1;
            }
        }
        char []arr=new char[sb.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=sb.charAt(i);
        }
        for(int i=0;i<arr.length;i++){
            chars[i]=arr[i];
        }
        return arr.length;
    }
}