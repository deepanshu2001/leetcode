class MinStack {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MinStack() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);
        if(st2.isEmpty() || val<=st2.peek()){
            st2.push(val);
        }
    }
    
    public void pop() {
        if(st1.isEmpty()){
            return;
        }
        int elem=st1.peek();
        if(!st2.isEmpty() && st2.peek()==elem){
            st2.pop();
        }
        st1.pop();
    }
    
    public int top() {
        if(st1.isEmpty()){
            return -1;
        }
        int ele=st1.peek();
        return ele;
    }
    
    public int getMin() {
        return st2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */