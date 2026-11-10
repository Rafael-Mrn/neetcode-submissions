class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            // Will be used to generate a hash for each word
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                // Increase alphabetical index by 1 each time the letter is seen
                count[c - 'a']++;
            }
            
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }

        // Return ArrayList of HashMap values
        return new ArrayList<>(result.values());


    }
}
