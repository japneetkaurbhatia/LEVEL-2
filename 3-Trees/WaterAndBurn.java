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
    public int waterAndBurn(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans, HashSet<TreeNode> water) {
        if(root == null)
            return -1;

        if(water.containsKey(root))   
            return -2; 
        
        if(root.val == target && !water.containsKey(root)) {
            printAtDepthK(root,0,null,ans);
            return 1;
        }
        
        int  ld = waterAndBurn(root.left, target,ans); 
        if(ld != -1) {
            printAtDepthK(root,ld,root.left,ans);
            return ld + 1;
        }
        
        int  rd = waterAndBurn(root.right, target, k, ans); 
        if(rd != -1) {
            printAtDepthK(root,rd,root.right,ans);
            return rd + 1;
        }
        return -1;
    }