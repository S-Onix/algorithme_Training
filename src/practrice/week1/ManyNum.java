package src.practrice.week1;

import java.util.ArrayList;
import java.util.List;

public class ManyNum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(2);

        //System.out.println(solve(list));
        System.out.println(solve("Time is very fast aTnd you becoTmTe older"));
    }

    // int num = 65; char c = (char)num; 아스키 숫자를 문자로 바꾸기
    public static char solve(String inputString) {
        int [] manyCount = new int [1000];
        int manyIndex = 0;
        boolean isDuplicate = false;
        int duplicateIndex = 0;

        // 알파벳만 저장
        for(int i = 0; i < inputString.length(); i++) {
            int ascii = inputString.charAt(i);
            if(ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122) {
                manyCount[ascii]++;
            }

        }
        for(int i = 1; i < manyCount.length; i++) {
            if(manyCount[i] != 0 ) {
                if (manyCount[i] == manyCount[manyIndex]) {
                    isDuplicate = true;
                    duplicateIndex = i;
                }

                if (manyCount[manyIndex] < manyCount[i]) {
                    manyIndex = i;
                    isDuplicate = false;
                }
            }
        }

        if(isDuplicate && duplicateIndex != 0) {
            manyIndex = '*';
        }

        return (char)manyIndex;
    }

    public static int solve(List<Integer> inputArray){
        int[] manyCount = new int [1001];
        boolean isDuplicate = false;
        int duplicateIndex = 0;
        int manyIndex = 0;
        for(int i = 0 ; i < inputArray.size() ; i++){
            manyCount[inputArray.get(i)]++;
        }

        for(int i = 1; i < manyCount.length; i++) {
            if(manyCount[i] != 0) {
                if (manyCount[i] == manyCount[manyIndex]) {
                    isDuplicate = true;
                    duplicateIndex = i;
                }

                if (manyCount[manyIndex] < manyCount[i]) {
                    manyIndex = i;
                    isDuplicate = false;
                }
            }
        }

        if(isDuplicate && duplicateIndex != 0) {
            manyIndex = -1;
        }

        return manyIndex;
    }

}
