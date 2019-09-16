package connectedComponents;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph_ConnectedComponents {
	private int V;
	private LinkedList<Integer> adj[];

	Graph_ConnectedComponents(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	public static void main(String[] args) {
		Graph_ConnectedComponents g = new Graph_ConnectedComponents(5);
		g.addEdge(1, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.findConnectedComponents();
	}

	private void findConnectedComponents() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFSREcursion(i, visited);
				System.out.println();
			}
		}
	}

	private void DFSREcursion(int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(i + " ");
		Iterator<Integer> itr = adj[i].listIterator();
		while (itr.hasNext()) {
			int n = itr.next();
			if (!visited[n]) {
				DFSREcursion(n, visited);
			}
		}
	}
}
