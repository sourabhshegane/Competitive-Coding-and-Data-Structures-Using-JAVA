
public class Queue {

	class Node{
		int data;
		Node nextNode;
		
		public Node(int data) {
			this.data = data;
			this.nextNode = null;
		}
	}
	
	Node front;	//Front of the Queue
	Node rear;	//Rear of the Queue
	
	public void enqueue(int data) {		//Push onto queue
		Node newNode = new Node(data);
		
		if(rear == null && front == null) {
			//Queue is Empty
			front = newNode;
			rear = newNode;
		}else {
			//Queue is not empty. Insert new node towards rear
			rear.nextNode = newNode;
			rear = newNode;
		}
	}
	
	public void dequeue() {
		Node currentFrontNode = front;
		
		if(front == rear)  //If Front and Rear are at same position
			front = rear = null;
		else 
			front = front.nextNode;	
		
		//delete previous front i.e. currentFrontNode
		currentFrontNode.nextNode = null;
	}
	
	public void printQueue() {	//Prints the queue from front to rear
		if(front == null) {
			System.out.println("Queue is empty. Cannot traverse");
		}else {
			Node tempNode = front;
			
			while(tempNode != null) {
				System.out.println("Data is : " + tempNode.data);
				tempNode = tempNode.nextNode;
			}
		}
	}
	
	public void getFront() {
		if(front == null)
			System.out.println("Queue is empty. Cannot get Front of the Queue");
		else 
			System.out.println("The value at front of the Queue is : " + front.data);
	}
	
	public void getRear() {
		if(front == null)
			System.out.println("Queue is empty. Cannot get Rear of the Queue");
		else 
			System.out.println("The value at rear of the Queue is : " + rear.data);
	}
	
	public static void main(String args[]) {
		Queue mQueue = new Queue();
		
		mQueue.enqueue(0);
		mQueue.enqueue(1);

		//Print the Queue
		mQueue.printQueue();
		mQueue.getRear();
		
		//Dequeue
		mQueue.dequeue();
		mQueue.dequeue();

		System.out.println("Queue after Deleting");
		mQueue.printQueue();
		
		mQueue.enqueue(25);
		mQueue.printQueue();
		mQueue.getFront();
		mQueue.dequeue();
		
		System.out.println("Queue after deleting");
		mQueue.printQueue();
		
		mQueue.getFront();
		mQueue.getRear();
	}
}
