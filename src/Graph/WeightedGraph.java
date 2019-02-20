package Graph;

import java.util.LinkedList;

public class WeightedGraph 
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
