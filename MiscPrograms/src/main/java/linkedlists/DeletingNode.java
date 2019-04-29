package linkedlists;

import java.util.HashSet;
import java.util.Stack;

///This program is about deleteing adding and getting count of nodes
public class DeletingNode  {
Node head; 
static class Node{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
		next=null;
	}
	
}
void DeleteNode(int data)
{
	Node temp=head;
	if(temp.data==data) {
		head=temp.next;
	}
	else {
	while(temp.next!=null)
	{
		if(temp.next.data==data)
		{
			temp.next=temp.next.next;
			break;
		}
		else
		temp=temp.next;
	}
	}
}
	
public int getCountRec(Node node)
{
    if (node == null)
        return 0;
    return 1 + getCountRec(node.next);
}
void addNodes(int data)
{
	if(head==null)
	{
		head= new Node(data);
	}
	else {
	Node temp=head;
	while(temp.next!=null)
	{
		temp=temp.next;
	}
	temp.next= new Node(data);
	}
}

void addNodesAtFront(Node temp)
{
	Node front=temp;
	
	if(head==null)
	{
		head=front;
	}
	else
	{
		front.next=head;
		head=front;
	}
	
}
void addNodesAtLast(Node temp)
{
	Node end=temp;
	
	if(head==null)
	{
		head=end;
	}
	else
	{
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=end;
	}
	
}

void searchElement(int data)
{
	
	Node temp=head;
	while(temp!=null)
	{
		if(temp.data==data)
		{
		System.out.println("found element");
		break;
		}
		temp=temp.next;
	}
}

Boolean findElementByRecurrsive(Node node,int data)
{
	if(node==null)
	{
		return false;
	}
	if(node.data==data)
	{
		return true;
	}
	
	return findElementByRecurrsive(node.next,data);
	
}



void deleteNodeAtPosition(int pos) {
	
	if(pos==1)
	{
		head=head.next;
	}
	else
	{
		int i=1;
		Node temp=head;
		while(pos-1>i)
		{
			temp=temp.next;
			i++;
		}
		temp.next=temp.next.next;
		
	}
}

void printNode()
{
	Node temp=head;
	
	while(temp!=null)
	{
		System.out.println(temp.data);
		temp=temp.next;
	}
}

void printListInReverseOrder(Node node) {
	
	if(node==null) {
		return;
	}
	else
	{
		printListInReverseOrder(node.next);
		System.out.println(node.data);
	}
	
}

void segregateEvenAndOddsOfLinkedLists() {
	
	Node head1=head;
	Node head2=head.next;
	Node temp1=head1;
	

	while(temp1.next!=null)
	{
		Node temp=temp1.next;
		temp1.next=temp1.next.next;
		temp1=temp;	
		
	}
	head=head2;
	
	
}

void deleteNodesOfGreaterValueOnRightSide() {
	
	Node temp=head;
	Node prev=null;
	while(temp.next!=null) {
		
		if(temp.data<temp.next.data)
		{
			if(prev!=null)
			prev.next=temp.next;
			else
			head=temp.next;
		}
		else
		{
			prev=temp;
		}
		temp=temp.next;
	}
}

void rotateLinkedList(int k) {
	Node temp=head;
	while(k!=1&&temp!=null)
	{
		k--;
		temp=temp.next;
	}
	
	Node seco=temp.next;
	temp.next=null;
	temp=seco;
	while(temp.next!=null)
	{
		temp=temp.next;
	}
	temp.next=head;
	head=seco;
}
int carry=0;

void addTwoLinkedLists(Node head1,Node head2) {
	
	if(head1==null)
	{
		return ;
	}
	addTwoLinkedLists(head1.next,head2.next);
	int sum=head1.data+head2.data+carry;
	
	System.out.println(sum%10);
	carry=sum/10;
	
	
}

