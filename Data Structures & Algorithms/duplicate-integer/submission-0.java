class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int index = 0; index < nums.length; index++){
            if (!integerSet.add(nums[index])) return true;
        }

        return false;
    }
}