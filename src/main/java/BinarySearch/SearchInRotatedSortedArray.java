package BinarySearch;

/** https://leetcode-cn.com/problems/search-in-rotated-sorted-array/ */
public class SearchInRotatedSortedArray {

  public static void main(String[] args) {
    new SearchInRotatedSortedArray().search(new int[] {5, 1, 3}, 3);
  }

  public int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >> 1);
      if (nums[mid] == target) {
        return mid;
      }
      if (nums[lo] < nums[mid]) {
        if (target >= nums[lo] && target < nums[mid]) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }

      if (nums[mid] < nums[hi]) {
        if (target > nums[mid] && target <= nums[hi]) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
    }
    return -1;
  }
}
