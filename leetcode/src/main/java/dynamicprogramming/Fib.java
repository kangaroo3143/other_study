package dynamicprogramming;

/**
 * @author liubo
 * @ClassName Fib
 * @Description
 * 面试题10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/5/15
 * @since JDK 1.8
 */
public class Fib {

    static volatile int[] count;
    public static int fib(int n){
        if(n<=1){
            return n;
        }
        if(count[n]==0){
            count[n]= fib(n-1)+ fib(n-2);
        }
        return count[n];
    }

    public static void main(String[] args) {
        count=new int[8];
        System.out.println(fib(2));
    }

}
