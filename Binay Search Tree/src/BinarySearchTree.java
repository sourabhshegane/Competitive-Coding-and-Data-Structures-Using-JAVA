
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
			if(data < rootNode.data) {
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
	
	public static void main(String args[]) {
		BinarySearchTree mBinarySearchTree = new BinarySearchTree();
		rootNode = mBinarySearchTree.insert(rootNode, 100);
		mBinarySearchTree.insert(rootNode, 10);
		mBinarySearchTree.insert(rootNode, 400);
		mBinarySearchTree.insert(rootNode, 0);
		mBinarySearchTree.inorderTraversal(rootNode);
		mBinarySearchTree.search(rootNode, 10);
	}
}

