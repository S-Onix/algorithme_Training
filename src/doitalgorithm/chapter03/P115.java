package doitalgorithm.chapter03;

public class P115 {
    public int seqSearchSen(int [] a , int n, int key){
        int i = 0;
        a[n] = key;
        for(i = 0; i< a.length-1; i++){
            if(a[i] == key)
                return i;
        }
        return -1;
    }

    public int printSeqSearch(int [] a, int n, int key){
        System.out.print("   |");
        for(int i = 0; i < 7; i ++){
            System.out.printf("%3d", i);
        }
        System.out.println();
        System.out.println("---+---------------------");

        for (int i = 0; i < n; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
            System.out.printf("%3d|", i);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        P115 p115 = new P115();
        int a [] = {6,4,3,2,1,9,8,-1};
        int size = 7;

        p115.printSeqSearch(a, size, 3);
    }
}
