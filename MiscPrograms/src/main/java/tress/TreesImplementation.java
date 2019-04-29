package tress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node
{
	int data;
	Node left,right;
	public Node(int data)
	{
		this.data=data;
		left=right=null;
	}
	
}

class QItem {
	Node node;
    int hd;
    public QItem(Node n, int h)
    {
        node = n;
        hd = h;
    }
}

public class TreesImplementation {
	static  int  maxlevel=0;
    Node root;
   
    
    void printVerticalOrderOfTree(Node temp) {
    	
    	Queue<QItem> que = new LinkedList<QItem>();
    	HashSet<QItem> set = new HashSet<QItem>();
    	que.add(new QItem(root, 0));
    	
    	while(!que.isEmpty()) {
    		
    		QItem qtemp = que.remove();
    		Node ntemp= qtemp.node;
    		int hd=qtemp.hd;
    		
    		set.add(qtemp);
    		
    		
    		if(ntemp.left!=null)
    		{
    			que.add(new QItem(ntemp.left, hd-1));
    		}
    		
    		if(ntemp.right!=null)
    		{
    			que.add(new QItem(ntemp.right, hd+1));
    		}
    	}
    	
    	
    }
    
    void printVerticalOrderUsingRcurrsion(Node temp,int distance,Map<Integer, ArrayList<Node>> m) {
    	
    	if(temp==null)
    	{
    		return;
    	}
    	ArrayList<Node> getArrayList =m.get(distance);
    	if(getArrayList==null) {
    		getArrayList = new ArrayList<Node>();
    		getArrayList.add(temp);
    	}
    	else
    		getArrayList.add(temp);
    	m.put(distance, getArrayList);
    	printVerticalOrderUsingRcurrsion(temp.left,distance-1,m);
    	printVerticalOrderUsingRcurrsion(temp.right,distance+1,m);
    	
    }
    
    void InorderOfTree()
    {
    	
    	if(root==null)
    	{
    		return;
    	}
    	Stack<Node> st = new Stack<Node>();
    	
    	Node curr = root;
    	while(curr!=null||!st.isEmpty())
    	{
    		while(curr!=null)
    		{
    			st.push(curr);
    			curr=curr.left;
    		}
    		curr=st.pop();
    		System.out.println(curr.data);
    		curr=curr.right;
    	}
    	
    }
    void PreorderOfTree()
    {
    	
    	if(root==null)
    	{
    		return;
    	}
    	Stack<Node> st = new Stack<Node>();
    	
    	Node curr = root;
    	while(curr!=null||!st.isEmpty())
    	{
    		while(curr!=null)
    		{
    			System.out.println(curr.data);
    			st.push(curr);
    			curr=curr.left;
    		}
    		curr=st.pop();
    		curr=curr.right;
    	}
    	
    }
    
