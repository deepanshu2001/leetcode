class Solution {
    public void bs(String[] products,List<String> temp,String target){
        int s=0;
        int e=products.length-1;
        int start_index=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(products[mid].startsWith(target)){
                start_index=mid;
                e=mid-1;
            }
            else if(products[mid].compareTo(target)<0){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        if(start_index!=-1){
            int cnt=0;
            for(int i=start_index;i<products.length && cnt<3;i++){
                if(products[i].startsWith(target)){
                    cnt++;
                    temp.add(products[i]);
                }
                else{
                    break;
                }
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans=new ArrayList<>();
        String s="";
        for(int i=0;i<searchWord.length();i++){
            s+=searchWord.charAt(i);
            List<String> temp=new ArrayList<>();
            bs(products,temp,s);
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}