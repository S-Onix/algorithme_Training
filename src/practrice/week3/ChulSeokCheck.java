package src.practrice.week3;

import java.util.Arrays;
import java.util.HashMap;

public class ChulSeokCheck {

    public static void main(String[] args) {
        String [] allStuduents = {"나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위", "하영"};
        String [] presentStudents = {"정연", "모모", "채영", "쯔위", "지효", "사나", "나연", "미나", "다현"};
        System.out.println(solve(allStuduents, presentStudents));
        System.out.println(solve2(allStuduents, presentStudents));
    }

    public static String solve(String [] allStudents, String [] presentStudents) {

        Arrays.sort(allStudents);
        Arrays.sort(presentStudents);

        for(int i = 0; i < presentStudents.length; i++){
            if(!allStudents[i].equals(presentStudents[i])){
                return allStudents[i];
            }
        }

        return allStudents[allStudents.length-1];
    }

    public static String solve2(String [] allStudents, String [] presentStudents) {
        HashMap<String, Boolean> checkHashMap = new HashMap<>();

        for(int i = 0; i < allStudents.length; i++){
            checkHashMap.put(allStudents[i], true);
        }

        for(int i = 0; i < presentStudents.length; i++){
            checkHashMap.remove(presentStudents[i]);
        }

        for(String key : checkHashMap.keySet()){
            return key;
        }
        return "";
    }


}