int addTwoLinkedListsVersion2(Node head1,Node head2,int carry) {
	
	if(head1==null)
	{
		return 0;
	}
	else 
	{
	carry=addTwoLinkedListsVersion2(head1.next,head2.next,carry);
	int sum=head1.data+head2.data+carry;
	
	System.out.println(sum%10);
	carry=sum/10;
	return carry;
	}
}
//1492
//852
int count=0;
int addTwoLinkedListsOfDiffrentLength(Node head1,Node head2,int carry) {
	
	if(head1==null) {
		return 0;
	}
	if(count==1) {
	carry= addTwoLinkedListsOfDiffrentLength(head1.next, head2.next, carry);
	}
	else {
		count++;
		carry= addTwoLinkedListsOfDiffrentLength(head1.next, head2, carry);
		
	}
	int sum= head1.data+((head2==null)?0:head2.data)+carry;
	System.out.println(sum%10);
	head1.data=sum%10;
	carry=sum/10;
	return carry;
	
}

void makeMidleElementAsHead() {
	Node temp=head;
	if(temp.next!=null)
	{
	int c=0;
	while(temp!=null)
	{
		temp=temp.next;
		c++;
	}
	temp=head;
    for(int i=1;i<c/2;i++)
    {
    	temp=temp.next;
    }
    Node dummy;
    dummy=temp.next;
    temp.next=temp.next.next;
    dummy.next=head;
    head=dummy;
	}
}
void setMiddleHead() 
{ 
    if (head == null) 
        return; 
   
    // To traverse list nodes one  
    // by one 
    Node one_node = head; 
   
    // To traverse list nodes by  
    // skipping one. 
    Node two_node = head; 
   
    // To keep track of previous of middle 
    Node prev = null; 
    while (two_node != null &&  
           two_node.next != null) { 
   
        /* for previous node of middle node */
        prev = one_node; 
   
        /* move one node each time*/
        two_node = two_node.next.next; 
   
        /* move two node each time*/
        one_node = one_node.next; 
    } 
   
    /* set middle node at head */
    prev.next = prev.next.next; 
    one_node.next = head; 
    head = one_node; 
} 

void makeMidleElementAsHeadInOneLopp()
{
	Node temp=head;
	Node temp1=head.next;
	
	while(temp1.next!=null&&temp1.next.next!=null)
	{
		temp=temp.next;
		temp1.next=temp1.next.next;
	}
	    Node dummy;
	    dummy=temp.next;
	    temp.next=temp.next.next;
	    dummy.next=head;
	    head=dummy;
	
}

void segregateEvenAndOddDataOfLinkedLists() {
	 
      Node even=head;
      Node odd =head;
      Node temp=head;
      
      while(temp!=null&&temp.data%2==0)
      {
    	  temp=temp.next;
    	  odd=temp;
      }
      temp=head;
      while(temp!=null&&temp.data%2!=0)
      {
    	  temp=temp.next;
    	  even=temp;
      }
      System.out.println(even.data+"wher"+odd.data);
      
      Node evenTempone=even;
      Node evenTemptwo=even.next;

      while(evenTemptwo!=null)
      {
    	  if(evenTemptwo.data%2==0)
    	  {
    		  evenTempone.next=evenTemptwo;
    		  evenTempone=evenTemptwo;

    	  }
		  if(evenTemptwo.next!=null)
		  evenTemptwo=evenTemptwo.next;
		  else
			  break;
      }

      
      Node oddTempone=odd;
      Node oddTemptwo=odd.next;
      while(oddTemptwo!=null)
      {
    	  if(oddTemptwo.data%2!=0)
    	  {
    		  oddTempone.next=oddTemptwo;
    		  oddTempone=oddTemptwo;

    	  }
		  if(oddTemptwo.next!=null)
			  oddTemptwo=oddTemptwo.next;
		  else
			  break;
      }
      while(even!=null) {
    	  System.out.println(even.data);
    	  even=even.next;
    	  
      }
      System.out.println("seperation");
      while(odd!=null) {
    	  System.out.println(odd.data);
    	  odd=odd.next;
      }
      
      
	
}

