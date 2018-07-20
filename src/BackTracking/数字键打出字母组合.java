package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/1.
 */
public class    数字键打出字母组合 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals(""))return new ArrayList<>();
        List<String> list = new ArrayList<>();
        combineStr("",0,digits,list);
        return list;
    }
    public void combineStr(String prefix, int offset, String digits, List<String>ret) {
        if (offset == digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(offset) - '0'];
        char[] arr = letters.toCharArray();
        for (char c : arr) {
            combineStr(prefix + c,offset + 1,digits, ret);
        }
    }
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

}
