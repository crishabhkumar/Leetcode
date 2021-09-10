/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

//Solution:
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        
        char[] str = s.toLowerCase().toCharArray();
        char[] tr = t.toLowerCase().toCharArray();
        return checkanagram(str,tr);
    }
    
    boolean checkanagram(char[] str,char[] tr){
        Arrays.sort(str);
        Arrays.sort(tr);

        for (int i = 0; i < str.length; i++) {
            if(str[i] != tr[i]){
                return false;
            }
        }
        
        return true;
    }
}
