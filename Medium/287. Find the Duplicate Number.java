/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
*/

//Solution:

class Solution {
    public int findDuplicate(int[] arr) {
        cyclicSort(arr);
        int ele = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                ele = arr[i];
            }
        }
        return ele;
    }
    
    public void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            //arr[arr[i] - 1] = arr[correct index]
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
