import java.util.Scanner;

public class sol10818 {
	public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        
        int n = scan.nextInt();
        int array[] = new int[n];
        
        for(int i = 0; i< array.length; i++){
            array[i] = scan.nextInt();
        }
        
        System.out.println(minDetect(array) + " " + maxDetect(array));
        
    }
    
    public static int minDetect(int array[]){
        int MinValue = array[0];
        
        for(int i = 1; i < array.length; i++){
            if(MinValue > array[i])
                MinValue = array[i];
        }
        return MinValue;
    }
    
    public static int maxDetect(int array[]){
        int MaxValue = array[0];
        
        for(int i = 0; i< array.length; i++){
            if(array[i] > MaxValue)
                MaxValue = array[i];
        }
        return MaxValue;
    }
}



/*


import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < tc; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		
		System.out.println(min + " " + max);
		
	}
}


*/