package in.ineuron.presistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.JDBC.util.jdbcUtil;
import in.ineuron.dto.Student;

public class StudentDaoImpl implements IStudentDao
{
	Connection connection=null;
	PreparedStatement pstm=null;
	ResultSet resultset=null;
	Student student=null;
	public String addStudent(Student student) 
	{
		try {
			connection=connection=jdbcUtil.getConnection();
			if(connection!=null)
			{
			String query="Insert into studnet (sid,`sname`,sage)values(?,?,?)";
			pstm=connection.prepareStatement(query);
			}
			if(pstm!=null)
			{
				
				pstm.setInt(1,student.getId());
				pstm.setString(2,student.getName());
				pstm.setInt(3,student.getAge());
				
				int rowAffected=pstm.executeUpdate();
				if(rowAffected==1)
				{
					return "success";
				}
				
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
		
	}

	@Override
	public Student searchStudent(Integer id) {
		
		try {
			connection=connection=jdbcUtil.getConnection();
			if(connection!=null)
			{
			String query="Select sid,sname,sage from studnet where sid=?";
			pstm=connection.prepareStatement(query);
			}
			if(pstm!=null)
			{
				pstm.setInt(1, id);
				resultset=pstm.executeQuery();
			}
			if(resultset!=null)
			{
				
				if(resultset.next())
				{
					student = new Student();
					
					student.setId(resultset.getInt(1));
					student.setName(resultset.getString(2));
					student.setAge(resultset.getInt(3));
					return student;
				}
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
		
		
	}

	@Override
	public String updateStudent(Student student) {
		try {
			connection=connection=jdbcUtil.getConnection();
			if(connection!=null)
			{
			String query="update student set name=?,age=?,address=? where id=?";
			pstm=connection.prepareStatement(query);
			}
			if(pstm!=null)
			{
				pstm.setInt(1, student.getId());
				pstm.setString(2,  student.getName());
				pstm.setInt(3,student.getAge());
				
				int rowAffected=pstm.executeUpdate();
				if(rowAffected==1)
				{
					return "success";
				}
				
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
		
	}

	@Override
	public String deleteStudent(Integer id) {
		try {
			connection=connection=jdbcUtil.getConnection();
			if(connection!=null)
			{
			String query="delete from studnet where sid=?";
			pstm=connection.prepareStatement(query);
			}
			if(pstm!=null)
			{
				pstm.setInt(1, id);
				
				
				int rowAffected=pstm.executeUpdate();
				if(rowAffected==1)
				{
					return "success";
				}
				
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
		
	}

}
