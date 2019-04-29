import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ParentChildGrandParentProblem {

	Node root;
	int max=0;
	class Node {

		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	void printallnodes(Node root) {

		if (root == null) {
			return;
		} else {
			System.out.println(root.data);
			printallnodes(root.left);

			printallnodes(root.right);
		}
	}

	List<Node> copyAllNodesIntoArray(Node root) {

		List<Node> l = new ArrayList<Node>();
		l.add(root);
		int i = 0;
		while (i < l.size()) {
			if (l.get(i).left != null)
				l.add(l.get(i).left);
			if (l.get(i).right != null)
				l.add(l.get(i).right);
			i++;
		}
		return l;

	}

	Node constructBinaryTree(List<Integer> l, int i, Node root) {

		if (i < l.size()) {
			root = new Node(l.get(i));
			root.left = constructBinaryTree(l, 2 * i + 1, root.left);
			root.right = constructBinaryTree(l, 2 * i + 2, root.right);
		}
		return root;

	}

	int parentGrandParentChild(Node root, List<Integer> s) {
		
		int sum=0;
		if (root == null) {
			
			return 0;
			
		}
		s.add(root.data);
		if (s.size() >= 3) {
			sum=s.get(s.size()-1)+s.get(s.size()-2)+s.get(s.size()-3);
			if(sum>max) {
				max=sum;
			}
		}
		
		parentGrandParentChild(root.left, s);
		parentGrandParentChild(root.right, s);
		s.remove(s.size()-1);
		return max;
	}


	int sumOfChilds(Node root) {
		int temp = 0;
		if (root == null) {

			return 0;
		} else {
			temp = root.data;
			root.data = sumOfChilds(root.left) + sumOfChilds(root.right);

		}
		return root.data + temp;
	}

	public static void main(String args[]) {

		ParentChildGrandParentProblem a = new ParentChildGrandParentProblem();
		Node root=a.constructBinaryTree(new ArrayList<Integer>(Arrays.asList(8, 10, 11, 12, 15,21,4,9)), 0, a.root);
		System.out.println(a.parentGrandParentChild(root, new ArrayList<Integer>()));
//		List<Node> li = a.copyAllNodesIntoArray(
//				a.constructBinaryTree(new ArrayList<Integer>(Arrays.asList(8, 10, 11, 12, 15)), 0, a.root));

	}
}
