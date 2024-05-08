package problems.leetcode.tree;

public class problem_100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(1);

        p.left = p2;
        p.right = p3;

        TreeNode q = new TreeNode(1);

        q.left = p2;
        q.right = p3;

        isSameTree(p, q);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // 두 트리가 모두 비어 있으면 같다고 간주
        if (p == null && q == null) {
            return true;
        }

        // 두 트리 중 하나만 비어 있으면 다르다고 간주
        if (p == null || q == null) {
            return false;
        }

        // 현재 노드의 값이 서로 같으면 다음 노드 재귀 확인
        if (p.val == q.val) {
            // 왼쪽 서브트리와 오른쪽 서브트리를 재귀적으로 비교
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    static public class TreeNode {
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
}
