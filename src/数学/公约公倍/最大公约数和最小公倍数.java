package 数学.公约公倍;

/**
 * Created by 周杰伦 on 2018/4/11.
 * 最大公约数

 int gcd(int a, int b) {
 return b == 0 ? a : gcd(b, a% b);
 }
 最小公倍数为两数的乘积除以最大公约数。

 int lcm(int a, int b){
 return a * b / gcd(a, b);
 }
 对于最大公约数问题，因为需要计算 a % b ，而这个操作是比较耗时的，可以使用 编程之美：2.7 的方法，利用减法和移位操作来替换它。

 对于 a 和 b 的最大公约数 f(a, b)，有：

 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
 如果 a 和 b 均为奇数，f(a, b) = f(a, a-b);
 乘 2 和除 2 都可以转换为移位操作。
 */
public class 最大公约数和最小公倍数 {

}
