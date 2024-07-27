import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class DeleteNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        System.out.println("toDeleteSet :" + toDeleteSet);
        List<TreeNode> forest = new ArrayList<>();

        root = processNode(root, toDeleteSet, forest);

        // If the root is not deleted, add it to the forest
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode processNode(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        node.left = processNode(node.left, toDeleteSet, forest);
        node.right = processNode(node.right, toDeleteSet, forest);

        // Node Evaluation: Check if the current node needs to be deleted
        System.out.println("node.val :" + node.val);

        if (toDeleteSet.contains(node.val)) {
            // If the node has left or right children, add them to the forest
            System.out.println("toDeleteSet :" + node.val);
            System.out.println("node.left :" + node.left);
            System.out.println("node.right :" + node.right);
            // System.exit(0);
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            // Return null to its parent to delete the current node
            for (TreeNode tree : forest) {
                printTree(tree);
                System.out.println();
            }

            return null;
        }

        System.out.println("Last Node :" + node.val);

        return node;
    }

    public static void main(String[] args) {
        // Create the binary tree based on the input [1,2,3,4,5,6,7,8,9,10,11,12,13,14]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);

        int[] to_delete = { 1};

        DeleteNodes solution = new DeleteNodes();
        List<TreeNode> forest = solution.delNodes(root, to_delete);

        // Display the forest
        System.out.println("---------------------------------------------------------");

        for (TreeNode tree : forest) {
        printTree(tree);
        System.out.println();
        }
    }

    // Helper method to print the tree (preorder traversal)
    public static void printTree(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
