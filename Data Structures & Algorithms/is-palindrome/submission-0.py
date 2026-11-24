class Solution:
    def isPalindrome(self, s: str) -> bool:
        string_lower = s.lower()
        string_alnum = "".join(char for char in string_lower if char.isalnum())
        if string_alnum == string_alnum[::-1]:
            return True
        return False