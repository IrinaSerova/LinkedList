package singleLinkedListProject;



/*** 1 REQUIREMENT ***/
// Call Class MySinglyLinkedList
public class MySinglyLinkedList<E>{
	Node head; // Head is the first node in linked list
	//*** 2 and 3 REQUIREMENT ***//
	// Create Inner class Node
	// Use generic type for the list
	class Node {  //*** 4 REQUIREMENT ***//  constructor for Node with no input
		E data;
		Node next;
		public Node(E  new_data){
			data =  new_data;
			next = null;
		}
		public Node(E  new_data, int index) { //*** 5 REQUIREMENT ***// constructor for Node with 2 input
			Node current = head;
			int counter = 1;
			while(counter-1 != index) {
				current = current.next;
			}
			data =  new_data;
			this.next = current.next;
			current.next = this;
		}
	}

	public int getSize()
	{
		Node temp = head;
		int count = 0;
		while (temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
	//*** 6 REQUIREMENT ***// Implement method addFirst(E item)
	public void addFirst(E new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head; 	// Make next of new Node as head 
		head = new_node; // Move the head to point to new Node
	}
	// This function prints contents of linked list starting from the given node
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current= current.next;
		}
	
	}


	//*** 7 REQUIREMENT ***// Implement method addLast(E item)
	public void addLast(E new_data) {
		Node new_node = new Node(new_data);	// Allocate the Node & Put in the data Set next as null 
		if (head == null) {  // If the Linked List is empty, then make the new node as head 	    
			head = new Node(new_data);
			return;
		}	 
		new_node.next = null; //This new node is going to be the last node, so make next of it as null 	 
		Node last = head; // Else traverse till the last node 
		while (last.next != null) {
			last = last.next;	 	    // Change the next of last node 
			last.next = new_node;
			return;
		}
	}
	public void add(Node prev_node, E new_data) {   
		if (prev_node == null) {  // Check if the given Node is null       

			return;
		}   
		Node new_node = new Node(new_data);      // Allocate the Node & Put in the data
		new_node.next = prev_node.next;     //  Make next of new Node as next of prev_node      
		prev_node.next = new_node;   // make next of prev_node as new_node 
	}
	//*** 8 REQUIREMENT ***// Implement method add(E item, int index)

	public void addNode(int index, E new_data) {
		if (index == 0) {
			addFirst(new_data);
		}
		else if (index >= getSize()) {
			addLast(new_data);
		}
		else {
			Node current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node temp = current.next;
			current.next = new Node(new_data);
			(current.next).next = temp;
			index++;
		}
	}


	//*** 9 REQUIREMENT ***// Implement method removeFirst()
	public void removeFirst() {
		if (head == null) 	        // If linked list is empty
			return;
		Node temp = head;   // Store head node 
		head = temp.next;
		if (head == temp.next.next) {  // If head needs to be removed	      
			head = null;   // Change head
			return;
		}	 
	}

	//*** 10 REQUIREMENT ***// Implement method removeLast()
	public void removeLast() {
		if (head == null) 	        // If linked list is empty
			return;
		Node last = head;   // Store head node 
		while (last.next != null) {
			last = last.next;	 	    // Change the next of last node 
			last.next = null;
			return;
		}
	}

	//*** 11 REQUIREMENT ***// Implement method remove(int index)

	public void deleteNodeIndex(int index){
		if (head == null) 	        // If linked list is empty
			return;
		Node temp = head;   // Store head node     
		if (index == 0) {  // If head needs to be removed	      
			head = temp.next;   // Change head
			return;
		}	 	
		for (int i=0; temp!=null && i<index-1; i++)         // Find previous node of the node to be deleted
			temp = temp.next; 
		if (temp == null || temp.next == null)
			return;
		Node next = temp.next.next; 	        // Store pointer to the next of node to be deleted	 
		temp.next = next;  // Unlink the deleted node from list
	}
	//*** 12 REQUIREMENT ***// change(E item, int index)
	public void replace(int index, E new_data) {
		deleteNodeIndex(index);	
		addNode(index++, new_data);		
	}

	public void deleteNode(E key) {	       
		Node temp = head, prev = null;  // Store head node 
		if (temp != null && temp.data == key)  {	        // If head node itself holds the key to be deleted
			head = temp.next; // Changed head
			return;
		} 
		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}     
		// If key was not present in linked list
		if (temp == null) return;	 
		// Unlink the node from linked list
		prev.next = temp.next;
	}


	public static void main(String[] args) {
		/* Start with the empty list */
		MySinglyLinkedList<String> llist = new MySinglyLinkedList<String>();
		// Insert "First"  So linked list becomes First->NUllist
		llist.addFirst("First");	
		// Insert "Second" at the beginning. So linked list becomes
		// Second->First->NUllist
		llist.addFirst("Second");	
		
		// Insert "Third" at the beginning. So linked list becomes
		// Third->Second->First->Forth->NUllist		
		llist.addFirst("Third");			
		System.out.println("\nCreated Linked list with implementation of method addFirst is: ");
		llist.printList();
		llist.removeLast();
		System.out.println("\nCreated Linked list with implementation of method remove Last is: ");
		llist.printList();
		System.out.println("\nCreated Linked list with implementation of method addLast  is: ");
		llist.addLast("Forth");	
		llist.printList();
		llist.add(llist.head.next, "Fifth");
		System.out.println("\nCreated Linked list with implementation of method add after   is: ");
		llist.printList();
		llist.deleteNode("Fifth"); // Delete node Fifth
		System.out.println("\nLinked List after Deletion Fifth:");
		llist.printList();
		llist.addNode(1, "NewNode");
		System.out.println("\n Created Linked list with implementation of method method add(E item, int index) is: ");
		llist.printList();
		System.out.println("\n Created Linked list with implementation of method change(E item, int index) is: ");
		llist.replace(1, "Replace");
		llist.printList();
		System.out.println("\n Created Linked list with implementation of method remove(int index): ");
		llist.deleteNodeIndex(1);
		llist.printList();
		System.out.println("\n Created Linked list with implementation of method remove First: ");
		llist.removeFirst();
		llist.printList();
		System.out.println("\nThe size of Linked List is: " + llist.getSize());
	}
	
}




