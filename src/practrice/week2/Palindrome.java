package src.practrice.week2;

public class Palindrome {

    public static void main(String[] args) {
        String s = "aaabbcsccbbaaa";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if(s.charAt(start) == s.charAt(end)) {
            return isPalindrome(s, start + 1, end - 1);
        }else {
            return false;
        }
    }
}
