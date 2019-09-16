package cycle_finding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph_unDirectedGraphCyclefinding {
	int V;
	private LinkedList<Integer> adj[];

	public Graph_unDirectedGraphCyclefinding(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public static void main(String[] args) {
		Graph_unDirectedGraphCyclefinding g1 = new Graph_unDirectedGraphCyclefinding(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		// g1.addEdge(1, 2);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.findCycle(2);
		Graph_unDirectedGraphCyclefinding g2 = new Graph_unDirectedGraphCyclefinding(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.findCycle(2);
	}

	private void findCycle(int i) {
		boolean visited[] = new boolean[V];

		boolean res = findCycleRecurssion(i, visited, -1);
		if (res == true) {
			System.out.println("Cycle exist");
		} else
			System.out.println("Cycle not exist");
	}

	private boolean findCycleRecurssion(int i, boolean[] visited, int parent) {
		visited[i] = true;
		Iterator<Integer> itr = adj[i].listIterator();
		while (itr.hasNext()) {
			int n = itr.next();
			if (visited[n] == false) {
				if (findCycleRecurssion(n, visited, i)) {
					return true;
				}
			} else if (n != parent) {
				return true;
			}
		}
		return false;
	}
}
