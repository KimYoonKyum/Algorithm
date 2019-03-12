package example.chapter5;

public class Info implements Comparable<Info>{
	int num;
	int index;
	@Override
	public int compareTo(Info i) {
		return num - i.num;
	}
}
