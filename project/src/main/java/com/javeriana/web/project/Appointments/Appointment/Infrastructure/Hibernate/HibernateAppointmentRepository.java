package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Hibernate;

import com.javeriana.web.project.Appointments.Appointment.Domain.Appointment;
import com.javeriana.web.project.Appointments.Appointment.Domain.Ports.AppointmentRepository;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentId;
import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Exceptions.EmployeeNotExist;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Employees.Employee.Domain.ValueObjects.EmployeeId;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateAppointmentRepository implements AppointmentRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Appointment> aggregateClass;

    public HibernateAppointmentRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Appointment.class;
    }

    @Override
    public void save(Appointment appointment) {
        sessionFactory.getCurrentSession().save(appointment);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public List<Appointment> getUnassignedAppointments() {
        String sql = "SELECT * FROM appointments WHERE assigned_employee IS NULL";
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Appointment.class);
        return (List<Appointment>) query.getResultList();
    }

    public Optional<Appointment> find(String appointmentId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(new AppointmentId(appointmentId)));
    }

    @Override
    public Appointment assignEmployee(String appointmentId, Appointment appointment) {
        sessionFactory.getCurrentSession().saveOrUpdate(appointmentId,appointment);
        return sessionFactory.getCurrentSession().byId(aggregateClass).load(new AppointmentId(appointmentId));
    }

    @Override
    public Optional<List<Appointment>> findAssignedAppointmets(String employeeId) {
        ArrayList<Appointment> todos = (ArrayList<Appointment>) all().get();
        if(todos.isEmpty()){
            return Optional.of(new ArrayList<>());
        }
        ArrayList<Appointment> assigned = new ArrayList<>();
        for(Appointment a : todos){
            if(!a.getAssignedEmployee().isEmpty()){
                if(a.getAssignedEmployee().get().get("id").equals(employeeId)){
                    assigned.add(a);
                }
            }
        }
        return Optional.ofNullable(assigned);
    }

    @Override
    public void updateProperty(List<Appointment> appointments) {
        if(!appointments.isEmpty()){
            for(Appointment a : appointments){
                sessionFactory.getCurrentSession().saveOrUpdate(a);
                sessionFactory.getCurrentSession().flush();
                sessionFactory.getCurrentSession().clear();
            }
        }
    }

    @Override
    public void deleteForProperty(String propertyId) {
        ArrayList<Appointment> todos = (ArrayList<Appointment>) all().get();
        for(Appointment a : todos){
            if(!a.getAppointmentProperty().isEmpty()){
                if(a.getAppointmentProperty().get("id").equals(propertyId)){
                    sessionFactory.getCurrentSession().delete(a);
                    sessionFactory.getCurrentSession().flush();
                    sessionFactory.getCurrentSession().clear();
                }
            }
        }
    }

    @Override
    public void delete(Appointment appointment) {
        appointment = (Appointment) sessionFactory.getCurrentSession().merge(appointment);
        sessionFactory.getCurrentSession().delete(appointment);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<List<Appointment>> all() {

        String sql = "SELECT * FROM appointments";
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Appointment.class);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public List<Appointment> getExpiredAppointments() {
        String now= "'"+LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE)+"'";
        String sql = "SELECT * FROM appointments WHERE date_time < "+now;
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Appointment.class);
        return (List<Appointment>) query.getResultList();
    }

    @Override
    public Optional<List<Appointment>> findByProperty(String propertyId) {
        ArrayList<Appointment> todos = (ArrayList<Appointment>) all().get();
        if(todos.isEmpty()){
            return Optional.of(new ArrayList<>());
        }
        ArrayList<Appointment> updates = new ArrayList<>();
        for(Appointment a : todos){
            if(!a.getAppointmentProperty().isEmpty()){
                if(a.getAppointmentProperty().get("id").equals(propertyId)){
                    updates.add(a);
                }
            }
        }
        return Optional.ofNullable(updates);
    }

}
