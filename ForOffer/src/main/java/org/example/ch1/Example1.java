package org.example.ch1;

//整数相除
public class Example1 {
    public int divide(int divided, int divisor){
        if ((divided == 0x80000000) && (divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int judge = 2;
        if (divided > 0) {
            judge --;
            divided = -divided;
        }
        if (divisor > 0) {
            judge --;
            divisor = -divisor;
        }

        int result = divideResult(divided, divisor);
        return judge == 1 ? -result:result;

    }

    private int divideResult (int divided, int divisor) {
        int result = 0;
        while (divided <= divisor) {
            int newDivisor = divisor;
            int count = 1;
            while (divided <= newDivisor + newDivisor) {
                newDivisor += newDivisor;
                count += count;
            }
            result += count;
            divided -= newDivisor;
        }
        return result;
    }
}
