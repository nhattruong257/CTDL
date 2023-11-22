package task1;

public class Student {
	private String id, name;
	private int year;

	public Student(String id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


}
