/**
 * @author Mawuena Wisdom Eli
 *
 */
package DataStruct;
public class Tree {

    private Node root;
    int SSize=0;



    /**
     * Node Class
     *
     */
    private static class Node{
        Node left;
        Node right;
        int data;

        /**
         * This the node Constructor
         * @param newData is the Value of the node
         */
        Node(int newData){
            left=null;
            right=null;
            data=newData;
        }
    }

    //This use to Create an empty tree
    public void BinaryTree(){
        root=null;
    }


    /**
     *
     * @param data is the value to be inserted into the Binary tree
     */
    public void insert(int data){
        root=insert(root,data);
        SSize+=1;
    }
    private Node insert(Node node,int data){
        if(node==null){
            node=new Node(data);
        }else{
            if(data<=node.data){
                node.left=insert(node.left,data);
            }else{
                node.right=insert(node.right,data);
            }
        }
        return node;
    }

    /**
     *
     * @return The size of the Tree
     */
    public int size(){
        System.out.println(SSize);
        return(size(root));

    }
    private int size(Node node){
        if(node==null){
            return 0;
        }else{
            return size(node.left)+1+size(node.right);
        }
    }
        //*5.printTree() Solution
    public void printTree(){
        printTree(root);
        System.out.println();
    }
    private void printTree(Node node){
        if(node==null){
            return;
        }
        printTree(node.left);
        System.out.print(node.data+" ");
        printTree(node.right);
    }


    public void printPostorder(){
        printPostorder(root);
        System.out.println();
    }
    private void printPostorder(Node node){
        if(node==null){
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data+" ");
    }




    public void printPaths(){
        int[] path=new int[10000];
        printPaths(root,path,0);
    }
    private void printPaths(Node node,int[] path, int pathLen){
        if(node==null){
            return;
        }
        path[pathLen]=node.data;
        pathLen++;
        if(node.left==null && node.right==null){
            printArray(path,pathLen);
        }else{
            printPaths(node.left,path,pathLen);
            printPaths(node.right,path,pathLen);
        }

    }
    private void printArray(int[] ints,int len){
        int i;
        for(i=0;i<len;i++){
            System.out.print(ints[i]+" ");
        }
        System.out.println();
    }

    public boolean sameTree(Tree other){
        return sameTree(root,other.root);
    }
    private boolean sameTree(Node a, Node b){
        if (a==null && b==null) {
            return true;
        }else{
            if(a!=null && b!=null){
                return(
                        a.data==b.data &&
                                sameTree(a.left,b.left) &&
                                sameTree(a.right,b.right)

                );
            }else{
                return false;
            }
        }
    }

    public boolean isBST(){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBST(Node node,int min,int max){
        if(node==null){
            return true;
        }else{
            boolean leftOk=isBST(node.left,min,node.data);
            if (!leftOk) {
                return false;
            }
            boolean rightOk=isBST(node.right,node.data+1,max);
            return rightOk;
        }
    }

    public static void main(String[]args){
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(10);
        tree.insert(13);
        tree.insert(9);
        tree.insert(4);
        tree.insert(3);
        tree.insert(9);
        tree.insert(14);
        tree.insert(61);
        tree.insert(14);
        tree.insert(99);




        //tree.printTree();

        //tree.printPaths();

        tree.BinaryTree();


        tree.insert(5);
        tree.insert(10);
        tree.insert(13);
        tree.insert(9);
        tree.insert(4);

        tree.insert(3);
        tree.insert(9);
        tree.insert(14);
        tree.insert(61);
        tree.insert(14);
        tree.insert(99);

        tree.printTree();

        tree.size();



    }
}
