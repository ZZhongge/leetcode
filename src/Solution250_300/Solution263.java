package Solution250_300;

class Solution263 {
    public boolean isUgly(int num) {
        for (int i=6; i>1 && num>0; i--) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
