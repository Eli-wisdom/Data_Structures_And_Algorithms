/**
 * This code illustrates how  Singly linked list works.
 * In this very code two classes are created.The Node and The SSingly Class.
 * One class to implement the node and the other to  implement the singly linked list.
 *
 * @author  MAWUENA WISDOM ELI
 *
 */
public class SSingly<T> {
    Node head;   //head of the list

    public class Node<T> {
        T data;
        Node<T> next;

        /**
         * The constructor of the Node class.
         * It also initiates the Node class.
         * @param d representing the data.
         */
        Node(T d) {

            data = d;
            next = null;
        }
    }



    /**
     * INSERTING NEW NODE @ the front.
     * @param new_data the node to be inserted.
     */
    public void push(T new_data){
        Node new_node = new Node(new_data); // new node to accept the new data
        new_node.next = head;
        head = new_node;

        System.out.println(new_data+" has been pushed");
    }



    /**
     * INSERTING NEW NODE @ the end of the List.
     * @param new_data value to be inserted.
     */
    public void append(T new_data){
        Node new_node = new Node(new_data); //Creating new Node.
        new_node.next = null;

        if(head == null){
            head = new_node;
        }
        else{
            Node node = head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new_node;
        }
        System.out.println(new_data+" has been appended");
    }


    /**
     * Inserts value after a particular index.
     * @param index  the Targeted index.
     * @param new_data value to be inputted.
     */
    public void insertAfter(int index, T new_data){
        Node new_node = new Node(new_data); //creating new node

        if(index == 0){
            push(new_data);
        }
        else{
            Node node = head;
            for(int i = 0; i< index - 1; i++){
                node = node.next;
            }
            new_node.next = node.next;
            node.next = new_node;
        }
        System.out.println(new_data+" has been inserted at index "+index);
    }



    /**
     * Delete node at an index.
     * @param index  Index of the node to be deleted.
     */
    public void deleteNode(int index){

        if(index == 0){
            head = head.next;
        }
        else{
            Node new_node = head;
            Node temp = null;
            for(int i = 0; i< index-1; i++){
                new_node = new_node.next;
            }
            temp = new_node.next;
            new_node.next = temp.next;
            System.out.println("The deleted value  is " + temp.data);
        }
    }

    /**
     * Print the content of the list.
     * @param list
     */
    public  void printList(SSingly list)
    {
        Node currentNode = list.head;

        System.out.print("LinkedList: ");

        while (currentNode != null) {

            System.out.print(currentNode.data + " ==> ");


            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args){
        //Creating an instance of the  SSingly class
        SSingly<String> list =  new SSingly<>();

        list.push("Kofi");
        list.append("Ama");
        list.append("king");
        list.append("Qween");
        list.append("Koko");
        list.append("Kwasi");
        list.printList(list);
        System.out.println("");
        list.push("Kwame");
        list.printList(list);
        System.out.println("");
        list.insertAfter(5,"KIki");
        list.printList(list);
        System.out.println("");
        list.insertAfter(3,"Holder");
        list.printList(list);
        System.out.println("");
        list.append("Vincent");
        list.printList(list);
        System.out.println("");
        list.deleteNode(2);
        list.printList(list);
        System.out.println("");
    }





}

