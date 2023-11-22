package task1;

import java.util.List;

public class Course {
	private String id, title, type, lecturer;
	private List<Student> students;

	public Course(String id, String title, List<Student> students, String type, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.students = students;
		this.type = type;
		this.lecturer = lecturer;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
