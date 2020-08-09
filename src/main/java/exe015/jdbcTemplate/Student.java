package exe015.jdbcTemplate;

public class Student {
	
	private int type;
	private int idcard;
	private int examcard;
	private String studentName;
	private String location;
	private int grade;
	
	public Student() {
		super();		
	}	
	
	public Student(int type, int idcard, int examcard, String studentName, String location, int grade) {
		super();
		this.type = type;
		this.idcard = idcard;
		this.examcard = examcard;
		this.studentName = studentName;
		this.location = location;
		this.grade = grade;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIdcard() {
		return idcard;
	}
	public void setIdcard(int idcard) {
		this.idcard = idcard;
	}
	public int getExamcard() {
		return examcard;
	}
	public void setExamcard(int examcard) {
		this.examcard = examcard;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

}
