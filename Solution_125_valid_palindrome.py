import re

class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """

        s = s.strip().lower()
        s = re.sub(r'\W+', '', s)

        print s

        for i in range(0, len(s)/2):
            if s[i]!=s[len(s)-1-i]:
                return False;

        return True;


slt = Solution();
res = slt.isPalindrome("@##@ 122 2 1 \t 2221")

print res
