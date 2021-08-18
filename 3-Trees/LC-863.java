// METHOD - 1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean nodeToRootPath (TreeNode root, int target, ArrayList<TreeNode> ans) {
        if(root == null) return false;
        boolean res = (root.val == target) || nodeToRootPath(root.left, target, ans) ||
                    nodeToRootPath(root.right, target, ans);
        if(res)
            ans.add(root);
        return res;
    } 
    public void printAtDepthK(TreeNode root, TreeNode block, int k, ArrayList<Integer> ans) {
        if (root == null || root == block || k < 0)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        printAtDepthK(root.left, block, k - 1, ans);
        printAtDepthK(root.right, block, k - 1, ans);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath(root, target.val, path);
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        TreeNode blockNode = null;
        for(int i = 0; i < path.size(); i++) {
            if(k - i < 0)
                break;
            printAtDepthK(path.get(i), blockNode, k - i, ans);
            blockNode = path.get(i);
        }
        return ans;
    }
}


// Method -2 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void printAtDepthK(TreeNode root, TreeNode block, int k, List<Integer> ans) {
        if (root == null || root == block || k < 0)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        printAtDepthK(root.left, block, k - 1, ans);
        printAtDepthK(root.right, block, k - 1, ans);
    }
    public int distanceK_(TreeNode root, TreeNode target, int k, List<Integer> ans) {
        if(root == null)
            return -1;
        
        if(root == target) {
            printAtDepthK(root,null, k, ans);
            return 1;
        }
        
        int  ld = distanceK_(root.left, target, k, ans); 
        if(ld != -1) {
            printAtDepthK(root,root.left, k-ld, ans);
            return ld + 1;
        }
        
        int  rd = distanceK_(root.right, target, k, ans); 
        if(rd != -1) {
            printAtDepthK(root,root.right, k-rd, ans);
            return rd + 1;
        }
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {      
        List<Integer> ans = new ArrayList<Integer>();
        int rv = distanceK_(root, target, k, ans);
        return ans;
    }
}