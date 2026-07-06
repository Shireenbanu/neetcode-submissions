class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[123];
        int max = 0;
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            freq[ch]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] > 0) {
                StringBuilder index = recursiveSubSeq(i, s, t, freq);
                // System.out.println(" i = " + i + " index = " + index);
                if (!index.isEmpty()) {
                    if (res.isEmpty() || res.length() > index.length()) {
                        res = index;
                    }
                }
            }
        }
        return res.toString();
    }

    public StringBuilder recursiveSubSeq(int runningInd, String s, String t, int freq[]) {
        int newFreq[] = freq.clone();
        int counter = 0;
        StringBuilder sb = new StringBuilder("");
        int i = runningInd;
        while (i < s.length()) {
            if (newFreq[s.charAt(i)] > 0) {
                newFreq[s.charAt(i)]--;
                counter++;
                // System.out.println("found: " + s.charAt(i) + " index = " + runningInd);
            }

            sb.append(s.charAt(i));
            if (counter == t.length()) {
                break;
            }
            i++;
        }

        if (counter == t.length()) {
            return sb;
        }

        return new StringBuilder("");
    }

    // public int checkForMatch(String s, int runningIndex, )
}
