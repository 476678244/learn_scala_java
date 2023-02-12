package org.zonghan.cpng;

import java.util.Arrays;

public class SearchRangeInSecond {

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
        SearchRangeInSecond obj = new SearchRangeInSecond();

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)
                // 4,3
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8)
                // 4,4
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{1}, 1) //[-1,-1]
                // -1,-1
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{}, 8)
                // -1,-1
        )));

        System.out.println(String.join(",", Arrays.toString(
                obj.searchRange(new int[]{2, 2}, 2)
                // 1,0
        )));

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }

        int left = bSearchLeft(nums, target);
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }

        int right = bSearchRight(nums, target);

        if (left == nums.length - 1 || nums[left + 1] != target) {
            left = -1;
        } else {
            left = left + 1;
        }

        if (right == 0 || nums[right - 1] != target) {
            right = -1;
        } else {
            right = right - 1;
        }

        return new int[]{left, right};

    }

    private int bSearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int bSearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }


}