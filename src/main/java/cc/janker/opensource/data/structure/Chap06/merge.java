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

    private static void display(int[] theArray, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println("");
    }


    private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;

        while (aDex < sizeA && bDex < sizeB){
            if (arrayA[aDex] < arrayB[bDex]){
                arrayC[cDex++] = arrayA[aDex++];
            }else{
                arrayC[cDex++] = arrayB[bDex++];
            }
        }
        while (aDex < sizeA){              //arrayB为空
            arrayC[cDex++] = arrayA[aDex++];
        }
        while (bDex < sizeB){               //arrayA为空
            arrayC[cDex++] = arrayB[bDex++];
        }
    }


}
