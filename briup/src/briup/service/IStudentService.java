package briup.service;

import java.util.List;

import briup.Bean.Student;
import briup.common.exception.StudentServiceException;

public interface IStudentService {
	Student Login(String name,String password)throws StudentServiceException;
	void register(Student stu)throws StudentServiceException;
	List<Student>listAllStudent() throws StudentServiceException;
}
