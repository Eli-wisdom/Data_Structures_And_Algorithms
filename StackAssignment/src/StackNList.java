/**
 * Illustrating stack using  singly linked list.
 * This stack illustrate how disposable cups are stack together  one after the other from the top.
 * Dealing with the disposable cups,the last cup on the stack is the first cup to be removed.
 * Two classes are created  1.stackNList represent the stack 2.Node represent the Node/ a cup.
 *
 * @author MAWUENA WISDOM ELI
 */

public class StackNList<T> {

    // linked list node
    private class Node<T> {

        T data;

        Node<T> next;
        Node<T> tail;

        /**
         * The constructor of the Node Class which initiates the Node Class.
         *
         * @param data representation of data.
         */
        Node(T data) {
            this.data = data;
        }
    }

    Node<T> top;

    //Size of the stack
    private int capacity = 0;

    // StackNList Constructor
    StackNList() {
        this.top = null;
    }

    /**
     * Push method add a value/cup to the top of the stack.
     *
     * @param x representation of the data to be added.
     */
    public void push(T x) { // insert at the beginning

        // create new node temp
        Node temp = new Node(x);


        // initialize data into temp data field
        // temp.data = x;

        // put top reference into temp link
        temp.next = top;

        // update top reference
        top = temp;
        capacity++;

    }


    // Utility function to check if the stack is empty or not

    /**
     * Check if there is any cup /data in  the stack.
     *
     * @return a boolean value to indicate if empty or not.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Indicate the size of the stack.
     */
    public void size() {
        System.out.println();
        System.out.println("THE SIZE IS " + capacity);

    }

    /**
     * Utility function to return top element in a stack.
     */
    public void peek() {
        // check for empty stack
        if (!isEmpty()) {
            System.out.println(top.data + " ");
        } else {
            System.out.println("Stack is empty");

        }
    }

    /**
     * Utility function to deletes top node  in a stack.
     */
    public void pop() {
        // check for stack Downflow
        if (top == null) {
            System.out.print("\nStack Downflow");
            return;
        }

        //pointer to point to the next node
        top = (top).next;
        capacity--;
    }
    // This method display the content of the Stack

    /**
     * Displays the content of the stack
     */
    public void display() {
        // check for stack Downflow
        if (top == null) {
            System.out.printf("\n Stuck is empty");

        } else {
            Node temp = top;
            while (temp != null) {

                // print node data

                System.out.print(temp.data + " ==> ");

                // assign temp link to temp
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        // create instance of StackNList class
        StackNList<String> obj = new StackNList<>();
        // insert Stack value
        obj.push("Kofi");
        obj.push("Ama");
        obj.push("Abena");
        obj.push("Kwame");
        obj.push("Kwasi");
        obj.push("Solo");
        obj.push("Esi");
        obj.push("Humani");


        obj.display();
        obj.size();


        obj.peek();


        // Delete top element of Stack
        obj.pop();
        obj.pop();

        // print Stack elements
        obj.display();

        // print Top element of Stack
        obj.peek();
        obj.size();
    }


}

