package cc.janker.opensource.data.structure.Chap03;

/**
 * Created by janker on 2017/8/2.
 */
class Person {
    private String lastName;
    private String firstName;
    private int age;

    //-----------------------------------------------------------
    public Person(String last, String first, int a) {                               // constructor
        lastName = last;
        firstName = first;
        age = a;
    }
    //-----------------------------------------------------------

    public void displayPerson() {
        System.out.print("   Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }

    //-----------------------------------------------------------
    public String getLast()           // get last name
    {
        return lastName;
    }
    // end class Person
}
class ArrayInOb
{
    private Person[] a;                 // ref to array a
    private int nElems;               // number of data items
    //--------------------------------------------------------------
    public ArrayInOb(int max)          // constructor
    {
        a = new Person[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //--------------------------------------------------------------
    public void insert(String last, String first, int age)    // put element into array
    {
        a[nElems] = new Person(last,first,age);             // insert it
        nElems++;                      // increment size
    }
    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            a[j].displayPerson();  // display it
        System.out.println("");
    }
    //--------------------------------------------------------------
    public void insertionSort() {
        int out ,in;

        for (out = 0;  out < nElems ; out++) {
            Person temp = a[out];
            //
//           in = out;
//           while (in > 0 && a[in-1] >= temp ) {//便利小于in的值
//               //数组后移
//               a[in] = a [in-1];
//               --in;
//           }
            for (in = out;  in >0 ; in-- ) {
                if(a[in-1].getLast().compareTo(temp.getLast()) >0){
                    a[in] = a [in-1];
                    a[in-1] = temp;
                }
            }

        }
    }  // end insertionSort()
//--------------------------------------------------------------
}  // end class ArrayIns
class ObjectSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;             // array size
        ArrayInOb arr;                 // reference to array
        arr = new ArrayInOb(maxSize);  // create the array

        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Doc", 59);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Smith", "Paul", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting:");
        arr.display();                 // display items

        arr.insertionSort();           // insertion-sort them

        System.out.println("After sorting:");
        arr.display();                 // display them again
    }  // end main()
}  // end class ObjectSortApp
////////////////////////////////////////////////////////////////
