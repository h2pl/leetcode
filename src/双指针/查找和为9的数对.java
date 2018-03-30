package 双指针;

/**
 * Created by 周杰伦 on 2018/3/29.
 */
public class 查找和为9的数对 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] numbers, int target) {
        int i = 0,j = numbers.length - 1;
        int []index = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i ++;
            }
            else if (numbers[i] + numbers[j] > target) {
                j --;
            }
            else {
                index[0] = i + 1;
                index[1] = j + 1;
                break;
            }
        }
        return index;
    }
}
