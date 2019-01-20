package Solution250_300;

import java.util.HashMap;

//用set结合string[]本例中可以替代hashmap，这里的用处主要是储存已知键的值和去重（重复储存）
class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        String[] str_cluster = str.split(" ");
        if (pattern.length() != str_cluster.length) return false;
        HashMap<Character, String> map = new HashMap<>();

        for(int i = 0; i < str_cluster.length; i++) {
            char chr = pattern.charAt(i);
            if (!map.containsKey(chr)) {
                if (map.containsValue(str_cluster[i])) {
                    return false;
                }
                else {
                    map.put(chr, str_cluster[i]);
                }
            }
            else {
                 if (!map.get(pattern.charAt(i)).equals(str_cluster[i])) {
                     return false;
                 }
            }
        }
        return true;
    }
}
