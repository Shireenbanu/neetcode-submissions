class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        boolean flag = true;
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a'] = arr[ch - 'a'] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            arr[ch - 'a']--;
        }
        for (int item : arr) {
            if (item != 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
