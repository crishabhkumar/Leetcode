/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*/

//Solution:
class Solution {
    public int findKthLargest(int[] nums, int k) {
        BubbleSort(nums);
        return nums[nums.length - k];
    }
    public void BubbleSort(int[] arr){
        boolean swapped;
        //run the loop for n-1 times
        for (int i = 0; i < arr.length; i++) {
            //run internal loop
            //for less than n-i
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                //swap if condition satisfy
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            //if swapped did not work that means array is soted then just break it.
            if(swapped == false){
                break;
            }
        }
    }
}
