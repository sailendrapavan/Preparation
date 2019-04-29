package linkedlists;

public class Creation
{
 Node head;  
 static class Node {
     int data;
     Node next;
     Node(int d)  { 
    	 data = d;  next=null;
    	 } 
 }

 public static void main(String[] args)
 {

	 Creation llist = new Creation();

     llist.head  = new Node(1);
     Node second = new Node(2);
     Node third  = new Node(3);
     llist.head.next = second;
     second.next = third; 
     Node temp=llist.head;
     while(temp.next!=null)
     {
    	 temp=temp.next;
     }
     temp.next=new Node(4);
     temp=llist.head;
     while(temp!=null)
     {
    	 System.out.println(temp.data);
    	 temp=temp.next;
     }
 }
}