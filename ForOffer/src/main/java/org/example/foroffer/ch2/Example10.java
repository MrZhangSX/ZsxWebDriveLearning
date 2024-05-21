package org.example.foroffer.ch2;


import java.util.HashMap;
import java.util.Map;

//和为K的子数组
//数组并不全为正整数 所以不能用双向指针去判断
public class Example10 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sunMap = new HashMap<>();
        sunMap.put(0 ,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sunMap.getOrDefault(sum - k, 0);
            sunMap.put(sum, sunMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
