import java.util.ArrayList;
import java.util.List;

public class Lambda 
{
public static void main(String[] args) 
{
 List<Integer>list= new ArrayList<>();
 list.add(4);
 list.add(4);
 list.add(11);
 list.add(32);
 list.add(34);
 list.add(44);
 
 list.forEach(x -> System.out.println(x));
	
	
}
}
