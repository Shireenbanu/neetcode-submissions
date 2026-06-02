class Solution {
    int maxLength = 0;
    
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int low = 0;
        int high = 0;
        
        while(low<s.length() && high<s.length()){ 
            
            while(high<s.length() && (!set.contains(s.charAt(high)))){
                set.add(s.charAt(high));
                high++;
            }
            maxLength = Math.max(maxLength, set.size());
            
            while((low<high)&& (high<s.length()) && set.contains(s.charAt(high))){
                set.remove(s.charAt(low));
                low++;
            }
        }

        return maxLength;
    }

}

