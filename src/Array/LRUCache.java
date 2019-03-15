package Array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
	int size;
	 LinkedList<Integer> list= null;
	 Set<Integer>set=null;
	 
	public LRUCache(int n)
	{
        this.list= new LinkedList<>();
        this.set= new HashSet<>();
		this.size=n;
	}

	public static void main(String[] args) 
	{
		LRUCache ca = new LRUCache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();

	}

	private void display() 
	{
		Iterator<Integer>itr=list.iterator();
		while(itr.hasNext())
		{
			int x=itr.next();
			System.out.print(x+" ");
	
		}

	}

	private void refer(int i)
	{
	  if(!set.contains(i))
	  {
		  if(list.size()==size)
		  {
			  int last=list.removeLast();
			  set.remove(last);
		  }
		  
		  
	  }
	  else
	  {
		  Iterator<Integer>itr=list.iterator();
		  while(itr.hasNext())
		  {
			  int x=itr.next();
			  if(x==i)
			  {
				  list.remove(x);
				  break;
			  }
			  			  
		  }
	  }
	  list.addFirst(i);
	  set.add(i);
		

	}

}
