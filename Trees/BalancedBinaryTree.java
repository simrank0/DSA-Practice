package Trees;

public class BalancedBinaryTree {
    private class TreeNode {
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
 public boolean isBalanced(TreeNode root) {
  if(root==null)
   return true;
  return checkBalance(root)!=-2;

 }

 private int checkBalance(TreeNode node){
  if(node==null)
   return -1;
  if(node.left==null && node.right==null)
   return 0;
  int leftHeight=checkBalance(node.left);
  int rightHeight=checkBalance(node.right);
  if(Math.abs(rightHeight-leftHeight)>1 || rightHeight==-2||leftHeight==-2)
   return -2;
  int curHeight=Math.max(leftHeight,rightHeight)+1;

  return curHeight;
 }
}
