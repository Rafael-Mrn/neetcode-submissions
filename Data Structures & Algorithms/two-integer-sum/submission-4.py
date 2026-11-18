class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        '''
        Data Structure: dictionary (hash table)

        1. Iterate over nums and 
        2. Generate a complement (target - current num)
        3. If this compelement is equal to a number we've seen in nums, we found tha answer
            - Append the index of num that is equal to the complement (it was seen first)
            - Append the index of current num (second num)
        4. (Otherwise) Add the num see seen to the hashtable
            - Key: num, Value: it's index
        
        '''
        
        # Use a hash table to store the numbers we've seen
        seen = {}
        # List that will return the two indeces
        result = []

        # Iterate over the list keeping track of the index
        for i in range(len(nums)):
            complement = target - nums[i]
            # If the complement generated is a number we've seen, we found the solution
            if complement in seen:
                # Append index of number in seen (it was seen first, so has a smaller index)
                result.append(seen[complement])    
                # Append the index of the current number
                result.append(i)
                return result

            # Key: number seen, Value: it's index in nums
            seen[nums[i]] = i

        