package set_student_lap7;


import java.util.function.Predicate;

public class Even implements Predicate<Integer> {
	public boolean test(Integer i) {
		return (i % 2 == 0);
	}
}