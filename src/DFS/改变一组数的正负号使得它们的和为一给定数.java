package DFS;

/**
 * Created by 周杰伦 on 2018/4/8.
 */
public class 改变一组数的正负号使得它们的和为一给定数 {
    static int count = 0;
    public static void main(String[] args) {
        int []a = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays(a,S));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        count = 0;
        dfs(0,nums,0,S);
        return count;
    }
    public static void dfs(int cur,int []nums, int sum, int S) {
        if (sum == S && cur == nums.length) {
            count += 1;
        }
        if (cur >= nums.length) return;
        dfs(cur + 1,nums,sum + nums[cur],S);
        dfs(cur + 1,nums,sum + nums[cur] * (-1),S);
        return;
    }
}
