package org.example.foroffer.ch2;


//左右两边子数组的和相等
public class Example12 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total - nums[i] == sum - total) {
                return i;
            }
        }
        return -1;
    }
}
