// https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/

    public void printAtDepthK(TreeNode root, int time, TreeNode blockNode, ArrayList<ArrayList<Integer>> ans) {
        if (root == null || root == blockNode)
            return;

        if (time == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(time).add(root.val);

        printAtDepthK(root.left,time + 1, blockNode, ans);
        printAtDepthK(root.right, time + 1, blockNode, ans);
    }
    public int burningTree(TreeNode root, TreeNode target, ArrayList<ArrayList<Integer>> ans) {
        if(root == null)
            return -1;
        
        if(root.val == target) {
            printAtDepthK(root,0,null,ans);
            return 1;
        }
        
        int  ld = burningTree(root.left, target,ans); 
        if(ld != -1) {
            printAtDepthK(root,ld,root.left,ans);
            return ld + 1;
        }
        
        int  rd = burningTree(root.right, target, k, ans); 
        if(rd != -1) {
            printAtDepthK(root,rd,root.right,ans);
            return rd + 1;
        }
        return -1;
    }