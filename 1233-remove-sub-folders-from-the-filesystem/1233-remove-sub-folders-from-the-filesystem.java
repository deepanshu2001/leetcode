class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans=new ArrayList<>();
        Arrays.sort(folder);
        ans.add(folder[0]);
        for(int i=1;i<folder.length;i++){
            String s=folder[i];
            String pre=ans.get(ans.size()-1)+"/";
            if(!s.startsWith(pre)){
                ans.add(s);
            }
        }
        return ans;
    }
}