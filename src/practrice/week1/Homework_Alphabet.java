package src.practrice.week1;

public class Homework_Alphabet {
    public static void main(String[] args) {
        System.out.println(solve("awadzaazbbzcezddae"));
    }

    public static String solve(String inputValue) {

        StringBuilder sb = new StringBuilder();
        int [] alpabetCount = new int [26];

        for(int i = 0 ; i < inputValue.length() ; i++) {
            alpabetCount[(int) (inputValue.charAt(i) - 'a')]++;
        }


        for(int i = 0; i < alpabetCount.length; i++) {
            if(alpabetCount[i] > 0) {
                sb.append((char) (i+'a'));
                sb.append(alpabetCount[i]);
                sb.append("/");
            }
        }
        sb.delete(sb.length()-1, sb.length());

        return sb.toString();
    }
}
