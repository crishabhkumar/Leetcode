/*
Given an array of digits which is sorted in non-decreasing order. You can write numbers using each digits[i] as many times as we want. For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.

Return the number of positive integers that can be generated that are less than or equal to a given integer n.

 

Example 1:

Input: digits = ["1","3","5","7"], n = 100
Output: 20
Explanation: 
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
Example 2:

Input: digits = ["1","4","9"], n = 1000000000
Output: 29523
Explanation: 
We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
In total, this is 29523 integers that can be written using the digits array.
Example 3:

Input: digits = ["7"], n = 8
Output: 1
 

Constraints:

1 <= digits.length <= 9
digits[i].length == 1
digits[i] is a digit from '1' to '9'.
All the values in digits are unique.
digits is sorted in non-decreasing order.
1 <= n <= 109
*/

//Solution
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String strNum=Integer.toString(n);  //Converted n to String for finding no. of digits in it.
        int nDigitCount=strNum.length();    
        
        int digitsLen=digits.length;    //length of digits array
        int res=0;  //result variable
        
        //loop for finding count of numbers having no. of digits 1 less than no. of digits in n 
        for(int i=1;i<nDigitCount;i++){   //here i means no. of digits considered for making number
            res+=(int)Math.pow(digitsLen,i);    //formula related to permutation & combination
        }
        
        boolean breakFlag=false;   
        
        //flag to check if got a number equal to that place number,so that we can further traverse by keeping earlier place fixed.
        boolean equalFlag=false;
        
        for(int i=0;i<nDigitCount;i++){ //i is pointer to digits in n.
            equalFlag=false;
            //we traverse from end,since array s sorted. So if we got less than current digit in n then all the combination below that position will be less than n
            for(int j=digitsLen-1;j>=0;j--){  //j is pointer to traverse in digits array
                if(Integer.parseInt(digits[j])<strNum.charAt(i)-'0'){   
                    //(j+1) for current position and remaining formula for remaining positions
                    res+=(j+1)*((int)Math.pow(digitsLen,nDigitCount-i-1));
                    break;
                }
                else if(Integer.parseInt(digits[j])==strNum.charAt(i)-'0') 
                    equalFlag=true;
                else if(j==0) //if we went until 0th digit then we haven't got a digit to satisfy our condition
                    breakFlag=true;
            }
            if(!equalFlag || breakFlag)
                break;
        }
        if(equalFlag)   //this is to add the exact number n. For eg. if n=55 and digits=["2","5"],above loop won't add to res for 55.
            res++;
        return res;
    }
}
