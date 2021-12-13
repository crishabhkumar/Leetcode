/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.

*/



//Solution
class Solution {
    public int maxPower(String s) {
		// Taking max & count as 1 since minimum length of substring can be 1
        int max = 1, count = 1;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)!=s.charAt(i+1)) {
				// If the subsequent characters are not equal, then compare the count with max & update if required
                max = Math.max(max, count);
				// Reset count as 1, to check on remaining string
                count = 1;
                continue;
            }
            else
                count ++;
        }     
		// Incase of "abcc", max = 1, but count = 2, so we will be returning the max of them
        return Math.max(max, count);
    }
}
