package dllClasses;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void push(Node newNode) {
        if(head == null) {
           head = newNode;
            tail = newNode;
            return;
        }
        
        Node lastNode = tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        tail = newNode;
    }
    
    public void printValuesForward() {
        Node current = this.head;
        
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
    	Node current = tail;
    	
    	while(current != null) {
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
    
    public Node pop(){
    	Node popped = tail;
    	popped.previous.next = null;
    	tail = popped.previous;
    	return popped;
    }
    
    public boolean contains(Integer value) {
    	Node current = head;
    	while(current != null) {
    		if(current.value == value) {
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
    }
    
    public int size() {
    	Node current = head;
    	int counter = 0;
    	while(current != null) {
    		counter ++;
    		current = current.next;
    	}
    	return counter;
    }
}