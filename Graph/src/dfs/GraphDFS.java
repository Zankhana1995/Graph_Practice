package dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {
	private int V;
	private LinkedList<Integer> adjancyList[];

	public GraphDFS(int V) {
		this.V = V;
		adjancyList = new LinkedList[V];
		for (int i = 0; i < adjancyList.length; i++) {
			adjancyList[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adjancyList[v].add(w);
	}

	public static void main(String[] args) {
		GraphDFS g = new GraphDFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.dfs(2);
	}

	private void dfs(int s) {
		boolean[] visited = new boolean[V];
		DFSRecurssion(s, visited);

	}

	private void DFSRecurssion(int s, boolean[] visited) {
		visited[s] = true;
		System.out.println(s);
		Iterator<Integer> i = adjancyList[s].listIterator();
		while (i.hasNext()) {
			s = i.next();

			if (!visited[s]) {
				visited[s] = true;
				DFSRecurssion(s, visited);
			}

		}
	}
}
