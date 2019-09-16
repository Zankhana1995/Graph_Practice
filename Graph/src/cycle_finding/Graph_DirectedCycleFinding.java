package cycle_finding;

import java.util.Iterator;
import java.util.LinkedList;

//find cycle exist or not in directed graph
public class Graph_DirectedCycleFinding {
	private int V;
	LinkedList<Integer> adj[];

	public Graph_DirectedCycleFinding(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static void main(String[] args) {
		Graph_DirectedCycleFinding g = new Graph_DirectedCycleFinding(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.findCycle(2);
		//try commenting (2,0) and (3,3) to see without cycle result.
	}
	//using bfs find cycle
	private void findCycle(int i) {
		boolean visited[] = new boolean[V];
		visited[i] = true;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(i);
		while (q.size() != 0) {
			int s = q.poll();
			Iterator<Integer> itr = adj[s].listIterator();
			while (itr.hasNext()) {
				int n = itr.next();
				if (visited[n] == false) {
					q.add(n);
					visited[n] = true;
				} else {
					System.out.println("Cycle exists");
					return;
				}
			}

		}
		System.out.println("Cycle not exist");
	}

}
