/*
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

 

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
 

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100

*/

//solution:
class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length]; 
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }
        BubbleSort(heights);
        return check(heights,expected);
    }
    
    public int check(int[] heights,int[] expected){
        int count = 0;
        for(int i = 0;i < heights.length;i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
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
        // return arr;
    }
}
