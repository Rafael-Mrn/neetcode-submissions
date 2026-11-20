class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        '''
        Data Structure: Hash Table
        - Key: hash, Value: list of anagrams

        Algorithm:
            - Iterate over every string in strs and generate a hash using
            a integer counter array
            - Add this hash to the hash table if not seen (key)
            - Add the word as a value for that hash
            - return the values of hash table as a list of lists
        '''

        # Dicionary to hold hash as key and list of words that share that hash as the value
        dictionary: dict[str, List[str]] = {}

        # List of lists that store str - grouped anagrams
        result: List[List[str]] = []


        for s in strs:
            counter = [0] * 26

            for c in s:
                # Use integer value of chars to increment counter
                index = ord(c) - ord('a')
                counter[index] += 1

            key = tuple(counter)

            # If hash not in dictionary, add it as a key, and use s to intialize a list
            if key not in dictionary:
                dictionary[key] = [s]
            # Else append to the respective list of anagrams that share the hash
            else:    
                dictionary[key].append(s)

        # For the list of strs (values) of dictionary append to result
        for anagramList in dictionary.values():
            result.append(anagramList)

        return result   