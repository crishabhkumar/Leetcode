/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
*/

//Solution:
class Solution {
    public int[] findErrorNums(int[] arr) {
        int[] retArray = new int[2];
        cyclicSort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != i+1){
                retArray[0] = arr[i];
                retArray[1] = i+1;
            }
        }
        return retArray;
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
