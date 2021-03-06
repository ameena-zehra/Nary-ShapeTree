// Java program to traverse an N-ary tree
// without recursion
import java.util.ArrayList;
import java.util.Stack;
 
class GFG{
 
// Structure of a node of
// an n-ary tree
static class Node
{
    char key;
    ArrayList<Node> child;
 
    public Node(char key)
    {
        this.key = key;
        child = new ArrayList<>();
    }
};
 
// Function to traverse tree without recursion
static void traverse_tree(Node root)
{
     
    // Stack to store the nodes
    Stack<Node> nodes = new Stack<>();
 
    // push the current node onto the stack
    nodes.push(root);
 
    // Loop while the stack is not empty
    while (!nodes.isEmpty())
    {
         
        // Store the current node and pop
        // it from the stack
        Node curr = nodes.pop();
 
        // Current node has been travarsed
        if (curr != null)
        {
            System.out.print(curr.key + " ");
 
            // Store all the childrent of
            // current node from right to left.
            for(int i = curr.child.size() - 1; i >= 0; i--)
            {
                nodes.add(curr.child.get(i));
            }
        }
    }
}
 
// Driver code
public static void main(String[] args)
{
     
    /*   Let us create below tree
    *            A
    *        /  / \  \
    *       B  F   D  E
    *      / \     |  /|\
    *     K  J     G C H I
    *    / \         |   |
    *   N   M        O   L
    */
 
    Node root = new Node('A');
    (root.child).add(new Node('B'));
    (root.child).add(new Node('F'));
    (root.child).add(new Node('D'));
    (root.child).add(new Node('E'));
    (root.child.get(0).child).add(new Node('K'));
    (root.child.get(0).child).add(new Node('J'));
    (root.child.get(2).child).add(new Node('G'));
    (root.child.get(3).child).add(new Node('C'));
    (root.child.get(3).child).add(new Node('H'));
    (root.child.get(3).child).add(new Node('I'));
    (root.child.get(0).child.get(0).child).add(new Node('N'));
    (root.child.get(0).child.get(0).child).add(new Node('M'));
    (root.child.get(3).child.get(0).child).add(new Node('O'));
    (root.child.get(3).child.get(2).child).add(new Node('L'));
 
    traverse_tree(root);
}
}
 
// This code is contributed by sanjeev2552