package 数据结构.位运算;

/**
 * Created by 周杰伦 on 2018/4/27.
 */
public class 字符串数组最大乘积 {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] val = new int[n];
        //用一个二进制数来存储一个数所包含的字母种类。
        //32位可以容纳26个字母，用数组保存n个二进制数，两两相与，如果结果为0
        //说明这两个数没有重复的字母，可以返回。
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                val[i] |= 1 << (c - 'a');
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((val[i] & val[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
}
