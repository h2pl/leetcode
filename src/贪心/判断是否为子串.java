package 贪心;

/**
 * Created by 周杰伦 on 2018/3/17.
 */
public class 判断是否为子串 {
    public boolean isSubsequence(String s, String t) {
        if(s.equals(""))return true;
        char []ss = s.toCharArray();
        char []tt = t.toCharArray();
        boolean flag = false;
        for(int i=0,j=0;i<ss.length && j<tt.length;){
            if(ss[i]==tt[j]) {
                if(i == ss.length-1){
                    flag = true;
                    return flag;
                }
                i++;
                j++;

            }
            else j++;

        }
        return flag;
    }
}
