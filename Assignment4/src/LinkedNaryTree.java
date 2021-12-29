import java.util.Iterator;

public class LinkedNaryTree<T> {
	
	private NaryTreeNode<T> root;
	
	/**
	* Constructor
	* For cases where the root is not given for the LinkedNaryTree
	* Sets the root equal to null
	*/
	public LinkedNaryTree() {
		root = null;
	}
	
	/**
	* Constructor
	* For cases where the root is given for the LinkedNaryTree
	* Sets the root equal to the given input
	* @param NaryTreeNode<T> input that is equated to root 
	*/
	public LinkedNaryTree(NaryTreeNode<T> input) {
		root = input;
	}
	
	/**
	* Public Setter Method
	* Takes in two parameter of type NaryTreeNode which represents the parent and the child node to add
	* Calls the addChild() method on the parent node to add the child node to it
	* @param NaryTreeNode<T> parent node to add onto
	* @param NaryTreeNode<T> child node to be added
	*/
	public void addNode(NaryTreeNode<T> parent, NaryTreeNode<T> child) {
		parent.addChild(child);
	}
	
	/**
	* Public Getter Method
	* @return returns the NaryTreeNode<T> root of a LinkedNaryTree<T>
	*/
	public NaryTreeNode<T> getRoot(){
		return root;
	}
	
	/**
	* Public Getter Method
	* @return returns the T data stored at the root node
	*/
	public T getRootElement() {
		return root.getData();
	}
	
	/**
	* Public Boolean Method
	* @return returns a boolean value representing if the LinkedNaryTree is empty or not
	*/
	public boolean isEmpty(){
		return (root==null);
	}
	
	/**
	* Public Recursive Size Method
	* Takes in a NaryTreeNode<T> parameter and calculates the number of elements in the tree from that parameter node
	* Performs a preorder traversal of the tree using recursion and adding each element to the list as nodes are visited
	* @param NaryTreeNode<T> node used to calculate the size of the LinkedNaryTree
	* @return returns the int size of the LinkedNaryTree
	*/
	public int size(NaryTreeNode<T> node) {
		if (node==null) {
			return +1;
		}
		if (node.getNumChildren()==0) {
			return +1;
		}
		int sizetracker = 0;
		for (int i=0; i<node.getNumChildren(); i++) {
			sizetracker+= size(node.getChild(i));
		}
		return +sizetracker+1;
	}
	
	
	
	/**
	* Public Recursive Preorder Traversal Method
	* Takes in a NaryTreeNode<T> parameter and an ArrayUnorderedList<T> parameter
	* Performs a preorder traversal of the tree using recursion
	* Adds elements to the list as nodes are visited
	* @param NaryTreeNode<T> node used in the traversal
	* @param ArrayUnorderedList<T> list used as a record of nodes in the traversal
	*/
	public void preorder (NaryTreeNode<T> node, ArrayUnorderedList<T> templist) {
		if (node==null) {
			return;
		}
		if (node.getNumChildren()==0) {
			templist.addToRear(node.getData());
			return;
		}
		templist.addToRear(node.getData());
		
		for (int k=0; k<node.getNumChildren();k++) {
    		preorder(node.getChild(k), templist);
    	}
	}
	
	
	/**
	* Public iteratorPreorder() Method
	* Initializes an ArrayUnorderedList<T> list
	* Calls the preorder method with the root node and the list
	* @return returns an iterator of the LinkedNaryList
	*/
	public Iterator<T> iteratorPreorder() {
		ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
		preorder(root, templist);
		Iterator<T> iter = templist.iterator();
		return iter;
	}
	
	/**
	* Public toString Method
	* Returns a string of each of the preorder elements using the iterator method
	* If the tree is empty "Tree is empty" is instead returned
	* @return returns a String representation of each of the preorder elements
	*/
	public String toString() {
		Iterator<T> iter = iteratorPreorder();
		if (iter.hasNext()==false){
			return "Tree is empty.";
		}
		String s1 ="";
		while (iter.hasNext()==true) {
			s1 += iter.next().toString();
			s1 +="\n";
		}
		return s1;
	}

}
