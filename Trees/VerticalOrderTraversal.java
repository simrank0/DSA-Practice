package Trees;

import java.util.*;

public class VerticalOrderTraversal {
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
    Map<Integer, Map<Integer,List<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preOrderTraversal(root, 0,0);

        List<List<Integer>> ans = new LinkedList<>();

        for(Map.Entry<Integer, Map<Integer, List<Integer>>> m : map.entrySet()){
            List<Integer> tmp = new LinkedList<>();
            for(Map.Entry<Integer, List<Integer>> sub : m.getValue().entrySet()){
                Collections.sort(sub.getValue());
                tmp.addAll(sub.getValue());
            }
            ans.add(tmp);
        }
        return ans;
    }

    private void preOrderTraversal(TreeNode root, int level,int down){
        if(root == null) return;
        Map<Integer, List<Integer>> rowMap = map.get(level);
        List<Integer> val = null;
        if(rowMap != null){
            val = rowMap.get(down);
            if(val == null){
                val = new LinkedList<>();
            }
        }else{
            val = new LinkedList<>();
            rowMap = new TreeMap<>();
        }
        val.add(root.val);
        rowMap.put(down, val);
        map.put(level, rowMap);
        preOrderTraversal(root.left, level -1, down+1);
        preOrderTraversal(root.right, level+1, down+1);
    }
}
