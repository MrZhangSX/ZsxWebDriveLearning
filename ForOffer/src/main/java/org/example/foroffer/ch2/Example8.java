package org.example.foroffer.ch2;

//和大于或等于K的最短子数组
public class Example8 {
    public int mixLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int mixLength = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                mixLength = Math.min(mixLength, right - left + 1);
                sum -= nums[left++];
            }
            right ++;
        }
        return mixLength;
    }
}
