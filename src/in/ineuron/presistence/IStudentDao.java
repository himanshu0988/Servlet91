package in.ineuron.presistence;

import in.ineuron.dto.Student;

public interface IStudentDao 
{
	public String addStudent(Student student);
	public Student searchStudent(Integer id);
	public String deleteStudent(Integer id);
	public String updateStudent(Student student);

}
