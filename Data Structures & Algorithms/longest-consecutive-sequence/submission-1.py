class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        '''
        Data Structure: Set (Hash Set)

        Algorithm
            - Determine the start of a sequence
            - If a number is that start of a sequence, track and increment lenght
            for every existing number in nums (using set for O(1) lookup) that keeps
            the sequence
                - num + length
            - return tracked length/longest, whichever is greater
        '''

        # Convert the list into a set for O(1) lookups
        numSet = set(nums)

        # Initialize longest to track the lenght of the longest consecutive sequence
        longest = 0
        
        for num in nums:
            # If num is the start of a sequence (doesn't have a left neighbor that = num - 1)
            if (num - 1) not in numSet:
                # Initialize length of sequence 
                length = 1

                # While the next number in the sequence is in numSet
                while (num + length) in numSet:
                    # Track length, increment it by 1
                    length += 1
                # Longest is either the lenght of a sequence or 0
                longest = max(length, longest)
        
        return longest

