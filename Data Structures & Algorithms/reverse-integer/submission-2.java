class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        long rev = x;

        if (rev < 0) {
            isNegative = true;
            rev = rev * -1;
            System.out.println("its is leass than zero" + x);
        }

        StringBuilder val = new StringBuilder(Long.toString(rev));

        rev = Long.valueOf(val.reverse().toString());

        if (isNegative) {
            rev = rev * -1;
        }
        // System.out.println("sdf: "+ rev);

        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            rev = 0;
        }

        return (int) rev;
    }
}
