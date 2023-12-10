import java.util.HashSet;
import java.util.Set;

public class Target {
    public static void main(String[] args) {
        Set<Object> set= new HashSet<>();
        Object object1= new Object("rajkumar",11);
        Object object2= new Object("rajkumar",11);
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
    }
}

class Object {
    String name;

    int number;

    public Object(String name, int number) {
        this.name = name;
        this.number = number;
    }


}
