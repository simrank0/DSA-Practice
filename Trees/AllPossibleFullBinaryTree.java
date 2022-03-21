package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPossibleFullBinaryTree {

    public static void main(String[] args) {
        Solution1 ans = new Solution1();

        //Expected size = 5
        System.out.println(Arrays.toString(ans.allPossibleFBT(7).toArray()));
        System.out.println("Size for input 7: " + ans.allPossibleFBT(7).size());

        //Expected size = 1
        System.out.println(Arrays.toString(ans.allPossibleFBT(3).toArray()));
        System.out.println("Size for input 3: " + ans.allPossibleFBT(3).size());

    }

}

class Solution1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        if (N <= 0 || N % 2 == 0) return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode l : left)
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
        }
        return ans;
    }
}
