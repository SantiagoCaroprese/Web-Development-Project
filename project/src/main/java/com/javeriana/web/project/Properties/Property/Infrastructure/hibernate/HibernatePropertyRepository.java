package com.javeriana.web.project.Properties.Property.Infrastructure.hibernate;

import com.javeriana.web.project.Properties.Property.Domain.Property;
import com.javeriana.web.project.Properties.Property.Domain.Ports.PropertyRepository;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.*;
import com.javeriana.web.project.Properties.Property.Domain.ValueObjects.PropertyId;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional("transactional-manager")
public class HibernatePropertyRepository  implements PropertyRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Property> aggregateClass;

    public HibernatePropertyRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Property.class;
    }

    @Override
    public void save(Property property) {
        sessionFactory.getCurrentSession().save(property);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Property> find(String propertyId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(new PropertyId(propertyId)));
    }

    @Override
    public Optional<List<Property>> filter(List<String> idPropiedades, String propertyType, String city,
                                 int bedRoomsNumber, int bathRoomNumber, String propertyCondition) {

        List<Property> prop = new ArrayList<>();
        List<Property> todas = all().get();
        List<Property> res;

        //System.out.println(propertyType+city+bedRoomsNumber+bathRoomNumber+propertyCondition+idPropiedades.size());
        //System.out.println(idPropiedades);
        if(!idPropiedades.isEmpty()){
            for(Property p : todas ){
                if(idPropiedades.contains(p.getPropertyId().value())){
                    prop.add(p);
                }
            }
        }else{
            prop = todas;
        }




        if(!propertyType.equals("")){
            prop =  prop.stream().filter(property -> property.getPropertyType().value().equals(propertyType)).collect(Collectors.toList());
        }


        if(!propertyCondition.equals("")) {
            prop = prop.stream().filter(property -> property.getCondition().value().equals(propertyCondition)).collect(Collectors.toList());
        }

        System.out.println(prop.size());
        res =  prop.stream().filter(property -> property.getCity().value().equals(city))
        .filter(property -> property.getBedroomsNumber().value() >= bedRoomsNumber)
        .filter(property -> property.getBathroomsNumber().value() >= bathRoomNumber).collect(Collectors.toList());


        System.out.println(res.size());
        return Optional.ofNullable(res);
    }

    @Override
    public Optional<List<Property>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Property");
        return Optional.ofNullable(query.list());
    }

    public void update(String propertyId, Property property) {
        sessionFactory.getCurrentSession().update(propertyId,property);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    public void delete(Property property){
        sessionFactory.getCurrentSession().delete(property);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

}
