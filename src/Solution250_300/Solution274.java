package Solution250_300;

class Solution274 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int[] bucket = new int[citations.length+1];
        for (int i : citations) {
            if (i >= citations.length) {
                bucket[citations.length]++;
            }
            else {
                bucket[i]++;
            }
        }

        int sum = 0;
        for (int i = citations.length; i >= 1; i--) {
            sum += bucket[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
