public class BST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int size(TreeNode root) {
        if(root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }
    public static int height(TreeNode root) {
        if(root == null) return -1;
        return height(root.left) + height(root.right) + 1;
    }
    public static int maximum(TreeNode root) {
        TreeNode curr = root;
        while(curr.right != null) curr = curr.right;
    }
    public static int minimum(TreeNode root) {
        TreeNode curr = root;
        while(curr.left != null) curr = curr.left;
    }
    public static boolean find(TreeNode root, int data) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val == data)    return true;
            else if(curr.val > data) curr = curr.left;
            else curr.right;
        }
        return false;
    }
    public static ArrayList<TreeNode> rootToNodePath(TreeNode root, int data) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        TreeNode curr = root;
        boolean flag = false;
        while(curr != null) {
            ans.add(curr);
            if(curr.val == data)  {
                flag = true;
                break;
            }
            else if(curr.val > data) curr = curr.left;
            else curr.right;
        }
        if(!flag) ans.clear();
        return ans;
    }
    
    // LC 235
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val > p.val && curr.val > q.val)
                curr = curr.left;
            else if(curr.val < p.val && curr.val < q.val)
                curr = curr.right;
            else
                return curr;
        }
        return null;
    }

    // BST Itr
    class BSTIterator {

        private ArrayDeque<TreeNode> st = new ArrayDeque<>(); // addFirst, removeFirst

        public BSTIterator(TreeNode root) {
            addAllLeft(root);
        }

        private void addAllLeft(TreeNode node) {
            while (node != null) {
                this.st.addFirst(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode rnode = this.st.removeFirst();
            addAllLeft(rnode.right);

            return rnode.val;
        }

        public boolean hasNext() {
            return this.st.size() != 0;
        }
    }

    
}