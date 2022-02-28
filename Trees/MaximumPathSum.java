package Trees;

public class MaximumPathSum {
    static class TreeNode {
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
    int maximumPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumCalc(root);
        return maximumPathSum ;
    }
    int maxPathSumCalc (TreeNode tree){
        if(tree == null) return 0;
        int leftSum = maxPathSumCalc(tree.left);
        int rightSum = maxPathSumCalc(tree.right);
        int temp = Math.max(leftSum,rightSum) > 0 ? tree.val + Math.max(leftSum,rightSum) : tree.val;
        int currentAnswer = Math.max(temp,leftSum + rightSum + tree.val);
        maximumPathSum = Math.max(maximumPathSum,currentAnswer);
        return temp;
    }
}
