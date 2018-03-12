/**
 * Created by 周杰伦 on 2018/3/10.650. 2 Keys Keyboard
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

 Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 Paste: You can paste the characters which are copied last time.
 Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

 Example 1:
 Input: 3
 Output: 3
 Explanation:
 Intitally, we have one character 'A'.
 In step 1, we use Copy All operation.
 In step 2, we use Paste operation to get 'AA'.
 In step 3, we use Paste operation to get 'AAA'.
 Note:
 The n will be in the range [1, 1000].
 */
public class KeysKeyboard {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        else if(n % 2 == 0) {
            return minSteps(n/2) + 2;
        }
        else if( !isPrime(n)) {
            return n;
        }
        else {
            double tmp = Math.sqrt(n);
            int min = 1000;
            for(int i= 2;i <=tmp; i++) {
                if (n % i == 0) {
                    if(minSteps(n/i) + i < min ) {
                        min = minSteps(n/i) + i;
                    }
                }
            }
            return min;
        }
    }

    boolean isPrime( int num )
    {
        double tmp = Math.sqrt(num);
        for(int i= 2;i <=tmp; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false ;
    }

    public static void main(String[] args) {

    }
}
