package 数据结构.栈和队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by 周杰伦 on 2018/4/13.
 */
public class 数组中元素与下一个比它大的元素之间的距离 {
    public static void main(String[] args) {
        int []a = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(a)));
    }
    // 不想用栈
    public static int[] dailyTemperatures(int[] temperatures) {
        int[]big = new int[temperatures.length];
        Arrays.fill(big, 0);
        for (int i = 0;i < temperatures.length - 1;i ++) {
            for (int j = i + 1;j < temperatures.length;j ++) {
                if (temperatures[j] > temperatures[i]) {
                    big[i] = j - i;
                    break;
                }
            }
        }
        return big;
    }
    //用栈的解法，没看懂
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack<>();

        //每次压入一个元素，如果后面的元素大于栈顶元素，则找到。出栈。
        //如果不满足，则把当前元素也压栈。重复多次后可能有多个元素在栈内。
        //当找到一个满足的元素时，继续判断之前栈中的元素是否小于它。
        //若满足则一次可以标记多个元素的距离值。这样的话时间复杂度要低很多。
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.add(i);
        }
        return ret;
    }
}
