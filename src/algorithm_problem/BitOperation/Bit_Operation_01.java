package algorithm_problem.BitOperation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bit_Operation_01 {
    //카카오 코딩테스트 01번 비밀지도

    private static int [] map1;
    private static int [] map2;
    private static int [] arr1 = {46,33,33,22,31,50};
    private static int [] arr2 = {27,56,19,14,14,10};
    private static int MAPSIZE;

    public static void Solve() throws Exception{
        //initMap();
        //int [] result = orOperation(map1, map2);
        int [] result2 = orOperation(arr1, arr2);
        //String [] resultArray = convertBinaryString(result);
        String [] resultArray2 = convertBinaryString(result2);
        printArray(resultArray2);
    }

    public static void initMap() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("맵의 크기를 입력하세요");
        MAPSIZE = Integer.parseInt(br.readLine());
        map1 = new int[MAPSIZE];
        map2 = new int[MAPSIZE];
        System.out.println("지도1의 암호를 입력하세요");
        for(int i = 0; i < map1.length; i++){
            map1[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("지도2의 암호를 입력하세요");
        for(int i = 0; i < map2.length; i++){
            map2[i] = Integer.parseInt(br.readLine());
        }

    }

    public static void printArray(String [] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println();
    }

    public static int [] orOperation(int [] array1, int [] array2){
        int [] resultArray = new int [array1.length];

        for(int i = 0; i < resultArray.length; i++){
            resultArray[i] = array1[i]|array2[i];
        }
        return resultArray;
    }

    public static String [] convertBinaryString(int [] array){
        String [] resultArray = new String[array.length];

        for(int i = 0; i < resultArray.length; i++){
            resultArray[i] = Integer.toBinaryString(array[i])
                    .replace("1", "#")
                    .replace("0", " ");
        }

        return resultArray;
    }


    public static void main(String []args) throws Exception{
        Solve();
    }
}
