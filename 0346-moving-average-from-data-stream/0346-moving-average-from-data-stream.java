class MovingAverage {
    int size;
    List<Integer> list=new ArrayList<>();
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        double ans=0.0;
        list.add(val);
        if(list.size()==1){
            ans=val*1.0/1;
        }
        else if(list.size()<size){
            for(int i=0;i<list.size();i++){
                ans+=list.get(i);
            }
            ans=ans*1.0/list.size();
        }
        else{
            for(int i=list.size()-1;i>=list.size()-size;i--){
                ans+=list.get(i);
            }
            ans=ans*1.0/size;
        }
        return ans;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */