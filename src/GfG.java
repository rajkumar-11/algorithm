import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Nodeq{
    int data;
    Nodeq left;
    Nodeq right;
    Nodeq(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {

    static Nodeq buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Nodeq root = new Nodeq(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Nodeq> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Nodeq currNodeq = queue.peek();
            queue.remove();

            // Get the current Nodeq's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current Nodeq
                currNodeq.left = new Nodeq(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNodeq.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current Nodeq
                currNodeq.right = new Nodeq(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNodeq.right);
            }
            i++;
        }

        return root;
    }
    static void deletetree( Nodeq root)
    {
        if(root == null)
            return;
        deletetree(root.left);
        deletetree(root.right);
        root.left=null;
        root.right=null;
    }
    static void printInorder(Nodeq root){
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s= br.readLine();
            Nodeq root = buildTree(s);

            Tree tr=new Tree();
            ArrayList<Integer> A=new ArrayList<Integer>();
            tr.serialize(root, A);
            deletetree(root);
            root = null;

            Nodeq getRoot=tr.deSerialize(A);
            printInorder(getRoot);
            System.out.println();
        }
    }
}// } Driver Code Ends


/*Complete the given function
Nodeq is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/
//This Code is developed by: Suman Rana
class Tree {
    public void serialize(Nodeq root, ArrayList<Integer> A)
    {
        Queue<Nodeq>queue= new LinkedList<Nodeq>();
        if(root==null)
        {
            return;
        }
        A.add(root.data);

        queue.add(root);
        while(!queue.isEmpty())
        {
            Nodeq Nodeq= queue.poll();
            // A.dd(Nodeq.data);
            if(Nodeq.left!=null)
            {
                A.add(root.left.data);
                queue.add(root.left);

            }else
            {
                A.add(-1);

            }
            if(Nodeq.right!=null)
            {
                A.add(root.right.data);
                queue.add(root.right);



            }
            else
            {
                A.add(-1);
            }


        }


    }

    public Nodeq deSerialize(ArrayList<Integer> list){

        Nodeq root=null;


        if(list.get(0)!=-1)
        {
            root= new Nodeq(list.get(0));
        }
        else
        {
            root=null;
        }

        Queue<Nodeq>queue= new LinkedList<Nodeq>();
        queue.add(root);

        int i=0;
        while(!queue.isEmpty())
        {
            Nodeq Nodeq= queue.poll();

            if(list.get(i+1)!=-1)
            {
                Nodeq Nodeq1= new Nodeq(list.get(i+1));
                Nodeq.left=Nodeq1;
                queue.add(Nodeq1);

            }
           else
            {
                Nodeq.left=null;
            }

            if(list.get(i+2)!=-1)
            {
                Nodeq Nodeq1= new Nodeq(list.get(i+2));
                Nodeq.right=Nodeq1;
                queue.add(Nodeq1);

            }
            else
            {
                Nodeq.right=null;
            }

            i=i+2;
        }
        return root;



    }
};