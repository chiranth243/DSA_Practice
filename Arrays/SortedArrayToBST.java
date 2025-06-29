package Arrays;

import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

class SortedArrayToBST{
    public static TreeNode arrToBST(int[] nums){
        return buildBST(nums, 0, nums.length-1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right){
        if(left > right){
            return null;
        }

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid-1);
        root.right = buildBST(nums, mid+1, right);

        return root;
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter the array size:");
        int s = sc.nextInt();

        int[] arr = new int[s];

        for(int i = 0; i < s; i++){
            arr[i] = sc.nextInt();
        }

        TreeNode root = arrToBST(arr);
        System.out.println("Inorder traversal of constructed BST:");
        printInOrder(root);
        sc.close();
    }
}