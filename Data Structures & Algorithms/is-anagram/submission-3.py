class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if (len(s) != len(t)): return False

        lettersSeen = [0] * 26 #26 zeros to avoid IndexError

        for i in range(len(s)):
            lettersSeen[ord(s[i]) - ord('a')] += 1
            lettersSeen[ord(t[i]) - ord('a')] -= 1
        
        for val in lettersSeen:
            if val != 0:
                return False
        return True


