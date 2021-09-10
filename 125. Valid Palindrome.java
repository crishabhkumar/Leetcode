/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.*/

//Solution
class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')){
                x.append(ch);
            }
        }
        return palin(x);
    }
    boolean palin(StringBuilder str){
        if(str.length() == 1){
            return true;
        } 

        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if(start != end){
                return false;
            }
        }
        return true;
    
    }
}
