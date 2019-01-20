public class Trie {
    /** Initialize your data structure here. */
    private TrieNode Root;

    public Trie() {
        Root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = Root;
        for(int i = 0; i < word.length(); i++) {
            char NodeValue = word.charAt(i);
            if (!cur.containsKey(NodeValue)) {
                cur.put(NodeValue, new TrieNode());
            }
            cur = cur.get(NodeValue);
        }
        cur.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = Root;
        for(int i = 0; i < word.length(); i++) {
            char NodeValue = word.charAt(i);
            if (!cur.containsKey(NodeValue)) {
                return false;
            }
            cur = cur.get(NodeValue);
        }
        return cur.getEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = Root;
        for(int i = 0; i < prefix.length(); i++) {
            char NodeValue = prefix.charAt(i);
            if (!cur.containsKey(NodeValue)) {
                return false;
            }
            cur = cur.get(NodeValue);
        }
        return true;
    }
}

class TrieNode {
    private final int R = 26;

    //代表26后继节点，如果有node表示还有后继，为null表示该节点在这条线上为end
    private TrieNode[] successor;
    private boolean isEnd;

    public TrieNode() {
        successor = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return successor[ch-'a'] != null;
    }

    public TrieNode get(char ch) {
        return successor[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        successor[ch -'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }
}

class EasyTrie {
    //这题可以用hash表存长度-字符串列表的映射，之后遍历字符串列表
    class TrieNode {
        public TrieNode[] successor;
        public boolean isEnd;
        public TrieNode() {
            isEnd = false;
            successor = new TrieNode[26];
        }
    }

    TrieNode Root;
    public EasyTrie() {
        Root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void addWord(String word) {
        TrieNode cur = Root;
        for(int i = 0; i < word.length(); i++) {
            char NodeValue = word.charAt(i);
            if (cur.successor[NodeValue-'a'] == null) {
                cur.successor[NodeValue-'a'] = new TrieNode();
            }
            cur = cur.successor[NodeValue-'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        boolean[] result = new boolean[1];
        searchHelper(Root, word, result);
        return result[0];

    }

    public void searchHelper(TrieNode root, String word, boolean[] result) {
        if (root == null) return;

        TrieNode pointer = root;
        for(int i = 0; i < word.length(); i++) {
            char NodeValue = word.charAt(i);
            if (NodeValue == '.') {
                for (TrieNode node : pointer.successor) {
                    searchHelper(node, word.substring(i + 1), result);
                }
            } else {
                if (pointer.successor[NodeValue - 'a'] == null) {
                    result[0] = result[0] || false;
                    return;
                }
                pointer = pointer.successor[NodeValue - 'a'];
            }
        }
        result[0] = result[0] || pointer.isEnd;
        return;
    }

    public boolean search1(String word) {
        return searchByRange(word,0,Root);
    }
    private boolean searchByRange(String word, int startIndex,TrieNode node){
        if(startIndex == word.length())
            return node.isEnd;
        char c = word.charAt(startIndex);
        if(word.charAt(startIndex)!='.' && node.successor[c-'a']==null){
            return false;
        }else if(word.charAt(startIndex)!='.' && node.successor[c-'a']!=null){
            return searchByRange(word, startIndex+1, node.successor[c-'a']);
        }else{
            for(TrieNode n: node.successor){
                if(n != null && searchByRange(word, startIndex+1,n))
                    return true;
            }
        }
        return false;
    }
}