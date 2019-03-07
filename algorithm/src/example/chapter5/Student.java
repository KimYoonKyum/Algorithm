package example.chapter5;

public class Student implements Comparable<Student> {
	String name;
	int ko;
	int en;
	int ma;
	
	@Override
	public int compareTo(Student s) {
		if(s.ko == ko) {
			if(s.en == en) {
				if(s.ma == ma) {
					return name.compareTo(s.name);
				} else {
					return s.ma - ma;
				}
			} else {
				return en - s.en;
			}
		} else {
			return s.ko - ko;
		}
	}
}
