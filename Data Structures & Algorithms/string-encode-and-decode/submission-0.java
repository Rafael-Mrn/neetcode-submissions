class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String string : strs)
        {
            result.append(string.length()).append('#').append(string);
        }

        return result.toString();
    }

    public List<String> decode(String str) {        
        List<String> result = new ArrayList<>();

        int wordStartIndex = 0;
        while (wordStartIndex < str.length())
        {
            int indexOfDelimiter = wordStartIndex;

            // Find index of delimeter '#', finds first occurrence of '#'
            while (str.charAt(indexOfDelimiter) != '#')
            {
                indexOfDelimiter++;
            }

            int lengthOfWord = Integer.parseInt(str.substring(wordStartIndex, indexOfDelimiter));
            wordStartIndex = indexOfDelimiter + 1;

            // Acts as the index of the end of the word
            indexOfDelimiter = wordStartIndex + lengthOfWord;

            result.add(str.substring(wordStartIndex, indexOfDelimiter));

            // New start for next loop iteration is at the index of the current delimeter
            wordStartIndex = indexOfDelimiter;
        }

        return result;
    }
}
