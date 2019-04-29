

class Node1{
	
	Node1 left;
	Node1 right;
	int data;
	public Node1(int data) {
		left=null;
		right=null;
	}
}

public class HeapImplementation {
	
	static Node1 root;
	
	
	public void add(Node1 node,int data) {
		
		if(root==null)
		{
			root = new Node1(data);
		}
		
		else if(node.left==null&&node.right==null)
		{
			node.left=new Node1(data);
		}
		else if(node.right==null)
		{
			node.right= new Node1(data);
		}
		else
		{
			add(node,data);
		}
	}
	
}
