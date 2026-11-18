class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        result = []

        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in seen:
                result.append(seen[complement])
                result.append(i)
                return result
            seen[nums[i]] = i

        