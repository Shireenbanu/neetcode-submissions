class Solution {
    public boolean isPalindrome(String s) {
        // char [] str = s.toCharArray();
        // String modifiedStr = "";
        // for(int i = 0; i<s.length(); i++){

        // }
        // StringBuilder str = new StringBuilder();
        // for (int i = 0; i < s.length(); i++) {
        //     if (!((s.substring(i,i+1) >= '0' && s.substring(i,i+1)<= '9')
        //             || (s.substring(i,i+1) >= 'A' && s.substring(i,i+1) <= 'Z')
        //             || (s.substring(i,i+1) >= 'a' && s.substring(i,i+1) <= 'z'))) {
        //         str.deleteCharAt(i);
        //     }
        //     if(str.charAt(i) )

        //     if (i<str.length() && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
        //         str.setCharAt(i, Character.toLowerCase(str.charAt(i)));
        //         // System.out.println("lower: " + str.length());
        //     }
        // }

        StringBuilder str = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char val = s.charAt(i);
            if((val >= '0' && val<= '9')||(val >= 'A' && val <= 'Z')
    ||(val >= 'a' && val <= 'z')){
                  
                    if(val>= 'A' && val <= 'Z'){
                      val=  Character.toLowerCase(val);
                    }
                    str.append(val);
                  }
        }

        // System.out.println(str);
        String cleanedStr = new String(str);
        char[] cleanedStrArr = cleanedStr.toCharArray();
        // System.out.println("cleanedStr: " + Arrays.toString(cleanedStrArr));
        boolean flag = true;
        int ptr1 = 0;
        int ptr2 = cleanedStrArr.length - 1;

        while (ptr1 < ptr2) {
            // System.out.println("cleanedStrArr[ptr1] " + cleanedStrArr[ptr1]);
            if (cleanedStrArr[ptr1] != cleanedStrArr[ptr2]) {
                flag = false;
                break;
            }
            // System.out.println("its a match: " + cleanedStrArr[ptr1] + " " + cleanedStrArr[ptr2]);
            ptr1++;
            ptr2--;
        }
        return flag;
    }
}
