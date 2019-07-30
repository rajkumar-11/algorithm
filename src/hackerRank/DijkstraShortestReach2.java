package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraShortestReach2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner s = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int t = s.nextInt();
		StringTokenizer st= new StringTokenizer(reader.readLine());
		int t=Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
//			String line=reader.readLine();
			st= new StringTokenizer(reader.readLine());
//			String[] strs=line.trim().split("\\s+");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
//			System.out.println("n= "+n+" m= "+m);
			WeightedGraph graph = new WeightedGraph(n);
			for (int j = 0; j < m; j++) {
//				String line1=reader.readLine();
//				String[] strs1=line1.trim().split("\\s+");
				st= new StringTokenizer(reader.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
//				System.out.println("u= "+u+" v= "+v+" w= "+w);
//				System.out.println("u= "+u+" v= "+v+" w= "+w);
				graph.add(u - 1, v - 1, w);
			}
			st= new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(st.nextToken());
				int[] arr = findMinimumDistance(graph, n, m, x - 1);
				for (int q = 0; q < n; q++) {
					if(q==x-1)
					{
						continue;
					}
					System.out.print(arr[q] + " ");
				}
				System.out.println();

			}

		}

	

	private static int[] findMinimumDistance(WeightedGraph graph, int n, int m, int s) {
		int v = graph.V;

		boolean[] visited = new boolean[graph.V];
		NodeP[] nodes = new NodeP[graph.V];

		for (int i = 0; i < graph.V; i++) {
			nodes[i] = new NodeP(i, -1, Integer.MAX_VALUE);

		}
		nodes[s].value = 0;

		PriorityQueue<NodeP> queue = new PriorityQueue<>(new compare2());

		for (int i = 0; i < graph.V; i++) {
			queue.add(nodes[i]);
		}

		while (!queue.isEmpty()) {
			NodeP nodep = queue.poll();
			visited[nodep.u] = true;

			Iterator<Node> itr = graph.list[nodep.u].iterator();

			while (itr.hasNext()) {
				Node node = itr.next();

				if (visited[node.v] == false && nodes[nodep.u].value!=Integer.MAX_VALUE &&(nodes[node.v].value > nodes[nodep.u].value + node.w)) {
					queue.remove(nodes[node.v]);
					nodes[node.v].value = nodes[nodep.u].value + node.w;
					nodes[node.v].parent = nodep.u;
					queue.add(nodes[node.v]);

				}
//             System.out.println("here");
			}

		}
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			if (nodes[i].value == Integer.MAX_VALUE)
				dist[i] = -1;
			else {
				dist[i] = nodes[i].value;
			}
		}
//        System.out.println("jai shree ram");
		return dist;
	}
}

 class WeightedGraph 
{ 
	int V;
	LinkedList[]list=null;

public WeightedGraph(int v)
{
	this.V=v;
	this.list= new LinkedList[v];
	
	for(int i=0;i<v;i++)
	{
		this.list[i]= new LinkedList<Node>();
	}
}
public void add(int u,int v,int w)
{
	list[u].add(new Node(v,w));
	list[v].add(new Node(u,w));
	
}
	
}
 class NodeP {
		int u, parent, value;

		public NodeP(int u, int parent, int value) {
			this.u = u;
			this.parent = parent;
			this.value = value;
		}

	}
 class compare2 implements Comparator<NodeP> {

		@Override
		public int compare(NodeP node, NodeP node1) {
			// TODO Auto-generated method stub
			return node.value - node1.value;
		}

	}
 class Node
{
  int v,w;
  
 public Node(int v,int w)
 {
	 this.v=v;
	 this.w=w;
	 
 }
	
	
}
