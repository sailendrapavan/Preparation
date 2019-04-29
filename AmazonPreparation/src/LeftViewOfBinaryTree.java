import java.util.HashSet;

class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 

public class LeftViewOfBinaryTree {

    Node root; 
    HashSet<Integer> hash = new HashSet<Integer>();
    
    public void viewTree(Node root,int count) {
    	
    	if(root==null)
    	{
    		return;
    	}
    	viewTree(root.left,count+1);
    	if(!hash.contains(count)) {
        	System.out.println(root.data+"level is"+count);
        	hash.add(count);
    	}
    	viewTree(root.right,count+1);
    	
    	
    }

	public static void main(String args[]) {
		
		
		LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree(); 
        tree.root = new Node(12); 
        tree.root.left = new Node(10); 
        tree.root.left.left= new Node(2);
        tree.root.right = new Node(30); 
        tree.root.right.left = new Node(25); 
        tree.root.right.right = new Node(40); 
        
        tree.viewTree(tree.root,0);
		}
	
	

}