void removeDuplicates() {
	
	Node first=head;
	Node second=head.next;
    while(second!=null) {
    	if(second.data==first.data) {
    		second=second.next;
    	}
    	else
    	{
    		first.next=second;
        	second=second.next;
        	first=first.next;
    	}

    }
	
}

void reverseLinkedList() {
	
	Node prev=null;
	Node curr=head;
	Node temp;
	while(curr!=null)
	{
		temp=curr.next;
		curr.next=prev;
		prev=curr;
		curr=temp;
	}
	head=prev;
}

int count(Node temp1,Node temp2)
{
	int length=0;
	while(temp1!=null&&temp2!=null)
	{
		if(temp1.data==temp2.data)
		{
			length++;
		}
		temp1=temp1.next;
		temp2=temp2.next;
	}
	return length;
}

void displayLengthOfLongestPallendrom() {
	
	//very beautiful programs
	Node curr=head;
	Node next=null;
	Node prev=null;
	int result=0;
	while(curr!=null)
	{
		next=curr.next;
		curr.next=prev;
		
		result=result>(2*count(curr, next))?result:(2*count(curr, next));
		
		result=result>(2*count(prev, next))+1?result:(2*count(prev, next))+1;
		
		prev=curr;
		curr=next;
	}
	System.out.println(result);
	
}


void moveAllOcuurances(int n)
{
	Node temp=head;
	Node prev=null;
	Node dummyHead=new Node(-1);
	Node result=dummyHead;
	while(temp!=null)
	{
		if(temp.data==n)
		{
			
			if(prev!=null)
			{
				prev.next=temp.next;
				result.next=temp;
				result=temp;
				temp=prev.next;
			}
			else
			{
				result.next=temp;
				result=temp;
				temp=temp.next;
				head=temp;
			}
		}
		else {
		prev=temp;
		temp=temp.next;
	     }
	}
	result.next=null;
	
	prev.next=dummyHead.next;
	while(head!=null)
	{
		System.out.println(head.data);
		head=head.next;
	}
}

void removeDuplicatesVersionTwo() {
	

	Node first=head;
	Node second=head.next;
    while(second!=null) {
    	if(first.data!=second.data)
    	{
    		first=first.next;
    		second=second.next;
    	}
    	else
    	{
    		first.next=second.next;
    		second=second.next;
    	}
    }
}

void countRotationsOnSortedLinkedList() {
	
	/**a sorted linked list will be rotated and we have to specify the no of rotations**/
    Node temp=head;
    int c=0;
	while(temp.next!=null)
	{
		c++;
		if(temp.data>temp.next.data)
		{
			break;
		}
		
		temp=temp.next;
	}
	if(temp.next==null)
		System.out.println(0);
	else
	System.out.println(c);
}

void removeDuplicatesFromUnsortedArray() {
	
	HashSet<Integer> has = new HashSet<Integer>();
	
	Node first= head;
    has.add(first.data);
	while(first.next!=null) {
		if(has.contains(first.next.data))
		{
			first.next=first.next.next;
		}
		else
		{
			has.add(first.next.data);
			first=first.next;
		}
		
	}
//	for(Integer i : has)
//	{
//		System.out.println(i);
//	}
	
}

void deleteLastOcuuranceOfLinkedList(int n) {
	
	Node prev1=null;
	Node temp1=head;
	Node prev2=null;
	Node temp2=null;
	while(temp1!=null) {
		if(temp1.data==n)
		{
			prev2=temp1;
			temp2=prev2.next;
			break;
			
		}
		else {
			prev1=temp1;
			temp1=temp1.next;
		}
	}
	while(temp2!=null)
	{
		if(temp2.data==n)
		{
			prev1=prev2;
			temp1=temp2;		
		}
		prev2=temp2;
		temp2=temp2.next;
	}
	if(prev1==null)
	{
		head=temp1.next;
	}
	else
	prev1.next=temp1.next;
	
}