    void PostrderOfTree()
    {
    	
    	if(root==null)
    	{
    		return;
    	}
    	Stack<Node> st = new Stack<Node>();
    	
    	Node curr = root;
    	while(curr!=null||!st.isEmpty())
    	{
    		while(curr!=null)
    		{
    			st.push(curr);
    			curr=curr.left;
    		}
    		
    		curr=st.pop();
    		if(curr.right!=null)
    		{
    			curr=curr.right;
    		}
    		else
    		{
    			System.out.println(curr.data);
    		    curr=st.pop();
    		}
    		
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    
    void printAllNodesOfTree(Node temp) {
    	
    	if(temp!=null)
    	{
    		printAllNodesOfTree(temp.left);
    		System.out.println(temp.data);
    		printAllNodesOfTree(temp.right);
    	}
    
         
    	
    }
    
    
    
    
    public void printTopViewUsingRecurssion(Queue<QItem> que,HashSet<Integer> set,Node temp) {
    	
    	if(temp==null||que.isEmpty())
    	{
    		return;
    	}
    	QItem qtemp=que.remove();
    	int hd=qtemp.hd;
    	Node qNode=qtemp.node;
    	if(!set.contains(hd))
    	{
    		System.out.println(qNode.data);
    		set.add(hd);
    	}
    	if(temp.left!=null)
    	{
    		que.add(new QItem(temp.left, hd-1));
    		printTopViewUsingRecurssion(que,set,temp.left);
    	}
    	if(temp.right!=null)
    	{	
    		que.add(new QItem(temp.right, hd+1));

    		printTopViewUsingRecurssion(que,set,temp.left);
    	}
      
    }
    public void printTopView()
    {
        // base case
        if (root == null) {
            return;
        }
        
        Queue<QItem> qitem = new LinkedList<QItem>();
        HashSet<Integer> set = new HashSet<Integer>();
        qitem.add(new QItem(root,0));
        //System.out.println(root.data);
        while(!qitem.isEmpty())
        {
        	QItem ele= qitem.remove();
        	int hd =ele.hd;
        	Node temp = ele.node;
        	
        	if(!set.contains(hd))
        	{
        		System.out.println(temp.data);
        		set.add(hd);
        	}
        	if(temp.left!=null)
        	{
        		qitem.add(new QItem(temp.left,hd-1));
        	}
        	if(temp.right!=null)
        	{
        		qitem.add(new QItem(temp.right,hd+1));
        	}
        	
        }

 
    }

    
    public void printSideView()
    {
        // base case
        if (root == null) {
            return;
        }
        
        Queue<QItem> qitem = new LinkedList<QItem>();
        HashSet<Integer> set = new HashSet<Integer>();
        qitem.add(new QItem(root,0));
        //System.out.println(root.data);
        while(!qitem.isEmpty())
        {
        	QItem ele= qitem.remove();
        	int hd =ele.hd;
        	Node temp = ele.node;
        	
        	if(!set.contains(hd))
        	{
        		System.out.println(temp.data);
        		set.add(hd);
        	}
        	if(temp.right!=null)
        	{
        		qitem.add(new QItem(temp.right,hd+1));
        	}
        	if(temp.left!=null)
        	{
        		qitem.add(new QItem(temp.left,hd+1));
        	}

        	
        }
    }
    
    public void printSideViewUsingRecurssion(Node root,int le)
    {
        // base case
        if (root == null) {
            return;
        }
        
        if(maxlevel<le)
        {
        	System.out.println(root.data);
        	maxlevel=le;
        }
        printSideViewUsingRecurssion(root.right,le+1);
        printSideViewUsingRecurssion(root.left,le+1);
     

      
    }
    
    public void PrintAllLNodesLevelWiseUsingQueue(Node root) {
    	
    	Queue<Node> q = new LinkedList<Node>();
    	
    	q.add(root);
    	while(!q.isEmpty()) {
    		
    		Node temp=q.poll();
    		System.out.println(temp.data);
    	    if(temp.left!=null) {
    	    	q.add(temp.left);
    	    }
    	    if(temp.right!=null) {
    	    	q.add(temp.right);
    	    }
    	}
    }
    
    public int  hieghtOfTree(Node root) {
    	
    	if(root/*.left*/==root.left.right)///this is used when the leaf nodes form doubled linked list or else just use root==null
    	{
    		return 0;
    	}
    	else
    	{
    		int left=hieghtOfTree(root.left);
    	    int right=hieghtOfTree(root.right);
    	    
    	    if(left<right)
    	    {
    	    	return right+1;
    	    }
    	    else
    	    {
    	    	return left+1;
    	    }
    	}
    }
    
    
    public int printSize(Node root) {
    	
    	if(root==null)
    	{
    		return 0;
    	}
    	return printSize(root.left)+printSize(root.right)+1;
    }
    
    public void printNodesAtGivenLevel(Node root, int level)
    {
    	if(root==null)
    	{
    		return;
    	}
    	if(level==0)
    	{
    		System.out.println(root.data);
    	}
    	else
    	{
    		printNodesAtGivenLevel(root.left,level-1);
    		printNodesAtGivenLevel(root.right,level-1);
    	}
    }
    
    public void printLeavesOfTree(Node root) {
    	
    	if(root==null)
    	{
    		return;
    	}
    	else if(root.left==null&&root.right==null)
    	{
    		System.out.println(root.data);
    	}
    	else
    	{
    		printLeavesOfTree(root.left);
    		printLeavesOfTree(root.right);
    		
    	}
    	
    }
    
   
    
    public void printBoundaryOftree(Node root,int level) {
    	
    	if(root==null)
    	{
    		return ;
    	}
    	else{
    		System.out.println(root.data);
    		
    		printBoundaryOftree(root.left,level+1);
    		if(level==0)
    		{
    			printBoundaryOftree(root.right,0);
    		}
    	}
    }
    
    public boolean findPath(Node root,int n1,ArrayList<Integer> path) {
    	
    	if(root==null) {
    		return false;
    	}
    	if(root.data==n1) {
    		return true;
    	}
    	
    	path.add(root.data);
    	
    	if(root.left!=null&&findPath(root.left, n1, path)) {
    		return true;
    	}
    	if(root.right!=null&&findPath(root.right, n1, path)) {
    		return true;
    	}
    	path.remove(path.size()-1);
    	return false;
    	
    }
    
    public int findleastCommonAncestor(Node root,int n1,int n2 ) {
    	
    	ArrayList<Integer> path1=new ArrayList<Integer>();
    	ArrayList<Integer> path2=new ArrayList<Integer>();

    	if(!findPath(root, n1, path1)||!findPath(root, n2, path2)) {
    		 System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
             System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
             return -1; 
         } 
    		
    	int i; 
        for (i = 0; i < path1.size() && i < path2.size(); i++) { 
              
        // System.out.println(path1.get(i) + " " + path2.get(i)); 
            if (!path1.get(i).equals(path2.get(i))) 
                break; 
        } 
  
        return path1.get(i-1); 
    }
    
    Node prev,first,second,middle;
//    public void exchangeWrongsNode(Node root) {
//    	
//    	if(root==null)
//    	{
//    		return;
//    	}
//    	
//    	exchangeWrongsNode(root.left);
//    	
//    	if(prev!=null&&prev.data>root.data) {
//    		
//    		if(first==null) {
//    			
//    			first=prev;
//    			middle=root;
//    		}
//    		else
//    		{
//    			second=root;
//    		}
//    		
//    		
//    	}
//    	
//    	prev=root;
//    	
//    	exchangeWrongsNode(root.right);
//    }
    
    
    public void exchangeWronglyPlacedNode(Node root,Node parent) {
    	
    	if(root==null) {
    		return;
    	}
    	
    	exchangeWronglyPlacedNode(root.left,root);
    	
    	if(root.data>root.left.data)
    	
    	exchangeWronglyPlacedNode(root.right, root);
    	
    	
    	
    }
    
    
    public int  caliculateCombinations(ArrayList<Integer> d,int n) {
    	
    	int sum=0;
    	for(int i =n-2;i>0;i--) {
    		sum=sum+(i*(i+1)/2);
    		System.out.println("value of"+i);
    	}
    	return sum;
    	
    }
    

    public Node leastCommonAnsestorEfficientVersion(Node root,int n1,int n2) {
    	
    	
    	if(root==null) {
    		return null;
    	}
    	
    	if(root.data==n1||root.data==n2) {
    		return root;
    	}
    	
    	Node left=leastCommonAnsestorEfficientVersion(root.left, n1, n2);
    	Node right = leastCommonAnsestorEfficientVersion(root.right, n1, n2);
    	
    	if(left!=null&&right!=null) {
    		return root;
    	}
    	return (left!=null)?left:right;
    }
    
    
    public boolean compareTwoNodes(Node first,Node second) {
    	
    	if(first==null&&second==null) {
    		return true;
    	}
    	
    	else if(first.data==second.data) {
    		
    		return compareTwoNodes(first.right, second.right)&&(compareTwoNodes(first.left, second.left));
    	
    	}
    	
    	return false;
    }
    
    
    public int NodeDataIsSumOfAllItsChildrens(Node root){
    	
    	
    	if(root==null) {
    		return 0;
    	}
    	
    	
    	root.data=root.data+NodeDataIsSumOfAllItsChildrens(root.right);
    	root.data=root.data+NodeDataIsSumOfAllItsChildrens(root.left);
    	return root.data;
    	
    }
    public void sumOfAllNodesGreaterThanThatNode(Node root) {
    	
    	if(root==null) {
    		return ;
    	}
    	
    	sumOfAllNodesGreaterThanThatNode(root.left);
    	root.data=root.data+NodeDataIsSumOfAllItsChildrens(root.right);
    }
    
    public Node Clone(Node root1,Node root2) {
    	
    	
    	if(root1==null) {
    		return null;
    	}
    	
    	root2=new Node(root1.data);
    	root2.left=Clone(root1.left, root2.left);
    	root2.right=Clone(root1.right, root2.right);
    	return root2;
    }
    
    
    //clone node with random pointer
    /*
     * 3) Given a deck of n cards, in each iteration the top card is removed and pushed to the end and the second card is removed from the deck. For eg: In 1st iteration, 1st card will added to the end and 2nd card will be removed, again 3rd card will be added to the end and 4th card will be removed and so on. Find the last card which will be remained.


     */
    
    public static void main(String args[])
    {
    	TreesImplementation tree = new TreesImplementation();
    	tree.root=new Node(8);
    	tree.root.left= new Node(4);
    	tree.root.right=new Node(15);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(9);
        tree.root.right.right = new Node(20);
        //tree.sumOfAllNodesGreaterThanThatNode(tree.root);
    	TreesImplementation tree1 = new TreesImplementation();
    	
       // tree.Clone(tree.root,tree1.root);
     //   System.out.println(tree.Clone(tree.root,tree1.root).data);
        tree.printAllNodesOfTree(tree.Clone(tree.root,tree1.root));
//    	TreesImplementation tree1 = new TreesImplementation();
//    	tree1.root=new Node(1);
//    	tree1.root.left= new Node(2);
//    	tree1.root.right=new Node(3);
//        tree1.root.left.left = new Node(4);
//        tree1.root.left.right = new Node(5);
//        tree1.root.right.left = new Node(6);
//        tree1.root.right.right = new Node(7);        
        
//        tree.root.left.left.right = tree.root.left.right;
//        tree.root.left.left.left = tree.root.right.right;
//        
//        tree.root.left.right.left = tree.root.left.left;
//        tree.root.left.right.right = tree.root.right.left;
//        
//        
//        tree.root.right.left.right =  tree.root.right.right;
//        tree.root.right.left.left =  tree.root.left.right;
//        
//        tree.root.right.right.left = tree.root.right.left;
//        tree.root.right.right.right = tree.root.left.left;
       // ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
       // System.out.println(tree.hieghtOfTree(tree.root));
        
      //  System.out.println(tree.compareTwoNodes(tree.root, tree1.root));
       // Map<Integer, ArrayList<Node>> m = new HashMap<>();
       // tree.printVerticalOrderUsingRcurrsion(tree.root, 0, m);
//        for(Entry<Integer, ArrayList<Node>> md : m.entrySet()) {
//        	System.out.println("distabce"+md.getKey());
//        	for(Node lis:md.getValue())
//        	{
//        		System.out.println(lis.data);
//        	}
//        	
//        }
//        tree.root.right.right.left= new Node(88);
//        tree.root.right.right.left.left= new Node(88);
//        tree.root.right.right.right= new Node(55);
       // tree.printVerticalOrderOfTree(tree.root);
        //tree.printBoundaryOftree(tree.root,0);
      //  tree.printSideView();
       // System.out.println(tree.printSize(tree.root));
        //tree.printTopView();
        //System.out.println("");
        //Queue<QItem> que = new LinkedList<QItem>();
        //que.add(new QItem(tree.root,0));
        //HashSet<Integer> set = new HashSet<Integer>();
        //tree.printTopViewUsingRecurssion(que, set, tree.root);
        
        
        
    }
    
    
	
}
