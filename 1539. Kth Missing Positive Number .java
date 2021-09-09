/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
*/

//Solution:
class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> nums = new ArrayList<>();        //missing  numbers arraylist
        
        for(int i = 1;i < arr[arr.length-1];i++){
            if(!binarySearch(arr,i))
                nums.add(i);
            if(nums.size()==k)
                return nums.get(k-1);
        }
        //if k > last element
        return (arr[arr.length-1] + k - nums.size());
    }
    
     boolean binarySearch(int arr[], int x){
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end -start)/2;
            if(arr[mid] > x){
                end = mid -1;
            }else if(arr[mid] < x){
                start = mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}
