import java.util.Stack;

public class LinkedList {
	class Node{
		int data;
		Node nextNode;
		
		public Node(int data){	//Creates a new Node
			this.data = data;
			this.nextNode = null;
		}
		
	}

	Node headNode = null;

	public void insertNode(int data) {
		Node newNode = new Node(data);
		//Insert at beginning
		if(headNode == null) {	//List is empty
			headNode = newNode;
		}else {
			Node tempNode = headNode;
			while(tempNode.nextNode!= null) {
				tempNode = tempNode.nextNode;
			}
			tempNode.nextNode = newNode;
		}	
	}
	
	//Inserts node at a particular position
	public void insertNode(int data, int position) {
		 Node newNode = new Node(data);
		 Node currentNode = headNode;
		 Node previousNode = null;

		 if(position == 0) {
			newNode.nextNode = headNode;
			headNode = newNode;
			
		 }else {
			 int currentPosition = 0;
			 while(currentNode != null) {
				 if(currentPosition == position) {	//Found current node at desired position
					previousNode.nextNode = newNode;
					newNode.nextNode = currentNode;
					break;
				 }
				 
				 previousNode = currentNode; //Points to Previous Node
				 currentNode = currentNode.nextNode;
				 currentPosition++;
			 } 
		 }
	}
	
	public void deleteNode(int position) {
		if(position == 0) {		//Delete node at first position
			headNode = headNode.nextNode;
		}else {
			Node currentNode = headNode;
			Node previousNode = currentNode;
			int currentPositon = 0;
			
			while(currentNode != null) {
				
				if(currentPositon == position) {	//Current Node is at desiredPosition
					previousNode.nextNode = currentNode.nextNode;
				}
				
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
				currentPositon++;
			}
		}
	}
	
	public void printLinkedList() {
		if(headNode == null) { //List is empty
			System.out.println("The List is Empty. Nothing to traverse");
		}else { //List is not empty
			Node tempNode = headNode;
			
			while(tempNode!= null) {
				System.out.println("Data is : " + tempNode.data);
				tempNode = tempNode.nextNode;
			}
		}
	}
	
	public void reverseDisplayList(Node currentNode) {		//Using Recursion
		if(currentNode != null) {
			reverseDisplayList(currentNode.nextNode);
			System.out.println("Data is : " + currentNode.data);
		}
	}
	
	public void reverseLinkedList() {	//Using Stack
		Stack<Node> mStack = new Stack();
		Node tempNode = headNode;
		
		while(tempNode != null) {
			mStack.push(tempNode);
			tempNode = tempNode.nextNode;
		}
		
		headNode = mStack.pop();
		tempNode = headNode;
		
		while(!mStack.isEmpty()) {
			tempNode.nextNode = mStack.pop();
			tempNode = tempNode.nextNode;
		}
		
		tempNode.nextNode = null;
	}
	
	public static void main(String args[]) {
		System.out.println("Linked List Implemenetation");
		LinkedList mLinkedList = new LinkedList();
		
		//Linked List Operations
		mLinkedList.insertNode(1);
		mLinkedList.insertNode(2);
		mLinkedList.insertNode(3);
		mLinkedList.insertNode(4);
		mLinkedList.insertNode(200, 1);
		mLinkedList.insertNode(100, 0);
		mLinkedList.insertNode(600, 5);
		mLinkedList.printLinkedList();
		
		System.out.println("\nList after deleting first node");
		mLinkedList.deleteNode(0);
		mLinkedList.printLinkedList();
		
		System.out.println("\nList after deleting second node");
		mLinkedList.deleteNode(1);
		mLinkedList.printLinkedList();
		
		System.out.println("\nList after deleting last node");
		mLinkedList.deleteNode(4);
		mLinkedList.printLinkedList();
	
		/*
		 * System.out.println("\nReverse Diplay the List using Recursion");
		 * mLinkedList.reverseDisplayList(mLinkedList.headNode);
		 */
		System.out.println("\nReverse the List using Recursion");
		mLinkedList.reverseLinkedList();
		mLinkedList.printLinkedList();
		
		System.out.println("\nList after inserting an element");
		mLinkedList.insertNode(20);
		mLinkedList.printLinkedList();

	}
}
