public class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // TC : O(word.length)
    // SC : O(26 * word.length) = O(word.length)
    public void insert(String word) {
        TrieNode curr = root;

        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    // TC : O(word.length)
    // SC : O(1)
    public boolean search(String word) {
        TrieNode curr = root;

        for (int i=0; i < word.length(); i++){
            char c = word.charAt(i);

            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }

    // TC : O(word.length)
    // SC : O(1)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (int i=0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}