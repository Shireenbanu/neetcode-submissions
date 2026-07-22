class MinStack {
    Deque<Integer> minStack = null;
    Deque<Integer> min = null;

    public MinStack() {
     minStack = new ArrayDeque<>();
     min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        
        minStack.push(val);
        // System.out.println("pushing: "+val);
        if(min.size() == 0){
            min.push(val);
        }
        else
        {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            while(min.size()>0 && min.peek()<val){
                stack.push(min.pop());
                
            }
            min.push(val);

            while(stack.size()>0){
                min.push(stack.pop());
            }
        }

        System.out.println(" min: "+ min);
    }
    
    public void pop() {

        Deque<Integer> stack = new ArrayDeque<Integer>();
        while(min.size()>0 && !((min.peek()).equals(minStack.peek()))){
            stack.push(min.pop());
        }
        if(min.size()>0){
            min.pop();
        }
        minStack.pop();
        while(stack.size()!=0){
            min.push(stack.pop());
        }        
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
