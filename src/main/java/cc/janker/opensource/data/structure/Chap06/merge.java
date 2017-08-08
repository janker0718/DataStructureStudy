package cc.janker.opensource.data.structure.Chap06;

/**
 * Created by zhiyongliu3 on 2017/8/8.
 */
class MergeApp {
    public static void main(String[] args) {
        int[] arrayA = {23,47,81,95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[10];
        
        
        merge(arrayA,4,arrayB,6,arrayC);
        display(arrayC,10);
    }

    private static void display(int[] arrayC, int i) {
    }


    private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;

        while (aDex < sizeA && bDex < sizeB){
            if (arrayA[aDex] < arrayB[bDex]){
                //arrayC[cDex++] =
            }
        }
    }
}
