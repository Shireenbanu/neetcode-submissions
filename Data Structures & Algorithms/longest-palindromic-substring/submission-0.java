class Solution {
    public String longestPalindrome(String s) {
        String res = "";
       
        for(int i=0; i<s.length(); i++){
            String oddRes = palindromeCheck(s, i,i);
            if(res.length()<oddRes.length()){
                res = oddRes;
            }
            String evenRes = palindromeCheck(s, i, i+1);
             if(res.length()<evenRes.length()){
                res = evenRes;
            }
            
        }
        
        return res;
    }

    public String palindromeCheck(String s, int low, int high){
        String res = "";
        // odd check:
   
        while(low>=0 && high<s.length()){

            if(s.charAt(low) == s.charAt(high)){
                res = s.substring(low, high+1);
                low--;
                high++;
             
            }
            else
            {
                break;
            }
        }

        // System.out.println(" length: "+ res);

        return res;

    }
}
