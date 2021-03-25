/**
 * This code illustrate  a family tree of my Ancestors to me.
 * This code contain two classes 1.DDList:Represent the doubly linked List 2.Node:represent the node/each ancestor.
 *
 * @param <T>  representation of java generics.
*  @author MAWUENA WISDOM ELI
 */

public class DDList<T> {
    private  node head;//head object of  Node class.
    private  node tail;//tail object of  Node class.
    private  int size;//size of the list.

    //constructor of the DDList
    DDList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public class node<T>{
        private T data ;
        private  node<T> next ;
        private node<T> previous;

        /**
         * Constructor of the Node class.
         * It also initiate the Node Class.
         * @param value represent the value to be assigned to data.
         */
        public node(T value){
            this.data = value;

        }

        /**
         * Constructor of the Node class.
         * It also initiate the Node Class.
         * @param value represent the value to be assigned to data.
         * @param   prev link to the previous node.
         * @param  nex link to the next node.
         */
        public node(T value,node prev,node nex){
            this.data = value;
            this.previous = prev;
            this.next = nex;

        }
    }

    /**
     * IsEmpty indicate whether the doubly linked list is empty or not.
     * @return a boolean Value that will signal if it is True or False.
     */
    public boolean isEmpty(){
        return size == 0;

    }

    /**
     * Length shows the number of nodes that are available in the system/ liked list.
     * @return the Size of the list.
     */
    public int length(){
        return size;
    }


    /**
     *Insert value to the front of the doubly linked list.
     * @param value the value to be inputted to the into the list.
     */
    public void insertInFront(T value){
        node newNode = new node(value); //creating new node
        if(isEmpty()){
            head = newNode;
        }else{
            head.previous = newNode;
            newNode.next=head;
            head = newNode;
            size++;


        }


    }
    /**
     * insertAtLast Inserts value at the end of the doubly linked list.
     * @param value the value to be inputted into the end of the list.
     */
    public void insertAtLast(T value){
        node  newNode = new node(value);//create a new node
        if(head ==null){
            head = newNode;
            size++;
        }else{
            node current  = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next=newNode;
            tail=newNode;

            size++;
        }

    }


    /**
     * This method insert value  after a specific existing value.
     * @param after The targeted value  through which the input is made.
     * @param value The value to be inputted before the target value.
     */
    public void insertAfter(T after,T value){
        node newNode = new node(value);//create a new node.
        node temp = head;

        while(temp.data!=after){
            temp = temp.next;
        }

        newNode.previous=temp;
        newNode.next=temp.next;
        temp.next=newNode;
        size++;


    }

    /**
     * This method delete node from the front.
     */
    public void deleteFront(){
        head = head.next;
        size--;
    }

    /**
     * This method delete node from the end.
     */
    public void deleteBack(){
        node current=head;
        while(current.next.next!=null){
            current=current.next;

        }
        current.next=null;

        size--;
    }

    /**
     * deleteParticularNode deletes a particular value which already exist in the list.
     * @param value representation of the value to be deleted.
     */
    public void deleteParticularNode(T value){

        node current = head;
        while(current.next.data!=value){
            current=current.next;
        }
        current.next=current.next.next;
    }

    /**
     * Shows the size of the list.
     */
    public void findSize(){
        System.out.println("The length of the list is "+size);
    }

    /**
     * Displays the content of the list.
     */
    public void displayFromFront(){
        if(isEmpty()){
            return;
        }else {
            node current = head;


            while(current!=null){
                System.out.println(current.data+"============>");
                current = current.next;
            }
            System.out.println("=======================================");
        }

    }


    public static void main(String[] args){
        //Creating an instance of the DDList class.
        DDList<String> list = new DDList<>();
        list.insertAtLast("Kings");
        list.insertAtLast("Kofi");
        list.insertAtLast("Kwame");
        list.insertAtLast("Yaw");
        list.insertAtLast("Koko");
        list.insertAtLast("Nana");
        list.insertAtLast("kwasi");

        // list.displayFromFront();
        // list.insertInFront("kiki");

        list.displayFromFront();
        list.insertAfter("Kings","Big");



        // list.displayFromFront();

        // list.deleteFront();
        //list.deleteBack();
        // list.deleteParticularNode("Kings");
        //list.findSize();
        list.displayFromFront();


    }
}
