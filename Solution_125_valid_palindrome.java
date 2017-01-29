public class Solution{
    public boolean isPalindrome(String s) { //12345  1234
        if(s.isEmpty()||s.length()<1) return true;
        
        s = s.trim().toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        System.out.println(s);

        // Math.ceil(s.length()/2.0)
        for(int i=0; i< s.length()/2; i++){
            if(s.charAt(i)!= s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(
            slt.isPalindrome(new String("@##@ 123 2 1"))
        );
    }
}
