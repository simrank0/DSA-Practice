package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Top view of a binary tree.
 */
public class TopView {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static ArrayList<Integer> topView(Node root){
        int h=height(root);
        ArrayList<Integer> a= new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int y,i;
        for(i=1;i<=h;i++){
            y=0;
            levelorder(root,i,y,map);
        }
        ArrayList<Integer> sortedKeys= new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(i=0;i<sortedKeys.size();i++)
        {   //a.add(sortedKeys.get(i));
            a.add(map.get(sortedKeys.get(i)));
        }
        return a;

    }
    static void levelorder(Node root,int x,int y,HashMap<Integer, Integer> map){
        if (root != null) {
            if (x == 1) {
                if (!map.containsKey(y)) {
                    map.put(y, root.data);
                }
            } else {
                if (root.left != null) levelorder(root.left, x - 1, y - 1, map);
                if (root.right != null) levelorder(root.right, x - 1, y + 1, map);
            }
        }
    }
    static int height(Node root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
