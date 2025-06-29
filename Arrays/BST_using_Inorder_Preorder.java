package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class BST_using_Inorder_Preorder {
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildBST(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildBST(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;

        int rootval = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootval);

        int index = inorderIndexMap.get(rootval);

        root.left = buildBST(preorder, inLeft, index - 1);
        root.right = buildBST(preorder, index + 1, inRight);

        return root;
    }

    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the array size:");
        int s = sc.nextInt();

        int[] preorder = new int[s];
        int[] inorder = new int[s];

        System.out.println("Enter preorder traversal:");
        for (int i = 0; i < s; i++) {
            preorder[i] = sc.nextInt();
        }

        System.out.println("Enter inorder traversal:");
        for (int i = 0; i < s; i++) {
            inorder[i] = sc.nextInt();
        }
        sc.close();

        BST_using_Inorder_Preorder builder = new BST_using_Inorder_Preorder();
        TreeNode root = builder.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of constructed BST:");
        printInorder(root);
        System.out.println();
    }

}
