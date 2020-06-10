import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

	class Node{
		int data;
		Node leftChild;
		Node rightChild;
		
		Node(int data){
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	

	public static Node rootNode = null;
	
	public Node insert(Node tempNode, int data) {
		if(tempNode == null) {
			tempNode = new Node(data);
			return tempNode;
		}else {
			if(data <= tempNode.data) {
				tempNode.leftChild = insert(tempNode.leftChild, data);
			}else {
				tempNode.rightChild = insert(tempNode.rightChild, data);
			}
			return tempNode;
		}
	}
	
	public void inorderTraversal(Node root) { 
        if (root != null) { 
        	inorderTraversal(root.leftChild); 
            System.out.println(root.data); 
            inorderTraversal(root.rightChild); 
        } 
    }
	
	public void preOrderTraversal(Node root) { 
        if (root != null) { 
            System.out.println(root.data); 
        	inorderTraversal(root.leftChild); 
            inorderTraversal(root.rightChild); 
        } 
    }
	
	public void postOrderTraversal(Node root) { 
        if (root != null) { 
        	inorderTraversal(root.leftChild); 
            inorderTraversal(root.rightChild); 
            System.out.println(root.data); 
        } 
    }
	
	public void search(Node tempNode, int dataToBeSearched) {
		if(tempNode == null) {
			System.out.println("Data Not Found");
			return;
		}else if(tempNode.data ==  dataToBeSearched) {
			System.out.println("Data Found");
			return;
		}else {
			if(dataToBeSearched <= tempNode.data) {
				search(tempNode.leftChild, dataToBeSearched);
			}else {
				search(tempNode.rightChild, dataToBeSearched);
			}
		}
	}
	
	public void returnMinimum(Node tempNode) {		//Returns the minimum value from BST i.e. LeftMost Child
		if(tempNode.leftChild == null) {
			System.out.println("The Minimum Value in BST is : " + tempNode.data);
			return;
		}else {
			returnMinimum(tempNode.leftChild);
		}
	}
	
	public void returnMaximum(Node tempNode) {		//Returns the maximum value from BST i.e. Rightmost Child
		if(tempNode.rightChild == null) {
			System.out.println("The Maximum Value in BST is : " + tempNode.data);
			return;
		}else {
			returnMinimum(tempNode.rightChild);
		}
	}
	
	public void levelOrderTraversal(Node tempNode) {
		Queue<Node> mQueue = new LinkedList<>();
		
		//First push the root node to the Queue
		mQueue.add(tempNode);
		
		while(!mQueue.isEmpty()) {
			Node currentFront = mQueue.remove();
			
			if(currentFront.leftChild != null)
				mQueue.add(currentFront.leftChild);
			if(currentFront.rightChild != null)
				mQueue.add(currentFront.rightChild);
			System.out.println("Inorder : " + currentFront.data);
		}
	}
	
	public static void main(String args[]) {
		BinarySearchTree mBinarySearchTree = new BinarySearchTree();
		
		//First Insertion
		rootNode = mBinarySearchTree.insert(rootNode, 10);
		
		//Insertions
		mBinarySearchTree.insert(rootNode, 8);
		mBinarySearchTree.insert(rootNode, 16);
		mBinarySearchTree.insert(rootNode, 5);
		mBinarySearchTree.insert(rootNode, 9);
		mBinarySearchTree.insert(rootNode, 17);
		mBinarySearchTree.insert(rootNode, 15);
		
		//Inorder Traversal
		mBinarySearchTree.inorderTraversal(rootNode);
		
		//Searching for an element
		mBinarySearchTree.search(rootNode, 10);
		
		//Find Smallest
		mBinarySearchTree.returnMinimum(rootNode.leftChild);
		
		//Find Smallest
		mBinarySearchTree.returnMaximum(rootNode.rightChild);
		
		//Level order Traversal or Breadth First Traversal
		mBinarySearchTree.levelOrderTraversal(rootNode);
	}
}

