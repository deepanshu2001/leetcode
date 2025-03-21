



class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set=new HashSet<>();
        List<String> ans=new ArrayList<>();
        for(String supp:supplies){
            set.add(supp);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<recipes.length;i++){
           q.add(i);
        }
        int last_size=-1;
        while(set.size()>last_size){
            last_size=set.size();
            int q_size=q.size();
            while(q_size-->0){
               boolean can_be_made=true;
               int recipe_ind=q.remove();
               for(String ingr:ingredients.get(recipe_ind)){
                if(!set.contains(ingr)){
                    can_be_made=false;
                    break;
                }
               }
               if(!can_be_made){
                q.add(recipe_ind);
               }
               else{
                ans.add(recipes[recipe_ind]);
                set.add(recipes[recipe_ind]);
               }
            }
        }
        
        
        return ans;
    }
}