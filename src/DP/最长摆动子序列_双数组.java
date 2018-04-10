package DP;

/**
 * Created by 周杰伦 on 2018/4/4.
 */
public class 最长摆动子序列_双数组 {
    public static void main(String[] args) {
        int []a = {1,7,4,9,2,5};
        int []b = {1,17,5,10,13,15,10,5,16,8};
        int []c = {1,2,3,4,5,6,7,8,9};
        int []d = {0,0,0,0,1,0};
        System.out.println(wiggleMaxLength(a));
        System.out.println(wiggleMaxLength(b));
        System.out.println(wiggleMaxLength(c));
        System.out.println(wiggleMaxLength(d));

    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)return 0;
        int []up = new int[nums.length];
        int []down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1;i < nums.length;i ++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            }else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            }else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
