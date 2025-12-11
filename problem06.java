class problem6{
    public int removeElement(int[] nums, int val) {
        int k = 0; // pointer for non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        problem6 sol = new problem6();
        int[] nums1 = {3, 2, 2, 3};
        int k1 = sol.removeElement(nums1, 3);
        System.out.println(k1); // Output: 2

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = sol.removeElement(nums2, 2);
        System.out.println(k2); // Output: 5
    }
}
