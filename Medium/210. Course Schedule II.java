/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
*/

//Solution:
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for ( int t[]: prerequisites ) {
            ArrayList<Integer> list = adj.getOrDefault(t[1], new ArrayList<Integer>());
            list.add(t[0]);
            adj.put(t[1], list);
            inDegree[t[0]]++;
        }
		// Adding courses that don't have any prerequisite to the queue.
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<numCourses; i++ ) {
            if ( inDegree[i]==0 ) {
                queue.offer(i);
            }
        }
		// If there are no such courses there is no way we would be able to do any course. (Forming a cycle)
        if ( queue.isEmpty() ) {
            return new int[] {};
        }
        int[] res = new int[numCourses];
        int k = 0;
        while ( !queue.isEmpty() ) {
            int curr = queue.poll();
            res[k++] = curr;
            if ( adj.containsKey(curr) ) {
                for ( int j: adj.get(curr) ) {
                    inDegree[j]--;
                    if ( inDegree[j]==0 ) {
                        queue.offer(j);
                    }
                }
            }
        }
		// Here we check if k==numCourses or not because if its not then we weren't able to traverse the whole graph which means we weren't able to complete all the courses
        return k==numCourses ? res : new int[] {};
    }
}
