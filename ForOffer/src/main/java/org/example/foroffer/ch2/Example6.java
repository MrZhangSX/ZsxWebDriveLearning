package org.example.foroffer.ch2;

//双指针
//数组数字之和
public class Example6 {
    public static int[] twosum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i ++;
            }else {
                j --;
            }
        }
        return new int[] {i , j};
    }

    public static void main(String[] args) {
        int[] ints = twosum(new int[]{1, 2, 4, 6, 10}, 8);
        System.out.println(ints[0] + " " + ints[1]);
    }
}
