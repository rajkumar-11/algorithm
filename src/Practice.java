import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Practice {
	private int data;

	public static void main(String[] args) {
		Student s1 = new Student(1, "rajkumar");
		Student s2 = new Student(2, "pradeep");
		Student s3 = new Student(1, "rajkumar");

		Set<Student> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		Iterator<Student> itr = set.iterator();
		while (itr.hasNext()) {
			Student s = itr.next();
			System.out.println(s.toString() + s.hashCode());
			// itr.next();
		}

	}

}

class Student {
	private int rollno;
	private String name;

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollno != other.rollno)
			return false;
		return true;
	}

	public Student(int rollno, String name) {
		this.name = name;
		this.rollno = rollno;
	}
}
