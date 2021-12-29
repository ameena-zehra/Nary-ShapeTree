
public class ShapeTree {
	private LinkedNaryTree<Shape> tree;
	
	/**
	* Public Getter Method
	* @return returns the LinkedNaryTree<Shape> tree
	*/
	public LinkedNaryTree<Shape> getTree(){
		return tree;
	}
	
	/**
	* Public Getter Method
	* @return returns the NaryTreeNode<T> root of a LinkedNaryTree<T>
	*/
	public NaryTreeNode<Shape> getRoot() {
		return tree.getRoot();
	}
	
	/**
	* Public addShapeNode() Method
	* Takes in Shape parameter
	* Creates a new NaryTreeNode<Shape> containing the shape parameter
	* If the tree is empty the new node is set as the root
	* Otherwise the addShapeNodeHelper method is called
	* If this does not return null then the previous shape node is set as the parent of the shapeNode
	* @param Shape shape parameter that is to be added
	*/
	public void addShapeNode(Shape shape) {
		NaryTreeNode<Shape> shapeNode = new NaryTreeNode<Shape>(shape);
		if (tree==null) {
			tree = new LinkedNaryTree<Shape>(shapeNode);
		}
		NaryTreeNode<Shape> parentshapeNode = addShapeNodeHelper(shape);
		if (parentshapeNode!=null) {
			parentshapeNode.addChild(shapeNode);
		}
	}
	
	/**
	* Public addShapeNodeHelper() Method
	* Takes in Shape parameter
	* Performs a stack-based preorder traversal of the tree
	* Once the elements are pushed on they are popped off where the checkNode function is used to determine a suitable parent
	* @param Shape shape parameter that is to be added
	* @return returns either the suitable parentshapeNode or null if none are found
	*/
	public NaryTreeNode<Shape> addShapeNodeHelper(Shape shape) {
		// STEP 1: Create a stack
		ArrayStack<NaryTreeNode> stack = new ArrayStack<NaryTreeNode>();
		// STEP 2: Push the root of the tree onto the stack
		stack.push(tree.getRoot());
		while(!(stack.isEmpty())) {
			// STEP 3: Pop off a nodes in the stack
			NaryTreeNode<Shape> current = stack.pop();
			// STEP 4: Determine if checkNode is true
			if (checkNode(current, shape )==true) {
				return current;
			}
			if (current.getNumChildren()==0) {
				if (checkNode(current, shape )==true) {
					return current;
				}
			} 
			else {
				// STEP 5: All of the children of a node are assessed
				for (int i= current.getNumChildren()-1;i>=0;i--){
					NaryTreeNode<Shape> child = current.getChild(i);
					stack.push(child);
					}
			}
		}
		return null;
	}
	
	/**
	* Public boolean checkNode() Method
	* Takes in a NaryTreeNode<Shape> parameter and a Shape parameter
	* Ensures the first 3 rules of the ShapeTree are followed 
	* @param NaryTreeNode<Shape> node acts as parent node
	* @param Shape shape acts as the childNode
	* @return returns a boolean indicating whether or node the 3 rules have been violated
	*/
	public boolean checkNode(NaryTreeNode<Shape> node, Shape shape) {
		boolean checkpoint= true;
		// RULE 1: 
		// a node can have to X children--> x = number of lines in the node's contained shape
		int Xlimit = node.getData().getNumSides();
		if (node.getNumChildren()>=Xlimit) {
			checkpoint = false;
		}
		// RULE 2: 
		// a node cannot have a child whose shape is the same color as the node's shape
		if (node.getData().getColour().equals(shape.getColour())) {
			checkpoint = false;
		}
		// RULE 3: 
		// a node cannot have a sibling node that contains shapes of the same colour
		for (int i =0; i<node.getNumChildren(); i++) {
			Shape child = (Shape) node.getChild(i).getData();
			if (child.getColour().equals(shape.getColour())){
				checkpoint= false;
			}
		}
		return checkpoint;
	}
	
	/**
	* Public toString Method
	* Returns the same string as the variable tree's toString()
	* @return returns a String representation of the tree
	*/
	public String toString() {
		return tree.toString();
	}

}
