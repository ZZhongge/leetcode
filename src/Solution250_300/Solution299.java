package Solution250_300;

///之前提到的字符串遍历转char[]，遍历两次不是坏事，判断少
class Solution299 {
    public String getHint(String secret, String guess) {
        if (secret.length() == 0) return "0A0B";
        int[] count = new int[10];
        int cows = 0, bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) bulls++;
            else {
                if (count[s - '0'] < 0) cows++;
                if (count[g - '0'] > 0) cows++;
                count[s - '0']++;
                count[g - '0']--;
            }
        }
        return String.format("%dA%dB",bulls, cows);
    }

    public String getHint1(String secret, String guess) {
        if (secret == null || guess == null) {
            return "";
        }

        int bulls = 0;
        int cows = 0;

        char[] sc = secret.toCharArray();
        char[] gs = guess.toCharArray();

        int[] smap = new int[10];
        int[] tmap = new int[10];

        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == gs[i]) {
                bulls++;
            } else {
                smap[sc[i] - '0']++;
                tmap[gs[i] - '0']++;
            }


        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(smap[i], tmap[i]);
        }

        return bulls + "A" + cows + "B";

    }
}
