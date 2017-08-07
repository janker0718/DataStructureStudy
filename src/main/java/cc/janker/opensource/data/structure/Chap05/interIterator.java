package cc.janker.opensource.data.structure.Chap05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhiyongliu3 on 2017/8/7.
 */
class Link6 {
    public long dData;             // data item
    public Link6 next;              // next link in list

    // -------------------------------------------------------------
    public Link6(long dd)           // constructor
    {
        dData = dd;
    }

    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print(dData + " ");
    }
}  // end class Link

class LinkList2 {
    private Link6 first;

    public LinkList2() {
        first = null;
    }

    public Link6 getFirst() {
        return first;
    }

    public void setFirst(Link6 f) {
        first = f;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    public void displayList() {
        Link6 current = first;       // start at beginning of list
        while (current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
}

class ListIterator {
    private Link6 current;
    private Link6 previous;
    private LinkList2 ourList;

    public ListIterator(LinkList2 linkList) {
        ourList = linkList;
        reset();
    }

    public void reset() {       //从first开始
        current = ourList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public void nextLink() { //go to next link
        previous = current;
        current = current.next;
    }


    public Link6 getCurrent() {
        return current;
    }

    public void insertAfter(long dd) {
        Link6 newLink = new Link6(dd);

        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(long dd) {
        Link6 newLink = new Link6(dd);
        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long value = current.dData;
        if (previous == null) {          // beginning of list
            ourList.setFirst(current.next);
            reset();
        } else {                           // not beginning
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }

        }
        return value;
    }
}

class InterIterApp {
    public static void main(String[] args) throws IOException {
        LinkList2 theList = new LinkList2();
        ListIterator iter1 = theList.getIterator();
        long value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertBefore(60);


        while (true) {
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();         // get user's option
            switch (choice) {
                case 's':                    // show list
                    if (!theList.isEmpty())
                        theList.displayList();
                    else
                        System.out.println("List is empty");
                    break;
                case 'r':                    // reset (to first)
                    iter1.reset();
                    break;
                case 'n':                    // advance to next item
                    if (!theList.isEmpty() && !iter1.atEnd())
                        iter1.nextLink();
                    else
                        System.out.println("Can't go to next link");
                    break;
                case 'g':                    // get current item
                    if (!theList.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    } else
                        System.out.println("List is empty");
                    break;
                case 'b':                    // insert before current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a':                    // insert after current
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd':                    // delete current item
                    if (!theList.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else
                        System.out.println("Can't delete");
                    break;
                default:
                    System.out.println("Invalid entry");
            }  // end switch
        }  // end while
    }  // end main()

    //--------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    //-------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
