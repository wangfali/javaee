package briup.Dao;

import java.util.List;
import org.hibernate.Session;
import briup.Bean.Student;
import briup.common.HibernateSessionFactory;

public class StudentDao {
public Session getSession(){
	return HibernateSessionFactory.getSession();
}
public void addStu(Student Stu){
	getSession().save(Stu);
}
public Student getStuByName(String name){
	String hql="from Student where name=?";
org.hibernate.Query query=getSession().createQuery(hql);
	query.setString(0, name);
	@SuppressWarnings("unchecked")
	List<Student>list=query.list();
	if(list.size()>0){
		return list.get(0);
	}
	return null;
}
}
