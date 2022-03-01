package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> ans= new ArrayList<>();
        if(node==null)
            return ans;
        if(node.left==null && node.right==null){
            List<Integer> list=new ArrayList<>();
            list.add(node.val);
            ans.add(list);
            return ans;
        }
        List<Integer> list= new ArrayList<>();
        Deque<TreeNode> mainStack= new ArrayDeque<>();
        Deque<TreeNode> childStack= new ArrayDeque<>();
        int level=1;
        mainStack.push(node);
        while(!mainStack.isEmpty()){
            node=mainStack.pop();
            list.add(node.val);
            if( level%2 == 1 ){
                if(node.left!=null)
                    childStack.push(node.left);
                if(node.right!=null)
                    childStack.push(node.right);
            }else{
                if(node.right!=null)
                    childStack.push(node.right);
                if(node.left!=null)
                    childStack.push(node.left);
            }
            if(mainStack.isEmpty()){
                mainStack=childStack;
                childStack= new ArrayDeque<>();
                level++;
                ans.add(list);
                list = new ArrayList<>();

            }
        }
        return ans;
    }
}
