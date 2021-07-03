public class l001 {
    public static class TreeNode {
        int data = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int maximum(TreeNode root) {
        return root == null ? -(int)1e9 : Math.max(Math.max(maximum(root.left), maximum(root.right)), root.data);
    }

    public static boolean find(TreeNode root, int data) {
        if(root == null)
            return false;
        return root.data == data || find(root.left, data) || find(root.right, data);
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
      if(node == null)
        return new ArrayList<>();
      if(node.val == data) {
          ArrayList<TreeNode> base = new ArrayList<>();
          base.add(node);
          return base;
      }
      ArrayList<TreeNode> left = nodeToRootPath(node.left, data);
      if(left.size() != 0) {
          left.add(node);
          return left;
      }
      ArrayList<TreeNode> right = nodeToRootPath(node.right, data);;
      if(right.size() != 0) {
          right.add(node);
          return right;
      }
      return left;
    }

    public static boolean nodeToRootPath(TreeNode root, int data, ArrayList<TreeNode> ans)  {
            if(root == null) return false;
            if(root.val == data) {
                ans.add(root);
                return true;
            }
            boolean res = nodeToRootPath(root.left, data, ans) || nodeToRootPath(root.right, data, ans);
            if(res)
                ans.add(root);
            return res;
    }

    public static void rootToAllLeafPath(TreeNode root, ArrayList<Integer> smallAns, ArrayList<ArrayList<Integer>> ans) {
      if(root == null)  return;
      if(root.left == null && root.right == null){
         ArrayList<Integer> base = new ArrayList<>(smallAns);
         base.add(root.val);
         ans.add(base);
         return;
      }
      smallAns.add(root.val);
      rootToAllLeafPath(root.left, smallAns, ans);
      rootToAllLeafPath(root.right, smallAns, ans);
      smallAns.remove(smallAns.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
        // write your code.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();
        rootToAllLeafPath(root, smallAns, ans);
        return ans;
    }

      public static void exactlyOneChild(TreeNode root, ArrayList<Integer> ans) {
      if(root == null ||(root.left == null && root.right == null))
        return;
      if(root.left == null || root.right == null)
        ans.add(root.val);
      exactlyOneChild(root.left, ans);
      exactlyOneChild(root.right, ans);
  }

  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    exactlyOneChild(root, ans);
    return ans;
  } 

  public static int countExactlyOneChild(TreeNode root) {
      if(root == null ||(root.left == null && root.right == null))
        return 0;
      int l = countExactlyOneChild(root.left);
      int r = countExactlyOneChild(root.right);
      int ans = l + r;
      if(root.left == null || root.right == null)
        ans++;
      return ans;
  }
  
}