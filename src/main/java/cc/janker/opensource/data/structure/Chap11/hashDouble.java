package cc.janker.opensource.data.structure.Chap11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhiyongliu3 on 2017/8/14.
 */
class DataItem1 {                                 // (could have more items)
    private int iData;                // data item (key)

    //--------------------------------------------------------------
    public DataItem1(int ii)           // constructor
    {
        iData = ii;
    }

    //--------------------------------------------------------------
    public int getKey() {
        return iData;
    }
//--------------------------------------------------------------
}  // end class DataItem

class HashTable1 {
    private DataItem1[] hashArray;     // array is the hash table
    private int arraySize;
    private DataItem1 nonItem;         // for deleted items

    // -------------------------------------------------------------
    HashTable1(int size)               // constructor
    {
        arraySize = size;
        hashArray = new DataItem1[arraySize];
        nonItem = new DataItem1(-1);
    }

    // -------------------------------------------------------------
    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    // -------------------------------------------------------------
    public int hashFunc1(int key) {
        return key % arraySize;
    }

    // -------------------------------------------------------------
    public int hashFunc2(int key) {
        // non-zero, less than array size, different from hF1
        // array size must be relatively prime to 5, 4, 3, and 2
        return 5 - key % 5;
    }

    // -------------------------------------------------------------
    // insert a DataItem
    public void insert(int key, DataItem1 item)
    // (assumes table not full)
    {
        int hashVal = hashFunc1(key);  // hash the key
        int stepSize = hashFunc2(key); // get step size
        // until empty cell or -1
        while (hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;        // add the step
            hashVal %= arraySize;       // for wraparound
        }
        hashArray[hashVal] = item;     // insert item
    }  // end insert()

    // -------------------------------------------------------------
    public DataItem1 delete(int key)   // delete a DataItem
    {
        int hashVal = hashFunc1(key);      // hash the key
        int stepSize = hashFunc2(key);     // get step size

        while (hashArray[hashVal] != null)  // until empty cell,
        {                               // is correct hashVal?
            if (hashArray[hashVal].getKey() == key) {
                DataItem1 temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem;       // delete item
                return temp;                        // return item
            }
            hashVal += stepSize;            // add the step
            hashVal %= arraySize;           // for wraparound
        }
        return null;                   // can't find item
    }  // end delete()

    // -------------------------------------------------------------
    public DataItem1 find(int key)     // find item with key
    // (assumes table not full)
    {
        int hashVal = hashFunc1(key);      // hash the key
        int stepSize = hashFunc2(key);     // get step size

        while (hashArray[hashVal] != null)  // until empty cell,
        {                               // is correct hashVal?
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];   // yes, return item
            hashVal += stepSize;            // add the step
            hashVal %= arraySize;           // for wraparound
        }
        return null;                   // can't find item
    }
// -------------------------------------------------------------
}  // end class HashTable
class HashDoubleApp
{
    public static void main(String[] args) throws IOException
    {
        int aKey;
        DataItem1 aDataItem;
        int size, n;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        // make table
        HashTable1 theHashTable = new HashTable1(size);

        for(int j=0; j<n; j++)      // insert data
        {
            aKey = (int)(java.lang.Math.random() * 2 * size);
            aDataItem = new DataItem1(aKey);
            theHashTable.insert(aKey, aDataItem);
        }

        while(true)                 // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem1(aKey);
                    theHashTable.insert(aKey, aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //--------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
//--------------------------------------------------------------
}  // end class HashDoubleApp
////////////////////////////////////////////////////////////////