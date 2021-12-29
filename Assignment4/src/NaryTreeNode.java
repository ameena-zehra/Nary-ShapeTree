
public class NaryTreeNode<T> {
	
	private T data;
	private int numChildren;
	private NaryTreeNode<T> [] children;
	
	/**
	* Constructor
	* Takes in a parameter  of type T and sets that as the data variable
	* The children variable is set to null
	* @param T givendata is set to the data held in the node
	*/
	public NaryTreeNode(T givendata) {
		data = givendata;
		children = null;
	}
	
	/**
	* Public Setter Method
	* Takes in a parameter of type NaryTreeNode which represents a child node to add
	* If children is null then it is initialized with 3 slots
	* If the children array is full then the helper function expandCapacity() is called
	* The parameter nodetoadd is added to the next available slot
	* The variable numChildren is incremented
	* @param NaryTreeNode<T> nodetoadd
	*/
	public void addChild(NaryTreeNode<T> nodetoadd) {
		if (children==null) {
			children = new NaryTreeNode[3];
		}
		else if (numChildren == children.length) {
			expandCapacity();
		}
		children[numChildren] = nodetoadd;
		numChildren++;
	}
	
	/**
	* Public Helper Method
	* Expand the capacity of children by adding 3 more spaces to the length
	* Called by addChild when the capacity of the array has been maxed out
	*/
	public void expandCapacity() {
		NaryTreeNode<T> [] larger = new NaryTreeNode[children.length+3];
		for (int i=0; i<children.length; i++) {
			larger[i]= children[i];
		}
		children = larger;
	}
	
	
	/**
	* Public Getter Method
	* @return returns integer number of children attached to one NaryTreeNode
	*/
	public int getNumChildren() {
		return  numChildren;
	}
	
	/**
	* Public Getter Method
	* Provides the child of a node at a specific index
	* @param specific index
	* @return returns the NaryTreeNod<T> child at a given index 
	*/
	public NaryTreeNode<T> getChild(int index) {
		return children[index];
	}
	
	/**
	* Public Getter Method
	* @return returns the T data stored in a node
	*/
	public T getData() {
		return data;
	}
	
	/**
	* Public toString Method
	* @return returns a String representation of the data stored in a node
	*/
	public String toString() {
		String s1 = "Node containing " + data;
		return s1;
	}

}
