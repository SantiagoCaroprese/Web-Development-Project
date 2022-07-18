package com.javeriana.web.project.Employees.Employee.Infrastructure.Hibernate;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.WrongCredentials;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.EmployeeRepository;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeId;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateEmployeeRepository implements EmployeeRepository {
    private final int STRENGTH = 12;
    protected final SessionFactory sessionFactory;
    protected final Class<Employee> aggregateClass;

    public HibernateEmployeeRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Employee.class;
    }


    @Override
    public void save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Employee authenticate(String email, String password) {
        try {
            Employee employee = this.getByEmail(email);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(STRENGTH);
            if (encoder.matches(password, employee.data().get("password"))) {
                return employee;
            }
            else{
                throw new WrongCredentials("Wrong username or password");
            }
        } catch (EmployeeNotExist e) {
            throw new WrongCredentials("Wrong username or password");
        }
    }

    @Override
    public Employee getByEmail(String email) {
        try {
            String sql = "SELECT * FROM employees WHERE email = :employee_email";
            NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
            query.addEntity(Employee.class);
            query.setParameter("employee_email", email);
            return (Employee) query.getSingleResult();
        } catch (Exception e) {
            throw new EmployeeNotExist("Employee not found");
        }
    }

    @Override
    public Optional<Employee> find(String employeeId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(new EmployeeId(employeeId)));
    }

    @Override
    public void update(String employeeId, Employee employee) {
        sessionFactory.getCurrentSession().update(employeeId,employee);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public void delete (Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Employee>> getAll() {
        String sql = "SELECT * FROM employees";
        NativeQuery query =sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Employee.class);
        return Optional.ofNullable(query.list());
    }
}

