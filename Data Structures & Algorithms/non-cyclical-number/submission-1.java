class Solution {
    public boolean isHappy(int n) {
        int num = n;
        int sum =0;
        HashSet<Integer> set = new HashSet<>();
        while(true){
            sum = 0;
            while(num !=0){
                int last = num%10;
                 num = num/10;

                sum = sum + (last*last);
                // System.out.println("num = "+ num);

            }
            if(sum == 1){
                return true;
            }

            if(set.contains(sum)){
                return false;
            }

            num = sum;
            set.add(sum);
     
        }
    }
}
