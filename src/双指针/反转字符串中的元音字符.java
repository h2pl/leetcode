package 双指针;

/**
 * Created by 周杰伦 on 2018/3/30.
 */
public class 反转字符串中的元音字符 {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
    public static String reverseVowels(String str) {
        int i = 0,j = str.length() - 1;
        char[] arr = str.toCharArray();
        while (i < j) {
            while (i < j && !vowels(arr[i])) {
                i ++;
            }
            while (i < j && !vowels(arr[j])) {
                j --;
            }
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i ++;
            j --;
        }
        return String.valueOf(arr);
    }
    public static boolean vowels(char c) {
        if (c == 'i' || c =='o' || c == 'a' || c =='e' || c == 'u')return true;
        else if (c == 'I' || c == 'O' || c == 'A' || c == 'E' || c == 'U') return  true;
        else return false;
    }
}
