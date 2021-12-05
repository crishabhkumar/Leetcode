/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

Example 1:


Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:


Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 104
*/

//Solution:
class Solution{
    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }
    public int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int ans = 0;
        if (root.left != null) {
            ans += rob(root.left.left, map) + rob(root.left.right, map);
        }
        if (root.right != null) {
            ans += rob(root.right.left, map) + rob(root.right.right, map);
        }
        ans = Math.max(ans + root.val, rob(root.left, map) + rob(root.right, map));
        map.put(root, ans);
        return ans;
    }
}
