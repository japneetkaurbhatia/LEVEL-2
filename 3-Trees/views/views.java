public class views {
    //level-order
    public static void levelOrder (TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int level = 0;
        while(que.size() != 0) {
            ArrayList<Integer> smallAns = new ArrayList<>();
            System.out.print(level);
            int size = que.size();
            while(size-- > 0) {
                TreeNode rnode = que.removeFirst();
                smallAns.add(rnode.val);
                if(rnode.left != null)
                    que.addLast(rnode.left);
                if(rnode.right != null)
                    que.addLast(rnode.right);
            }
            ans.add(smallAns);
            level++;
        }
        for(var list : ans) 
            System.out.print(list);
    }

    //gfg
    class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        // code here.
        LinkedList<Node> que = new LinkedList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        que.addLast(root);
        while(que.size() != 0) {
            int size = que.size();
            int smallAns = 0;
            while(size-- > 0) {
                Node rm = que.removeFirst();
                
                while(rm != null) {
                    smallAns += rm.data;
                    if(rm.left != null)
                        que.add(rm.left);
                    rm = rm.right;
                }
            }
            ans.add(smallAns);
        }
        return ans;
    }
}
}

