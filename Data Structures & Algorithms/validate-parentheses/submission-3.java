class Solution {
    public boolean isValid(String s) {
     char openBrackets[] = new char[]{'(','{', '['};
     char closedBrackets[] = new char[]{')','}',']'};



     Deque<Integer> deq = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            // push
            int j = 0;
            while(j<openBrackets.length){
                if(s.charAt(i) ==openBrackets[j]){
                    deq.push(j);
                    break;
                }
                j++;
            }

            int k =0;
              while(k<closedBrackets.length){
                if(s.charAt(i) ==closedBrackets[k]){
                    // System.out.println("closedBrackets: "+ s.charAt(i));
                    if(deq.size() == 0){
                        return false;
                    }
                    
                    if(k == deq.peek()){
                        // System.out.println("same index: "+ deq + " k = "+ k+ "s.charAt(i) = "+s.charAt(i));
                        deq.pop();
                    }else
                    {
                        return false;
                    }   
                    
                    break;
                }
                k++;
            }
        }

        if(deq.size() == 0){
            return true;
        }

     return false;
    }
}
