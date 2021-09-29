/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.


*/


//Solution
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> num = new ArrayList<>();
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                num.add(nums[i]);
            }
        }
        return num;
    }
    
    public void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] != arr[arr[i] - 1] && arr[i] <= arr.length){
                swapArray(arr,i,arr[i] - 1);
            }else {
                i++;
            }
        }
    }
    public void swapArray(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
