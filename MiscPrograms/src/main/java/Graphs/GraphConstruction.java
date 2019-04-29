package Graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphConstruction {

	static class Graphs{
		
		int v;
		LinkedList<Integer> l[];
		
		public Graphs(int v) {
			this.v=v;
			l= new LinkedList[v];
			for(int i=0;i<v;i++) {
				l[i]= new LinkedList<Integer>();
			}
		}
	}
	
	static void addEdge(Graphs gf,int src,int dest) {
		
		gf.l[src].add(dest);
		gf.l[dest].add(src);
	}
	 static void printGraph(Graphs graph) 
	    {        
	        for(int v = 0; v < graph.v; v++) 
	        { 
	            System.out.println("Adjacency list of vertex "+ v); 
	            System.out.print("head"); 
	            for(Integer pCrawl: graph.l[v]){ 
	                System.out.print(" -> "+pCrawl); 
	            } 
	            System.out.println("\n"); 
	        } 
	    } 
	 
	 
	 static void BFS(int s,Graphs graph) {
		 
		 boolean visited[] = new boolean[graph.v];
		 
		 Queue<Integer> queue = new LinkedList<Integer>();
		 
		 queue.add(s);
		 visited[s]=true;
		 while(!queue.isEmpty())
		 {
			 int node =queue.poll();
			 System.out.println(node);
			 Iterator<Integer> it= graph.l[node].iterator();
			 while(it.hasNext())
			 {
				 int n=it.next();
				 if(!visited[n]) {
					 queue.add(n);
					 visited[n]=true;
				 }
			 }
		 }
		 
	 }
	 
	 static void DFS(int v,boolean visited[],Graphs graph) {
		 
		 visited[v]=true;
		 System.out.println(v);
		 Iterator<Integer> itr = graph.l[v].iterator();
		 
		 while(itr.hasNext()) {
			 int n = itr.next();
			 if(!visited[n]) {
				 DFS(n, visited, graph);
			 }
		 }
	 }
	 
	    static final int ROW = 5, COL = 5; 

	 static int countNoOfIslands(int a[][],int n,int m,boolean visited[][]) {
		 int count=0;
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 
				 if(a[i][j]==1&&!visited[i][j]) {
					 visited[i][j]=true;
					 count++;
					 DfsWithArrays(a,i,j,visited);
				 }
			 }
		 }
		 return count;
		 
	 }
	 
	 boolean isSafe(int a[],) {
		 
	 }
	 
	 static void DfsWithArrays(int a[][],int i,int j,boolean visited[][]) {
		 
		 int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1}; 
	     int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1}; 
	     visited[i][j]=true;
	     for(int k=0;k<8;k++) {
	    	 if(isSafe())
	     }
		  
	 }
	 
	public static void main(String args[]) 
    { 
        // create the graph given in above figure 
        int V = 5; 
        Graphs graph = new Graphs(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 2); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 2, 0); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 3); 
       // printGraph(graph); 
        //BFS(2,graph);
        DFS(2, new boolean[5], graph);
    } 
}