void swapNodesWithoutSwappingData(int data1,int data2) {
	
	Node first=head;
    Node second=head;
    Node prevfirst=null;
    Node prevSecond=null;
    
    while(first!=null&&first.data!=data1)
    {
        prevfirst=first;
    	first=first.next;
    }
    while(second!=null&&second.data!=data2)
    {
        prevSecond=second;
        second=second.next;
    }

    if(first==null | second ==null) {
    	System.out.println("cannot be done");
    }
    if(prevfirst!=null)
      prevfirst.next=second;
    else
      head=second;	
    if(prevSecond!=null)
        prevSecond.next=first;
      else
        head=first;	
    Node temp=second.next;
    second.next=first.next;
    first.next=temp;
    
}

void mergeTwoSortedLists(Node Head,Node Head1) {
	
	Node first=Head;
	Node second=Head1;Node temp;
	Node finalhead=(first.data<second.data)?first:second;
	while(first.next!=null&&second.next!=null)
	{
		
		if(first.data<second.data) {
			System.out.println("link from "+first.data);

			temp=first.next;
			first.next=second;
			first=temp;
			System.out.println("link to "+second.data);
		}
		else
		{
			second=second.next;
		}
		
		
		
	}
	if(first.next==null)
	{
		first.next=second;
	}
	else
	{
		second.next=first;
	}
	while(finalhead!=null)
	{
		System.out.println(finalhead.data);
		finalhead=finalhead.next;
	}

	
	///not correct
}


void unionOfTwoLinkedLists(Node head1,Node head2) {
	
  //Here we are not creating any duplicate linked list we are appending elements in to one linked list
  HashSet<Integer> hash= new HashSet<Integer>();
  Node temp1=head1;
  Node temp2=head2;
  hash.add(temp1.data);
  while(temp1.next!=null) {
	  
	  if(hash.contains(temp1.next.data))
	  {
		  temp1.next=temp1.next.next;
		  continue;
	  }
	  else
	  {
		  hash.add(temp1.next.data);
		  temp1=temp1.next;
	  }
  }
  while(temp2!=null)
  {
	  if(hash.contains(temp2.data)) {
		  temp2=temp2.next;
		  continue;
	  }
	  else {
		   Node t = temp2.next;
		   temp2.next=head1;
		   head1=temp2;
		   temp2=t;
	  }
  }
	while(head1!=null) {
		
		System.out.println(head1.data);
		head1=head1.next;
	}
}

Node findLoop(Node head) {
	
	Node temp1=head;
	Node temp2=head.next;
	while(temp2!=null&&temp2.next!=null) {
		if(temp1==temp2) {
			System.out.println("loop is there");
			return temp2;
		}
		temp1=temp1.next;
		temp2=temp2.next.next;
	}
	return null;
}

int lengthOfLoopInLinkedLists(Node head) {
	
	Node temp1=findLoop(head);
	Node temp=temp1.next;
	int count=1;
	while(temp!=temp1)
	{
		 count++;
		 temp=temp.next;
	}
	
	System.out.println(count);
	return count;
		
}

Node findHeadOfLoopedLinkedList(Node head) {

	int count=lengthOfLoopInLinkedLists(head);
	Node temp=head;
	Node temp1=head;
	while(count!=0)
	{
	 temp1=temp1.next;
	 count--;
	}
	while(temp!=temp1)
	{
		System.out.println(temp.data);
		System.out.println(temp1.data);
		temp=temp.next;
		temp1=temp1.next;
		

	}
	System.out.println("head is at"+temp1.data);
	return temp1;
	
}

void findPallendromInLoopedLinkedList(Node head) {
	
	Node temp=findHeadOfLoopedLinkedList(head);
	Node temp1=temp.next;
	Stack<Node> st = new Stack<Node>();
	
	while(temp1!=temp)
	{
		st.push(temp1);
		temp1=temp1.next;
	}
	 temp1=temp.next;
	while(!st.isEmpty()&&temp1!=temp) {
		System.out.println("temp1"+temp1.data);
		System.out.println("stack top"+st.peek().data);
		if(temp1.data!=st.pop().data)
		{
			System.out.println("not a pellendrom");
			break;
		}
		temp1=temp1.next;
	}
	
	
}

