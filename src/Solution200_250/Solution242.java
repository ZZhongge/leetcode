package Solution200_250;

///char 的遍历速度远快于charat
class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++) store[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) store[t.charAt(i) - 'a']--;
        for (int tmp: store) if (tmp != 0) return false;
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        // Case 1
        /*
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
        */
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
