package 数据结构.树.Trie;

/**
 * Created by 周杰伦 on 2018/4/26.
 */
public class 实现一个Trie树 {
    class Trie {
        Node root = new Node();
        class Node {
            Node[] childs = new Node[26];
            boolean isLeaf;
        }
        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(word, root);
        }
        public void insert(String word, Node node) {
            if (word.length() == 0 ) {
                node.isLeaf = true;
                return;
            }
            int index = indexForChar(word.charAt(0));
            if (node.childs[index] == null) {
                node.childs[index] = new Node();
            }
            insert(word.substring(1), node.childs[index]);
        }
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return search(word, root);
        }
        public boolean search(String word,Node node) {
            if (node == null) return false;
            if (word.length() == 0 ) return node.isLeaf;
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1), node.childs[index]);
        }
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWith(prefix, root);
        }
        public boolean startsWith(String prefix, Node node) {
            if (node == null) return false;
            if (prefix.length() == 0 ) return true;
            int index = indexForChar(prefix.charAt(0));
            return startsWith(prefix.substring(1), node.childs[index]);
        }

        public int indexForChar(char c) {
            return c - 'a';
        }
    }

}
