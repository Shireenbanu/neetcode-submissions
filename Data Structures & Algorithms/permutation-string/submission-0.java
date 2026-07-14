class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        int runningFreq[] = new int[26];

        int len = 0;

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        int counter = 0;
        int low = 0;

        for (int i = 0; i < s2.length(); i++) {
            runningFreq[s2.charAt(i) - 'a']++;

            if ((i - low) == (s1.length() - 1)) {
                // System.out.println("length match: " + (i - low));
                // System.out.println(Arrays.toString(runningFreq));
                if (freq1[s2.charAt(i) - 'a'] == runningFreq[s2.charAt(i) - 'a']) {
                    int j = 0;
                    // System.out.println("i = "+ i);
                    while (j < s1.length()
                        && (freq1[s1.charAt(j) - 'a'] == runningFreq[s1.charAt(j) - 'a'])) {
                        // System.out.println("Its a match: ");
                        // System.out.println("freq: "+ s1.charAt(j));
                        j++;
                    }
                    if (j == s1.length()) {
                        return true;
                    }


                } 
                    // System.out.println("(i - low) "+ (i - low));
                    runningFreq[s2.charAt(low) - 'a']--;
                    low++;
                
            }
        }

        if (counter == s1.length()) {
            return true;
        }
        return false;
    }
}
