package BusinessLogic;

//CRUD operations of Employee Class
import DataAccess.Employee;
import java.util.List;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ManageEmployee {

    private static SessionFactory factory;

    /* Method to CREATE an employee in the database */
    public void addEmployee(String firstname, String lastname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(firstname, lastname, salary);
            System.out.println("Employee "+employee.getFirstName());
            session.save(employee);
            System.out.println("End Save");
            tx.commit();
            System.out.println("End Commit");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to Read from the database */ 
    public void listEmployees(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator= employees.iterator(); iterator.hasNext();) {
                Employee employee = (Employee) iterator.next();
                System.out.print("Id " + employee.getId());
                System.out.print(" First Name: " + employee.getFirstName());
                System.out.print(" Last Name: " + employee.getLastName());
                System.out.println(" Salary: " + employee.getSalary());
            }
            tx.commit();
            System.out.println("End Commit");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to UPDATE an employee's proprtie in the database */
    public void updateSalary(int id, int salary){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class , id);
            employee.setSalary(salary);
            System.out.println("Employee number " + employee.getId() + " salary was changed to "+ employee.getSalary()+" successfully");
            session.update(employee);
            System.out.println("End update salary");
            tx.commit();
            System.out.println("End Commit");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void updateFirstName(int id, String firstName){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, id);
            employee.setFirstName(firstName);
            System.out.println("Employee number " + employee.getId() + " first name was changed to "+ employee.getFirstName()+" successfully");
            session.update(employee);
            System.out.println("End update first name ");
            tx.commit();
            System.out.println("End Commit");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void updateLastName(int id, String lastName){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, id);
            employee.setLastName(lastName);
            System.out.println("Employee number " + employee.getId() + " last name was changed to "+ employee.getLastName()+" successfully");
            session.update(employee);
            System.out.println("End update last name");
            tx.commit();
            System.out.println("End Commit");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to DELETE an employee in the database */
    public void deleteEmployee(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, id);
            session.delete(employee);
            System.out.println("employee was deleted successfully");
            tx.commit();
            System.out.println("End Commit");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    /* Method to create a session factory */
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);
        return factory;
    }

    //Main 
    public static void main(String... args) {
        try {
            factory = createSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
       
        
        ManageEmployee m1 = new ManageEmployee();
        // m.addEmployee("Sondes","sekrafi", 20000);
        //m.updateSalary(1, 11000);
        //m.updateFirstName(2, "Nidhal");
        //m.updateLastName(3, "Hyzinbergh");
        //m.deleteEmployee(5);
        m1.listEmployees();
    }
}