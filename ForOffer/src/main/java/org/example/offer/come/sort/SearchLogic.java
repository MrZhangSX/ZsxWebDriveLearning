package org.example.offer.come.sort;

public class SearchLogic {
    //二分查找法，需要查找的数组有序，如果无序需要先排序
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2 + low;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
