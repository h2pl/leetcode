package 数据结构.树.Trie;

/**
 * Created by 周杰伦 on 2018/4/26.
 */
public class Trie求前缀和 {
    class MapSum {

        private class Node {
            Node[] child = new Node[26];
            int value;
        }

        private Node root = new Node();

        public MapSum() {

        }
        //插入到最后设置节点值
        public void insert(String key, int val) {
            insert(key, root, val);
        }

        private void insert(String key, Node node, int val) {
            if (node == null) return;
            if (key.length() == 0) {
                node.value = val;
                return;
            }
            int index = indexForChar(key.charAt(0));
            if (node.child[index] == null) {
                node.child[index] = new Node();
            }
            insert(key.substring(1), node.child[index], val);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        private int sum(String prefix, Node node) {
            if (node == null) return 0;
            if (prefix.length() != 0) {
                //先进行前缀匹配，匹配到最后一个节点。
                int index = indexForChar(prefix.charAt(0));
                return sum(prefix.substring(1), node.child[index]);
            }
            //从匹配到的最后一个节点开始，查找所有子节点，加上这些子节点的和。
            //并且递归地加上这些子节点往下的节点值。
            int sum = node.value;
            for (Node child : node.child) {
                sum += sum(prefix, child);
            }
            return sum;
        }

        private int indexForChar(char c) {
            return c - 'a';
        }
    }
}
