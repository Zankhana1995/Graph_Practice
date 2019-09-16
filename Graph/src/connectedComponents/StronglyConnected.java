package connectedComponents;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class StronglyConnected {
	static int noOfTestCases;

	static int edges;
	private static int V; // No. of vertices
	private static LinkedList<Integer> adj[]; // Adjacency List

	StronglyConnected(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}
	static void addEdge(int v, int w) {
		adj[v].add(w);
	}
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
	
		int n;
		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		noOfTestCases = Integer.parseInt(sc.nextLine());
		String[] arr = sc.nextLine().split("\\s+");
		V = Integer.parseInt(arr[0]);
		edges = Integer.parseInt(arr[1]);
		String[] array =sc.nextLine().split("\\s+");
		for(int i=0;i<array.length-1;i++)
		{
			addEdge(Integer.parseInt(array[i]),Integer.parseInt(array[i+1]));
		}
		System.out.println(adj);
		sc.close();
	}
}
