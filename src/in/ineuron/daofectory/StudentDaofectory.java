package in.ineuron.daofectory;

import in.ineuron.presistence.IStudentDao;
import in.ineuron.presistence.StudentDaoImpl;

public class StudentDaofectory
{
	private StudentDaofectory()
	{}
	private static IStudentDao studentdao=null;
	public static IStudentDao getStudentDao()
	{
		if(studentdao==null)
		{
		studentdao=new StudentDaoImpl();
		}
		return studentdao;
		
	}

}
