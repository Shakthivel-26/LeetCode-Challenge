import java.util.*;
class problem01{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = s.nextInt();
        }
        int target = s.nextInt();
        
        int[] result = twoSum(nums, target);
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {}; // won't reach here as per constraints
    }
}
