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

public class BST_using_Inorder_Postorder {
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildBST(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildBST(int[] postorder, int left, int right) {
        if (left > right)
            return null;

        int rootval = postorder[postIndex--];
        TreeNode root = new TreeNode(rootval);

        int index = inorderIndexMap.get(rootval);

        root.right = buildBST(postorder, index + 1, right);
        root.left = buildBST(postorder, left, index - 1);

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

        int[] inorder = new int[s];
        int[] postorder = new int[s];

        System.out.println("Enter inorder traversal:");
        for (int i = 0; i < s; i++) {
            inorder[i] = sc.nextInt();
        }

        System.out.println("Enter postorder traversal:");
        for (int i = 0; i < s; i++) {
            postorder[i] = sc.nextInt();
        }
        sc.close();

        BST_using_Inorder_Postorder builder = new BST_using_Inorder_Postorder();
        TreeNode root = builder.buildTree(inorder, postorder);

        System.out.println("Inorder traversal of constructed BST:");
        printInorder(root);
        System.out.println();
    }
}
