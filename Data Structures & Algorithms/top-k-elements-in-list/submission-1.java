class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        Store the frequency of the numbers in a ??
            - PriorityQueue, but lacks key:values
                - How can we maintain idea of Key:values
                    - When returning? pass the k elements that are the same? (bucket idea)
                    - If value is the same as previous keep going,
                    - if value is different from previous add
                    - repeat this if statement process K times
            - HashMap, but lacks sorting?
                - Can you sort the HashMap, time complexity?
            - 

        Bucket Sort (inverted?)
            - Initalize an array of size n (number of elements in num)
            - Index = count (bounded by n)
            - Value at index = numbers with that frequency (a list)
            - Iterate over this array (while?)
                - Start from the end
                - Add the numbers at that index into a list (result)
                - Check if size of this list = k
            OR Iterate over array (for loop)
                - Start at end
                - Add [i] element of         
        */

        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] frequency = new List[nums.length + 1];

        for (int i = 0; i < frequency.length; i++) 
        {
            frequency[i] = new ArrayList<>();
        }

        for (int n : nums)
        {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];

        int index = 0;
        for (int i = frequency.length - 1; i > 0 && index < k; i--)
        {
            for (int n : frequency[i])
            {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
