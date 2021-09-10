/*
Write a function that reverses a string. The input string is given as an array of characters s.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
*/

//solution 1:
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(s));
    }
}


//Solution2:
class Solution {
    public void reverseString(char[] s) {
        int end = s.length - 1;
        int start = 0;
        printstr(s,start,end);
        System.out.println(Arrays.toString(s));
    }
    void printstr(char[] s,int start,int end) {
        if(start >= s.length/2){
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        printstr(s,start+1,end-1);
    }
}
