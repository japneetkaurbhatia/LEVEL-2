https://practice.geeksforgeeks.org/problems/burning-tree/1#

public static void printAtDepthK(Node root, int time, Node blockNode, ArrayList<ArrayList<Integer>> ans) {
        if (root == null || root == blockNode)
            return;

        if (time == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(time).add(root.data);

        printAtDepthK(root.left,time + 1, blockNode, ans);
        printAtDepthK(root.right, time + 1, blockNode, ans);
    }
    public static int burningTree(Node root, int target, ArrayList<ArrayList<Integer>> ans) {
        if(root == null)
            return -1;
        
        if(root.data == target) {
            printAtDepthK(root,0,null,ans);
            return 1;
        }
        
        int  ld = burningTree(root.left, target,ans); 
        if(ld != -1) {
            printAtDepthK(root,ld,root.left,ans);
            return ld + 1;
        }
        
        int  rd = burningTree(root.right, target, ans); 
        if(rd != -1) {
            printAtDepthK(root,rd,root.right,ans);
            return rd + 1;
        }
        return -1;
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int rv =burningTree(root,target,ans);
        return ans.size() - 1;
    }