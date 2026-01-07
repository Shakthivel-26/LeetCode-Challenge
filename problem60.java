class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        dfs(root);
        return (int)(maxProduct % MOD);
    }
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }
    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long left = dfs(node.left);
        long right = dfs(node.right);
        long subSum = node.val + left + right;
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);
        return subSum;
    }
}
