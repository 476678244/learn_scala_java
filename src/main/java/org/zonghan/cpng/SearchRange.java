package org.zonghan.cpng;

import java.util.Arrays;

public class SearchRange {

    /*
     * 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * Example:
     *   nums: [5, 7, 7, 8, 8, 10]
     *   target: 8
     *   answer: [3,4]
     * 如果数组中不存在目标值 target，返回 [-1, -1]
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     * */
    public static void main(String[] args) {
        SearchRange obj = new SearchRange();

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)
                // 3,4
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8)
                // 3,5
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{1}, 1)
                // 0,0
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{}, 8)
                // -1,-1
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{2, 2}, 2)
                // 0,1
        )));

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        return new int[]{findLower(nums, target), findUpper(nums, target)};
    }

    public int findUpper(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else
                r = mid - 1;
        }
        if (nums[r] == target)
            return r;
        return -1;
    }

    public int findLower(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else
                l = mid + 1;
        }
        if (nums[l] == target)
            return l;
        return -1;
    }

}
