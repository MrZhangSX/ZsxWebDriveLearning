package org.example.offer.come.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SortLogic {
    //冒泡排序，每一次排序将最大值放在最后面，执行数组的长度次数
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //插入排序，插入到第一个比自己大的数字左边
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertValue = array[i];
            int index = i - 1;
            while (index >= 0 && insertValue < array[index]) {
                array[index + 1] = array[index];
                index --;
            }
            array[index + 1] = insertValue;
        }
    }

    //快速排序，找到基准值并且进行递归
    //1.从后向前比较，用基准值和最后一个值进行比较，如果找到比基准值小的则交换位置
    //2.从前向后比较，用基准值和第一个值进行比较，如果有值比基准值大则交换
    //3.重复直到前后指针位置相等
    //4.前后两个部分进行递归
    public static void quickSort(int[] array, int start, int end) {
        int low = start;
        int high = end;
        int key = array[start];
        while (end > start) {
            while  (array[high] >= key && end > start) {
                end--;
            }
            if (array[end] <= key) {
                int temp = array[end];
                array[end] = array[start];
                array[start] = temp;
            }
            while (end > low && array[low] <= key) {
                low ++;
            }
            if (array[low] >= key) {
                int temp = array[low];
                array[low] = array[end];
                array[end] = temp;
            }
        }
        if (low > start) quickSort(array, start, low -1);
        if (end > high) quickSort(array, high + 1, end);
    }

    //希尔排序，用间隔划分，进行插入排序，然后减小间隔，直到间隔为1
    public void shellSort(int[] arr) {
        int dk = arr.length / 3 +1;
        while (dk != 1) {
            shellInsertSort(arr, dk);
            dk = dk/3 + 1;
        }
        if (dk == 1) shellInsertSort(arr, dk);
    }

    private void shellInsertSort(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int index = arr[i];
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && arr[j] > index; j = j-dk) {
                    arr[j+dk] = arr[j];
                }
                arr[j+dk] = index;
            }
        }
    }

    //归并排序先将原始数组分为多个子序列，然后对每个子序列进行排序，最后将排好序的子数组合并起来
    public void mergeSort(int[] data) {

    }

    public void splitSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int center = left + right / 2;
        splitSort(data, left, center);
        splitSort(data, center + 1, right);
        merge(data, left, center, right);
    }

    public void merge(int[] data, int left, int center, int right) {
        int[] tempArr = new int[data.length];
        int mid = center + 1;
        int tmplLeft = left;
        int value = left;
        //先把左右两边其中一个从最小开始取，直到其中一个取完
        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                tempArr[tmplLeft++] = data[left++];
            } else {
                tempArr[tmplLeft++] = data[mid++];
            }
        }
        //没读完的依次放进临时数组
        while (left <= center) {
            tempArr[tmplLeft++] = data[left++];
        }

        while (mid <= right) {
            tempArr[tmplLeft++] = data[mid++];
        }
        //数组读取临时数组的值
        while (value <= right) {
            data[value++] = tempArr[value++];
        }
    }


    //桶排序，先找出数组中最大最小的值，根据最大最小指定于桶。将数组分到有限数量的桶中，对每个桶进行排序（使用其他排序算法或者递归使用桶排序）,最后进行合并
    public void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        int bucketNum = max - min / nums.length + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketNum);

        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length ;
            buckets.get(1).add(nums[i]);
        }
        int index = 0;
        for (int b = 0; b < bucketNum; b++) {
            Collections.sort(buckets.get(b));
            for (int i = 0; i < buckets.get(b).size(); i++) {
                nums[index++] = buckets.get(b).get(i);
            }
        }
    }

    //基数排序，对每一位进行排序，然后进行合并
    public void radixSort(int[] array, int maxDigit) {
        double max = Math.pow(10, maxDigit + 1);
        int n = 1;
        int k = 0;
        int length = array.length;
        int[][] bucket = new int[10][length];
        int[] order = new int[length];
        while (n < max) {
            for (int i : array) {
                int dig = i / n % 10;
                bucket[dig][order[dig]] = i;
                order[dig] ++;
            }

            for (int i = 0; i < array.length; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                    order[i] = 0;
                }
            }
            k = 0;
            n = n * 10;
        }
    }

}