void partioningLinkedLists(int x) {
	
	Node temp=head;
	Node prev=null;
	Node smStart=null;
	System.out.println("hh");

	while(temp!=null&&temp.next!=null) {
		if(temp.next.data<x)
		{
			smStart=temp;
			System.out.println("broke");
			break;
		}
		temp=temp.next;
	}
	temp=smStart.next;
	prev=smStart;
	Node h = smStart;
	while(temp!=null)
	{
		if(temp.data<x)
		{
		    Node t = temp.next;
		    prev.next=temp.next;
		    smStart.next=temp;
		    temp.next=null;
		    temp=t;
		    smStart=smStart.next;
		}
		else
		{
			prev=temp;
			temp=temp.next;
		}
	}
	while(h.next!=null) {
		h=h.next;
	}
	h.next=head;
	
}
void intersectionOfTwoLinkedLists(Node head1,Node head2) {
 //very happy to write this code
	  HashSet<Integer> hash= new HashSet<Integer>();
	  Node temp1=head1;
	  Node temp2=head2;
	  hash.add(temp1.data);
	  while(temp1.next!=null) {
		  
		  if(hash.contains(temp1.next.data))
		  {
			  temp1.next=temp1.next.next;
			  continue;
		  }
		  else
		  {
			  hash.add(temp1.next.data);
			  temp1=temp1.next;
		  }
	  }
	  Node prev=null;
	  while(temp2!=null)
	  {
		  
		  if(hash.contains(temp2.data)) {
			   prev=temp2;
			   temp2=temp2.next;
		  }
		  else {
			  if(prev!=null) {
            prev.next=temp2.next;
            temp2=prev.next;
			  }
			  else {
				  temp2=temp2.next;
				  head2=temp2;
			  }
		  }
	  }
		while(head2!=null) {
			
			System.out.println(head2.data);
			head2=head2.next;
		}
	}
Node mergeOfTwoSortedLinkedLists(Node head1,Node head2) {
	
	Node temp1=head1;
	Node temp2=head2;
	Node result;
	Node head;
	if(temp1==null)
	{
		return temp2;
	}
	if(temp2==null)
	{
		return temp1;
	}
	if(temp1.data<temp2.data)
	{
		result=temp1;
		temp1=temp1.next;
	}
	else
	{
		result=temp2;
		temp2=temp2.next;
	}
	head=result;
	while(temp1!=null&&temp2!=null)
	{
		if(temp1.data<temp2.data)
		{
			result.next=temp1;
			result=temp1;
			temp1=result.next;
			
		}
		else {
		     result.next=temp2;
		     result=temp2;
		     temp2=result.next; 
		}
	}
	if(temp1==null)
	{
		result.next=temp2;
	}
	if(temp2==null)
	{
		result.next=temp1;
	}
	return head;
}

Node mergeAlterNativeNodes(Node head1,Node head2) {
	
	Node p=head1;
	Node q= head2;
	
	while(p!=null&&q!=null)
	{
		Node t=p.next;
		p.next=q;
		p=t;
		Node ex=p;
		p=q;
		q=ex;
	}
	return head1;
	
}

void insertNthNodeFromEnd(int postion,int data) {

	
	Node first=head;
	Node second = head;
	for(int i=1;i<postion;i++)
	{
		second=second.next;
	}
	while(second.next!=null)
	{
		second=second.next;
		first=first.next;
	}
	Node temp=first.next;
	Node insert =new Node(data);
	first.next=insert;
	insert.next=temp;
	
}


