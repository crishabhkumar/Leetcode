/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

//Solution
class Solution {
    public boolean containsDuplicate(int[] nums) {
        insertionSort(nums);
        boolean checker = false;
        for(int i = 0;i < nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                checker = true;
                break;
            }
        }
        return checker;
    }
    
    public void insertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    swapArray(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }
    public void swapArray(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
}

//Another Solution
