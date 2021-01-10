package ru.rmanokhin.spring.springboot.spring_boot.empoyeeDAO;


//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.rmanokhin.spring.springboot.spring_boot.entity.Employee;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        //обёртка сессии работа с hibernate
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

    //код без использования hibernate, прямое обращениe на уровне JPA
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);

        //если использовать данный код, то при добавлении сотрудника, не будут выводится его ID в информации
//        entityManager.merge(employee);

        //с помощью этого мы получаем id нового пользователя и присваиваем его, что бы видеть в инфо
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());


    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Employee employee = session.get(Employee.class, id);

        //связь напрямую через JPA
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//
//        Query<Employee> query = session.createQuery("delete from Employee where  id=:employeeId");
//
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee where  id=:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();

    }

}

