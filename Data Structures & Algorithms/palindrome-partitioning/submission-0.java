class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> res = new ArrayList<>();
     recurPartition(s, 0, new ArrayList<>(), res);
     return res;   
    }

    public void recurPartition(String s, int start, List<String> list, List<List<String>> res){
        // System.out.println("Start List: "+ list+ " start: "+ start);
        if(start == s.length()){
            res.add(new ArrayList(list));
            // System.out.println("Nothing to check: "+ list);
            return;
        }

        for(int i=start; i<s.length(); i++){
            // System.out.println("i = "+ i+ " start: "+ start);
           if (isPalindrome(s.substring(start, i+1))){
            // System.out.println("its a palindrome: "+s.substring(start, i+1));
            list.add(s.substring(start,i+1));
            recurPartition(s, i+1, list, res);
            list.remove(s.substring(start,i+1));
           }
        }
        // System.out.println("End List: "+ list+ " start: "+ start);
    }

    public boolean isPalindrome(String s){

        boolean flag = false;
        int start =0;
        int end = s.length()-1;
        
        while(start<=end){
            
            if(s.charAt(start)!=s.charAt(end)){
                flag = false;
                break;
            }
            flag = true;

            start++;
            end--;
        }

        return flag;

    }
}
