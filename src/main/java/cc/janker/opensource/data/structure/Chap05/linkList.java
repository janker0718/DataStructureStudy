package cc.janker.opensource.data.structure.Chap05;

/**
 * Created by zhiyongliu3 on 2017/8/3.
 */
class Link {
    public int iData;              // data item
    public double dData;           // data item
    public Link next;              // next link in list

    // -------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
        iData = id;                 // initialize data
        dData = dd;                 // ('next' is automatically
    }                           //  set to null)

    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}  // end class Link
class LinkList{
    private Link first;

    public LinkList(){
        first = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id, double dd){
        Link newLink = new Link(id,dd);
        newLink.next = first;   //新链表的下一个link指向原来link的首位
        first = newLink;    // 原来链表的首位变成新链表
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
    public Link deleteFirst(){
        Link temp = first;
        first = first.next;
        return temp;
    }
    public Link find(int key){
        Link current = first;
        while(current.iData!=key){
            //不存在
            if (current.next == null){
                return null;
            }else{
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key){
        Link current = first;
        //以前的
        Link previous = first;

        while(current.iData!=key){
            //不存在
            if (current.next == null){
                return null;
            }else{
                //链表有数据 但没找到
                previous = current;
                current = current.next;
            }
        }
        if (current == first){
            first = first.next;
        }else{
            previous.next = current.next;
        }
        return current;
    }
}
class LinkListApp
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();  // make new list

        theList.insertFirst(22, 2.99);      // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();              // display list

        while( !theList.isEmpty() )         // until it's empty,
        {
            Link aLink = theList.deleteFirst();   // delete link
            System.out.print("Deleted ");         // display it
            aLink.displayLink();
            System.out.println("");
        }
        theList.displayList();              // display list
    }  // end main()
}  // end class LinkListApp
class LinkList2App
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();  // make list

        theList.insertFirst(22, 2.99);      // insert 4 items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();              // display list

        Link f = theList.find(44);          // find item
        if( f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        Link d = theList.delete(66);        // delete item
        if( d != null )
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        theList.displayList();              // display list
    }  // end main()
}  // end class LinkList2App