package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周杰伦 on 2018/4/1.
 * 1 file committed: 回溯法
 * 5大题型
 * 1排列 全排列 有重复数字的排列
 * 2组合 重复元素组合
 * 3求和 重复元素求和
 * 4子集 重复元素子集
 * 5扩展题型 如ip划分 回文数划分 数字打出字母等。
 * 重点在于：递归前标记元素，每次完整递归结束需要清除标记元素。
 * 判断递归结束条件。
 * 细节问题如list的添加，contains使用等
 */
//1111
//222 222 222 222
// 55 55 55 55
public class IP地址划分 {
    public static void main(String[] args) {

    }
    public List<String> restoreIpAddresses(String s) {
        int i,j,k,m;
        ArrayList <String> list = new ArrayList<>();
        int len = s.length();
        for (i = 1;i< 4 && i < len - 2;i ++) {
            for (j = i + 1;j < i + 4 && j < len - 1;j ++) {
                for (m = j + 1;m < j + 4 && m < len;m ++) {
                    //substring后面的下标是不算在内的。
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,m);
                    String s4 = s.substring(m,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                    {
                        list.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                    }
                }
            }
        }
        return list;
    }

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3 || s.charAt(0) == '0' && s.length() > 1
                || Integer.parseInt(s) > 255) {
            return false;
        }else return true;
    }

//    public List<String> restoreIpAddresses(String s) {
//        List<String> result = new ArrayList<>();
//        doRestore(result, "", s, 0);
//        return result;
//    }

//    private void doRestore(List<String> result, String path, String s, int k) {
//        if (s.isEmpty() || k == 4) {
//            if (s.isEmpty() && k == 4)
//                result.add(path.substring(1));
//            return;
//        }
//        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) { // Avoid leading 0
//            String part = s.substring(0, i);
//            if (Integer.valueOf(part) <= 255)
//                doRestore(result, path + "." + part, s.substring(i), k + 1);
//        }
//    }

}
