/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 */

//Solution
//Using Cyclic Sort:
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> num = new ArrayList<>();
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                num.add(i+1);
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
