/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/


//Solution
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>(intervals.length);  
        for (int i = 0; i < intervals.length; i ++) {
            int x = intervals[i][0], y = intervals[i][1];
            if (ans.isEmpty() || x > ans.get(ans.size() - 1)[1])
                ans.add(intervals[i]);
            else if (ans.get(ans.size() - 1)[1] < y)
                ans.get(ans.size() - 1)[1] = y;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
