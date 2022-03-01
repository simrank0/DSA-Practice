package Trees;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> plist= nodeToRootPath(root,p.val);
        List<Integer> qlist= nodeToRootPath(root,q.val);
        int i=plist.size()-1;
        int j=qlist.size()-1;
        while(i>=0 && j>=0 && plist.get(i).equals(qlist.get(j))){
            --i;
            --j;
        }
        return new TreeNode(qlist.get(j+1));
    }
    private ArrayList<Integer> nodeToRootPath(TreeNode root,int target){
        if(root==null)
            return null;
        if(root.val == target){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(root.val);
            return list;
        }
        ArrayList<Integer> leftRes=nodeToRootPath(root.left,target);
        if(leftRes!=null){
            leftRes.add(root.val);
            return leftRes;
        }
        ArrayList<Integer> rightRes=nodeToRootPath(root.right,target);
        if(rightRes!=null){
            rightRes.add(root.val);
            return rightRes;
        }
        return null;
    }

}