void sort21OInLinkedList() {
	
 Node start= new Node(-1);
 start.next=head;
 head=start;
 Node end= new Node(-2);
 
 Node temp=start;
 
 while(temp.next!=null)
 {
	 temp=temp.next;
 }
 temp.next=end;
 Node traverse=start;

 while(traverse.data!=-2)
 {
	 if(traverse.next.data==0)
	 {
		 Node ss=traverse.next;
		 traverse.next=traverse.next.next;
		 ss.next=head;
		 head=ss;
		 
	 }
	 else
	 traverse=traverse.next;
	
 }
 traverse=start;
 while(traverse.data!=-2)
 {
	 if(traverse.next.data==1)
	 {
		 Node ss=traverse.next;
		 traverse.next=traverse.next.next;
		 ss.next=head;
		 head=ss;
		 
	 }
	 else
	 traverse=traverse.next;
	
 }

}

void removeEveryKthLinkOfNode(int n) {
	
	Node temp=head;
	Node prev=null;
	int count =1;
	if(n==1)
	{
		System.out.println("empty list");
		return;
	}
	while(temp.next!=null) {
		if(count==n)
		{
			prev.next=temp.next;
			count=1;
			temp=temp.next;
		}
		else
		{
			count++;
			prev=temp;
			temp=temp.next;
		}
	}
	
}

void pairWiseSwapElements() {
	
	
	Node first=head;
	Node second=head.next;
	head=second;
//	while(second!=null)
//	{
//		System.out.println(first.data+"intially"+second.data);
//
//		Node temp=second.next;
//		second.next=first;
//		first.next=temp;
//		//System.out.println(first.next.data+"after exchnage"+second.next.data);
//
//		if(first.next!=null)
//		{
//		first=first.next;
//		second=first.next;
//	    }
//		else
//		{
//			break;
//		}
//		
//		
//		System.out.println(first.data+"new pinters"+second.data);
//	}
	
	while(true) {
		
		Node temp=second.next;
		second.next=first;
		if(temp==null||temp.next==null) {
			first.next=temp;
			break;
		}
		first.next=temp.next;
		first=temp;
		second=first.next;
	}
}

	public static void main (String args[])
	{
		DeletingNode add = new DeletingNode();

		DeletingNode ad1 = new DeletingNode();
//
//     
//	  
	
		  
				add.addNodes(8);
				add.addNodes(5);
				  
				add.addNodes(2);
				  
				ad1.addNodes(1);
				ad1.addNodes(4);
				ad1.addNodes(9);
				ad1.addNodes(2);
//				add.printNode();
//				System.out.println("sff");
//	    add.rotateLinkedList(1);
				//add.addTwoLinkedLists(add.head, ad1.head);
				//add.printNode();
				//System.out.println("fsfsfsa");
				//add.printListInReverseOrder(add.head);
			//	add.printNode();
				add.addTwoLinkedListsOfDiffrentLength(ad1.head, add.head,0);
	    //add.printNode();
//		  Node head = new Node(10); 
//		    head.next = new Node(20); 
//		    head.next.next = new Node(30); 
//		    head.next.next.next =new Node(16); 
//		    head.next.next.next.next = new Node(50); 
//		    
//		  head.next.next.next.next.next =head.next.next; 
//
//		    add.findHeadOfLoopedLinkedList(head);
//	
		    
		
		  // add.sort21OInLinkedList();
		//add.printNode();
		   
//		  
//		Node head=add.mergeAlterNativeNodes(ad.head,add.head);
//		   while(head!=null)
//		   {
//			   System.out.println(head.data);
//			   head=head.next;
//		   }

//			

			
	
		//add.printNode();
		
		//add.deleteNodeAtPosition(2);
		//add.printNode();
	//	add.removeDuplicatesFromUnsortedArray();
			//add.removeDuplicates();
			
		    // add.swapNodesWithoutSwappingData(9, 2);
			//add.printNode();
		//	add.countRotationsOnSortedLinkedList();
//			add.insertNthNodeFromEnd(4, 8);
//			add.printNode();
			//add.segregateEvenAndOddsOfLinkedLists();
			//add.printNode();
		//System.out.println(add.getCountRec(add.head.next));
	    
	}
	
	
}
