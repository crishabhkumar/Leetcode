/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i =0;i < nums.length;i++){
            int x = target - nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == x){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }
}



//another solution
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        int ans1 = 0,ans2 = 0,left = 0;
        int right = arr.length-1;
        int[] originalArr = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        while (left <= right){
            if(arr[left] + arr[right] < target){
                left++;
            }else if(arr[left] + arr[right] > target){
                right--;
            }else {
                ans1 = arr[left];
                ans2 = arr[right];
                break;
            }
        }
        
        
        for(int i = 0 ;i < arr.length;i++){
            if(ans1 == originalArr[i]){
                ans[0] = i;
                break;
            }
        }
        
        
        for(int i = arr.length-1 ;i >= 0;i--){
            if(ans2 == originalArr[i]){
                ans[1] = i;
                break;
            }
        }
        
        return ans;
    }
}
