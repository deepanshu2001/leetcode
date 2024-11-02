class Solution {
    public int findTheLongestSubstring(String s) {
        int arr[]=new int[32];
        Arrays.fill(arr,-2);
        arr[0]=-1;
        int mask=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            switch (ch) {
                case 'a':
                    mask^=1;
                    break;
                
                case 'e':
                    mask^=2;
                    break;
                
                case 'i':
                    mask^=4;
                    break;

                case 'o':
                    mask^=8;
                    break;

                case 'u':
                    mask^=16;
                    break;
            }
            int prev=arr[mask];
            if(prev==-2){
                arr[mask]=i;
            }
            else{
                ans=Math.max(ans,i-prev);
            }
        }
        return ans;
        
    }
}