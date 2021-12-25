/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.

*/

//Solution:
class Solution {
    public int calculate(String s) {
         int n=0,sum=0;char prev='+';
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' '){ }
            
            else if(s.charAt(i)>47&&s.charAt(i)<58) {
                n=n*10+(s.charAt(i)-48);
              }
            
            else if(s.charAt(i)==42||s.charAt(i)==47) {
                int j=i+1,k=0;
                while(s.charAt(j)==' ') j++;
                while(j<s.length()&&(s.charAt(j)>47&&s.charAt(j)<58)){
                    k=k*10+s.charAt(j)-48;
                    j++;
                }
                if(s.charAt(i)==42) n=n*k;
                else n=n/k;
                i=j-1;
            }
            else {
                if(prev==43) sum+=n;
                else sum-=n;
                n=0;
                prev=s.charAt(i);
            }
        }
        
        if(prev==43) sum+=n;
        else sum-=n;
        
        return sum;
    }
}
