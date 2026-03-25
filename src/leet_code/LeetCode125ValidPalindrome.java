package src.leet_code;

public class LeetCode125ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        String validString = sb.toString().toLowerCase();

        for(int i = 0; i < validString.length()/2; i++) {
            if(validString.charAt(leftIndex) != validString.charAt(rightIndex)) {
                return false;
            }
        }

        return true;

    }
}
