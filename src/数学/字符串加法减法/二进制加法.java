package 数学.字符串加法减法;

import com.sun.org.apache.xerces.internal.impl.dv.xs.Base64BinaryDV;

/**
 * Created by 周杰伦 on 2018/4/12.
 */
public class 二进制加法 {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (carry == 1|| i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i --) == '1')carry ++;
            if (j >= 0 && b.charAt(j --) == '1')carry ++;
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
