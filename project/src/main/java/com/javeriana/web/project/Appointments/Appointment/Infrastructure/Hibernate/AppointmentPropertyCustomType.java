package com.javeriana.web.project.Appointments.Appointment.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javeriana.web.project.Appointments.Appointment.Domain.ValueObjects.AppointmentProperty;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Objects;

public class AppointmentPropertyCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return AppointmentProperty.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        AppointmentProperty response = null;
        try {
            String value = rs.getString(names[0]);
            HashMap<String, Object> mapper = new ObjectMapper().readValue(value, HashMap.class);
            response = new AppointmentProperty((String) mapper.get("propertyId"), (String) mapper.get("address"), (String) mapper.get("propertyType"), (String) mapper.get("city"), ((Number) mapper.get("latitude")).longValue(), ((Number) mapper.get("longitude")).longValue());
        } catch (Exception e) {
            throw new HibernateException("Error reading map");
        }
        return response;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        AppointmentProperty property = (AppointmentProperty) value;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String serializedObject = mapper.writeValueAsString(property);
            st.setString(index, serializedObject);
        } catch (Exception e) {
            throw new HibernateException("Error serializing value " + value, e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
