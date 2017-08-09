package cc.janker.opensource.data.structure.Chap08;

/**
 * Created by zhiyongliu3 on 2017/8/9.
 */
class Node {
    public int iData;  // key
    public double dData; // data item
    public Node leftChild;
    public Node rightChild;
    public void displayNode(){
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}
class Tree{
    private Node root;  //first Node of tree

    public Tree(){
        root = null;
    }


    public Node Find(int key){
        Node current = root;

        while (current.iData != key){
            if (key < current.iData){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int id,double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null){
            root = newNode;
        }else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (id < current.iData){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key){
            parent = current;
            if (key < current.iData){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null){
            if (current == root){
                root = null;
            }else if (isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if (current.rightChild == null){
            if (current == root){
                root = current.leftChild;
            }else if (isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }else if (current.leftChild == null){
            if (current == root){
                root  = current.rightChild;
            }else if (isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }else{
            Node successor = getSuccessor(current);
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null){
            successorParent = successor;
            successor = current.leftChild;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild){
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}

