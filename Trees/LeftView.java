package Trees;

import java.util.ArrayList;

/**
 * Left view of a binary tree
 */
public class LeftView {

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        leftView(root, result, 0);
        return result;
    }

    void leftView(Node root, ArrayList<Integer> view, int i) {

        if (root == null) {
            return;
        }

        if (view.size() == i) {
            view.add(root.data);
        }

        leftView(root.left, view, i+1);
        leftView(root.right, view, i+1);
    }
}
