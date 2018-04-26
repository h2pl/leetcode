package 数据结构.图;

/**
 * Created by 周杰伦 on 2018/4/26.
 */
public class 并查集 {
    //并查集用来查找一个节点的父节点是谁。
    //如果两个节点的父节点不同并且互相不为父节点，那么他们是不连通的两个点。
    //如果两个连通图要合并，只要让一个图的最高级节点指向另一个图的最高级节点
    //通过这个方法可以判断使图中节点连捅需要多少的边。
    class UnionFind {

        UnionFind (int []edges) {
            pre = new int[edges.length];
            for (int i = 0;i < pre.length;i ++) {
                pre[i] = i;
            }
        }
        int []pre;
        int find(int u) {
            return pre[u];
        }

        void join (int u,int v) {
            int preU = find(u);
            int preV = find(v);
            if (preU == preV)return;
            pre[preU] = preV;
            return;
        }
    }
}
