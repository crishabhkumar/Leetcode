/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
*/



//Solution:
class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder(s);
        while(ans.indexOf("[") != -1){
            int first = ans.indexOf("]"),open = ans.lastIndexOf("[",first);
            
            StringBuilder temp = new StringBuilder();
            String span = ans.substring(open+1,first);
            
            int left = open-1;
            while(left >= 0 && Character.isDigit(ans.charAt(left))) left--;
            int num = Integer.parseInt(ans.substring(left + 1,open));
            
            for(int i = 0; i< num ;i++) temp.append(span);
            ans.replace(1+left,first +1 ,temp.toString());
        }
        
        return ans.toString();
    }
}
