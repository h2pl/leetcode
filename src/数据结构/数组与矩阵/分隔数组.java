package 数据结构.数组与矩阵;

/**
 * Created by 周杰伦 on 2018/4/18.
 */
public class 分隔数组 {
    // 先拆分成若干个数组，每个数组排序
    // 如果结果拼起来与原数组的排序相同，则符合。找出可以分隔的最大份数。

    //倒序的放在一起，顺序的拆开，遇到逆序不加，遇到顺序加加。
    //注意遇到顺序时，需要与之前的最大值比较。比如18234这种情况，实际上只能分为2个部分。
    public static void main(String[] args) {
        int []a = {2,0,1};
        int []b = {4,3,2,1,0};
        int []c = {1,0,2,3,4};
        int []d = {1,2,0,3};
        System.out.println(maxChunksToSorted(a));
        System.out.println(maxChunksToSorted(b));
        System.out.println(maxChunksToSorted(c));
        System.out.println(maxChunksToSorted(d));
    }
    // 不会，待解
    public static int maxChunksToSorted(int[] arr) {
        if (arr == null) return 0;
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) ret++;
        }
        return ret;
    }
//    public static int maxChunksToSorted(int[] arr) {
//        int cnt = 1;
//        int max = arr[0];
//        for (int i = 1;i < arr.length;i ++) {
//            if (arr[i] > arr[i - 1] && arr[i] > max ) {
//                cnt ++;
//            }
//            max = Math.max(max, arr[i]);
//        }
//        return cnt;
//    }
}
