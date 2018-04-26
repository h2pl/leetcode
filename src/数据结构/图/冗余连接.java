package 数据结构.图;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        UnionFind uf = new UnionFind(N);
        for (int[] i : edges) {
            int u = i[0];
            int v = i[1];
            if (uf.find(u) == uf.find(v)) {
                return i;
            }
            uf.join(u, v);
        }
        return new int[]{-1,-1};
    }
    class UnionFind {

        UnionFind (int N) {
            //一条边就有两个点，所以节点数是边数加一
            pre = new int[N + 1];
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
            //把所有父节点为U的节点指向V节点。因为题目要求把一个图变为一个树
            //所以只能有一个根节点，必须把所有二级节点都指向唯一一个节点。
            for (int i = 0; i < pre.length; i++) {
                if (pre[i] == preU) {
                    pre[i] = preV;
                }
            }
        }
    }
}
