class Solution {
    public int characterReplacement(String s, int k) {
        
        int freq[] = new int[26];
        Set<Character> set = new HashSet<>();

        int start =0;
        int larg = 0;
        for(int i=0; i<s.length(); i++){
         int index = Integer.valueOf(s.charAt(i)) - 65;
        //  System.out.println("index "+index); 
      
        if(set.contains(s.charAt(i))){
            int val = freq[index];
            freq[index] = val+1;
        }
        else
        {
            set.add(s.charAt(i));
            freq[index] = 1;
        }

        if(set.size()>1){
            while(!(isValidWindow(freq,set,k))){
                // System.out.println("invalid checks, start: "+ start);
                int remove_index = Integer.valueOf(s.charAt(start))-65;
                int remove_val = freq[remove_index];
                freq[remove_index] = remove_val -1;
                if(freq[remove_index] == 0){
                    set.remove(s.charAt(start));
                    // System.out.println("removing: "+ s.charAt(start));
                }
                start++;
            }
        }

        larg = Math.max(larg,(i-start+1));
        // System.out.println("larg = "+larg); 
     }
        // System.out.println(Arrays.toString(freq));
        // System.out.println("isValidWindow: "+ isValidWindow(freq,set,k));

        return larg;
    }

    public boolean isValidWindow(int [] freq, Set<Character> set, int k ){

        int sum =0;
        int max = 0;
        for(Character item: set){
            // System.out.println("inside the wind: "+ item);
            int index = Integer.valueOf(item)-65;
            max = Math.max(max,freq[index]);
            sum = sum +freq[index];
            
        }
            // System.out.println("sum is: "+ sum + " max: "+max);
            int res = sum - max;
            if(res<=k){
                return true;
            }

    return false;
    }
}
