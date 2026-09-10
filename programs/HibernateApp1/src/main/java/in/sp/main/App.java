package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.sp.beans.Student;

public class App 
{
    public static void main( String[] args )
    {
        Student std = new Student();
        std.setStdid(1);
        std.setName("aaa");
        std.setRollno(101);
        std.setEmail("aaa@gmail.com");
        std.setGender("male");
        std.setCity("delhi");
        
        //--------------------------------------------------
        Configuration cfg = new Configuration();
        cfg.configure("/in/sp/resources/hibernate.cfg.xml");
        
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        try
        {
        	session.save(std);	//hibernate will create insert SQL query automatically
        	System.out.println("success");
        	
        	transaction.commit();
        }
        catch(Exception e)
        {
        	System.out.println("fail");
        	transaction.rollback();
        	
        	e.printStackTrace();
        }
        finally
        {
        	session.close();
        	sessionFactory.close();
        }
        
    }
}
