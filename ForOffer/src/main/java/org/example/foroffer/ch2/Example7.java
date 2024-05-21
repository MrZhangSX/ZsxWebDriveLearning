package org.example.foroffer.ch2;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//三数和为0
public class Example7 {
    public List<List<Integer>> threeSums(int[] nums) {
        List<List<Integer>> sums = new LinkedList<>();
        if (nums.length >= 3) {
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length -2) {
                sumstwo(nums, i, sums);
                int temp = nums[i];
                while (temp == nums[i] && i < nums.length) {
                    i ++;
                }
            }
        }
        return sums;
    }

    private void sumstwo(int[] nums, int i, List<List<Integer>> sums) {
        int j = i + 1;
        int k = nums.length -1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                sums.add(Arrays.asList(nums[i] , nums[j], nums[k]));
                int temp = nums[j];
                while (nums[j] == temp && j < k) {
                    j ++;
                }
            } else if(nums[i] + nums[j] + nums[k] < 0){
                j ++;
            }else {
                k --;
            }
        }
    }

}
