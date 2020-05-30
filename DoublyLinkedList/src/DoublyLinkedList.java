public class DoublyLinkedList {
	
	 class Node {
		int data;
		Node nextNode;
		Node previousNode;
		
		Node(int data){
			this.data = data;
			this.nextNode = null;
			this.previousNode = null;
		}
	 }
	
	 int listSize = 0;
	Node headNode = null;
	
	public void insertNode(int data) {
		Node newNode = new Node(data);
		
		if(headNode == null) {
			//List is empty
			headNode = newNode;
		}else {
			//List is not empty. Insert at last.
			Node currentNode = headNode; 
			
			//Traverse to last node
			while(currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
			 }
			
			//We are at last node. Adjust links
			currentNode.nextNode = newNode;
			newNode.previousNode = currentNode;
		}
	}
	
	public void insertNode(int data, int position) {
		Node newNode = new Node(data);
		Node currentNode = headNode;
		Node previousNode = null;
		int currentPosition = 0;
		
		if(position == 0) {
			     newNode.nextNode = headNode;
			     headNode.previousNode = newNode;
			     headNode = newNode;
		}else {
			while(currentNode.nextNode != null) {
				if(currentPosition == position) {
					previousNode.nextNode = newNode;
					newNode.previousNode = previousNode;
					newNode.nextNode = currentNode;
					currentNode.previousNode = newNode;
					break;
				}
				currentPosition++;
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
			}
		}
	}
	
	public void printDoublyLinkedList() { //Prints Straight
		Node tempNode = headNode;
		if(tempNode == null) {
			System.out.println("List is empty. Cannot traverse.");
		}else {
			while(tempNode != null) {
				System.out.println("Data is : " + tempNode.data);
				tempNode = tempNode.nextNode;
			}
		}
	}
	
	public void printDoublyLinkedListReverseOrder() { //Prints Straight
		Node tempNode = headNode;
		if(tempNode == null) {
			System.out.println("List is empty. Cannot traverse.");
		}else {
			//Traverse till the last node
			while(tempNode.nextNode != null) {
				//System.out.println("Data is : " + tempNode.data);
				tempNode = tempNode.nextNode;
			}
			
			//We are at last node now.
			while(tempNode != null) {
				System.out.println("Data is : " + tempNode.data);
	
				tempNode = tempNode.previousNode;
			}
		}
	}
	
	public int getListSize() {
		if(headNode == null) {
			return 0;
		}else {
			listSize = 0;
			Node tempNode = headNode;
			while(tempNode != null) {
				listSize ++;
				tempNode = tempNode.nextNode;
			}
		}
		
		return listSize;
	}
	
	public void deleteNodeAt(int position) {
		Node currentNode = headNode;
		Node previousNode = null;
		Node nextNode = null;
		int currentPosition = 0;
		
		if(position == 0) {
			headNode = headNode.nextNode;
			headNode.previousNode = null;
			
			//We had set currentNode to Head Node above. We can delete it now
			currentNode.nextNode = null;
			currentNode.previousNode = null;
		}else if(position == getListSize() - 1) {
			
			//Reach the node to be deleted
			while(currentNode.nextNode != null) {
				if(currentPosition == position) {
					break;
				}
				currentPosition++;
				currentNode = currentNode.nextNode;
			}
			
			//Adjust links
			previousNode = currentNode.previousNode;
			previousNode.nextNode = null;
			
			//Delete current node
			currentNode.nextNode = null;
			currentNode.previousNode = null;
			currentNode = null;
			
		}else {
			//Reach the node to be deleted
			while(currentNode.nextNode != null) {
				if(currentPosition == position) {
					break;
				}
				currentPosition++;
				currentNode = currentNode.nextNode;
			}
			
			//We are at the node to be deleted, set previous node and next node
			previousNode = currentNode.previousNode;
			nextNode = currentNode.nextNode;
			
			//Delete the current node.
			currentNode.nextNode = null;
			currentNode.previousNode = null;
			
			//Adjust the links
			previousNode.nextNode = nextNode;
			nextNode.previousNode = previousNode;
		}	
	}
	
	
	public static void main(String args[]) {
		System.out.println("Doubly Linked List Operations");
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		
		//Add first Node
		doublyLinkedList.insertNode(0);
		
		//Add nodes to last
		doublyLinkedList.insertNode(1);
		doublyLinkedList.insertNode(2);
		doublyLinkedList.insertNode(3);
		
		//Add node at 2nd Position
		doublyLinkedList.insertNode(100, 1);
		
		//Add node at 0th Position
		doublyLinkedList.insertNode(150, 0);
		doublyLinkedList.insertNode(300);
	
		//Delete the node at 2nd Position
		System.out.println("Deleting the node at second position");
		doublyLinkedList.deleteNodeAt(1);

		//Delete the node at 0th Position
		System.out.println("Deleting the node at first position");
		doublyLinkedList.deleteNodeAt(0);
		
		
		System.out.println("List Size");
		System.out.println("" + doublyLinkedList.getListSize());
		 
		//Print the List (Straight)
		System.out.println("The contents of List are (Traversing Straight) before deletion");
		doublyLinkedList.printDoublyLinkedList();
				
		// Delete the node at last position
		 System.out.println("Deleting the node at last position");
		 doublyLinkedList.deleteNodeAt(4);
		 
				
		//Print the List (Straight)
		System.out.println("The contents of List are (Traversing Straight)");
		doublyLinkedList.printDoublyLinkedList();
		
		//Print the List (Reverse using Previous link)
		System.out.println("The contents of List are (Traversing Reverse)");
		doublyLinkedList.printDoublyLinkedListReverseOrder();
	}
}
