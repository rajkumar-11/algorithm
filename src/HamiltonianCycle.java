import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HamiltonianCycle 
{
	public static void main(String[] args) {
		int graph1[][]={{0, 1, 0, 1, 0}, 
                {1, 0, 1, 1, 1}, 
                {0, 1, 0, 0, 1}, 
                {1, 1, 0, 0, 0}, 
                {0, 1, 1, 0, 0}, 
               }; 
		HamiltonCycle(graph1, 5);

	}

	private static void HamiltonCycle(int[][] graph1, int V) {

		// int[] path = new int[V];

		List<Integer> list = new LinkedList<>();

		boolean[] visited = new boolean[V];

		// visited[0]=true;

		list.add(0);

		if (isHamilton(graph1, list, visited, 0, V,0) == false) {
			System.out.println("There is no hamilton cycle");
			// System.out.println("size after= " + list.size());

		} else {

			for (int i = 0; i < V; i++) {
				System.out.print(list.get(i) + "  ");
			}

			System.out.println("The graph is hamilton");

		}

	}

	private static boolean isHamilton(int[][] graph1, List<Integer> list, boolean[] visited, int index, int v,int start) {
		// System.out.println("size= " + list.size() + " index= " + index);

		// for(int i=0;i<v;i++)
		// {
		// System.out.print(visited[i]+" ");
		// }

//		if (list.size() == v && index==start) {
//			// list.add(index);
//
//			return true;
//		}

		visited[index] = true;

		//

		// else if()

		for (int i = 0; i < v; i++)
		{
			// System.out.println("index= "+index);
			if (graph1[index][i] != 0 && visited[i] == false)
			{
//				 System.out.println(" index= " + index + " i= " + i);
				list.add(new Integer(i));
				if (isHamilton(graph1, list, visited, i, v,start))
					return true;
				list.remove(new Integer(i));

			}
			else if(graph1[index][i] != 0 && visited[i] == true && list.size()==v && i==start)
			{
//				System.out.println("here");
				return true;
				
			}
			

		}
		visited[index] = false;
		return false;
	}
}
