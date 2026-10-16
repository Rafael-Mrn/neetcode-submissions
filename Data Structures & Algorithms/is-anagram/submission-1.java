class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];

        for (char c : s.toCharArray()){
            int characterIndex = c - 'a';
            counter[characterIndex] += 1;
        }

        for (char c : t.toCharArray()){
            int characterIndex = c - 'a';
            counter[characterIndex] -= 1;
        }

        for (int x : counter){
            if (x != 0) return false;
        }

        return true;
    }
}
