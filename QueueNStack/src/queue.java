

/**
 * This code illustrate how cars in KFC drive thru are line up with the function First in First out.
 * Two classes are created  1.queue represent the Queue 2.Node represent a Node/ Car.
 * @author MAWUENA WISDOM ELI.
 */
public class queue<T> {

    private Node front; // front object of the Node class
    private Node rear;  // rear object of the Node class
    int capacity =0;

    public class Node<T>{
        private T data;
        private Node<T> next;

        /**
         * The constructor of the Node Class which initiates the Node Class.
         * @param data representation of data.
         */
        Node(T data){
            this.data=data;

        }

    }
    //constructor of the queue class
    queue(){
        front =null;
        rear = null;
    }

    /**
     *Checks if the list is empty or not.
     * @return a boolean to indicate if the that statement is true or not.
     */
    public boolean isEmpty(){

        return( capacity==0);
    }

    /**
     * enqueue method add new value/car to the queue /KFC drive thru.
     * It adds new items at the rear/ tail of the queue.
     * @param value
     */
    public void  enqueue(T value){

        Node oldNode = rear;
        Node newNode = new Node(value); //creating a new node
        rear = newNode;
        newNode.next=null;

        if(isEmpty()){
            front=rear;
            System.out.print(rear.data+ " ");
        }else{
            oldNode.next=rear;
            System.out.print("<== "+rear.data+ " ");
        }
        capacity++;


    }

    /**
     * This method removes a data from the queue
     * It removes the car in front of the queue
     */

    public void dequeue(){


        Node newNode =  front;
        if(isEmpty()){
            rear=null;
        }else{
            front=front.next;

            System.out.println();
            System.out.println(newNode.data+" is removed");
            capacity--;
        }

    }

    /**
     * This Method Displays the size of the Queue.
     * It indicate the number of cars in the KFC drive thru.
     */
    public void size(){
        System.out.println();
        System.out.println("THE SIZE OF THE QUEUE IS "+capacity);
    }

    /**
     * It shows the contents or the cars in the queue.
     */
    public void display() {
        //Node current will point to front
        Node current = front;

        if(front == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.print("<====="+current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        queue<String> qu = new queue<>();
        qu.enqueue("King");
        qu.enqueue("Qween");
        qu.enqueue("Mother");
        qu.enqueue("Home");
        qu.enqueue("Bust");
        qu.enqueue("kofi");
        qu.dequeue();
        qu.enqueue("Abena");
        qu.enqueue("Kwasi");

        qu.size();

        qu.display();
    }


}


