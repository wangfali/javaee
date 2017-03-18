package briup.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import briup.Bean.Student;
import briup.Dao.StudentDao;
import briup.common.HibernateSessionFactory;
import briup.common.exception.StudentServiceException;
import briup.service.IStudentService;

public class StudentService implements IStudentService{
	private StudentDao studentDao=new StudentDao();
	public Student Login(String name, String password)throws StudentServiceException {
		Session session=HibernateSessionFactory.getSession();
		//开启事务
		Transaction tran=session.beginTransaction();
		//1.通过username找到stu
		//2.对比密码
		Student stu=studentDao.getStuByName(name);
		if(stu!=null){
			if(stu.getPassword().equals(password)){
				tran.commit();
				return stu;
			}else{
				tran.rollback();
				throw new StudentServiceException("登录失败！密码错误");
			}
		}else{
			tran.rollback();
			throw new StudentServiceException("登录失败！该用户名不存在");
		}
	}

	@Override
	public void register(Student stu)throws StudentServiceException {
		// TODO Auto-generated method stub
		//开启事务
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		//处理代码。。调用Dao层代码
		//1.先判断该用户名是否已经被占用，如果占用抛出异常
		Student dbStu=studentDao.getStuByName(stu.getName());
		if(dbStu==null){
			studentDao.addStu(stu);
			System.out.println("进入Dao层代码进行存储！");
		}else{
			tran.rollback();
			throw new StudentServiceException("该用户名已经被使用！");
		}
		tran.commit();
	}

	@Override
	public List<Student> listAllStudent() throws StudentServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
