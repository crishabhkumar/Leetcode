/*
Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"
 

Constraints:

-107 <= num <= 107
*/


//Solution:
class Solution {
    public String convertToBase7(int n) {
        if(n == 0) return "0";
        StringBuilder ans = new StringBuilder();
        int x = n;
        n = Math.abs(n);
        while(n != 0){
            ans.append(n % 7);
            n = n / 7;
        }
        if(x < 0){
            ans.append("-");
        }
        return ans.reverse().toString();
    }
}
