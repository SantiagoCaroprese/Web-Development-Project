package com.javeriana.web.project.Properties.Offer.Infrastructure.Hibernate;

import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Property.Domain.Property;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateOfferRepository implements OfferRepository {

    protected final SessionFactory sessionFactory;
    protected final Class<Offer> aggregateClass;

    public HibernateOfferRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = Offer.class;
    }


    @Override
    public void save(Offer offer) {
        sessionFactory.getCurrentSession().save(offer);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    @Override
    public Optional<Offer> find(String offerId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(new OfferId(offerId)));
    }

    @Override
    public Offer update(String offerId,Offer offer) {
        sessionFactory.getCurrentSession().update(offerId,offer);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
        return sessionFactory.getCurrentSession().byId(aggregateClass).load(new OfferId(offerId));
    }

    @Override
    public void delete(Offer offer) {
        sessionFactory.getCurrentSession().delete(offer);
    }

    @Override
    public Optional<List<String>> filter(int priceLowerLimit, int priceUpperLimit, String action) {
        List<String> ids = new ArrayList<>();
        List<Offer> offers = allAscending().get();
        //System.out.println(action);
        if(priceUpperLimit == 0 && priceLowerLimit == 0){
            priceUpperLimit = offers.get(0).getPrice().value();
            System.out.println(priceUpperLimit);
        }
        if(!action.equals("")){
            for(Offer o : offers){
                if(o.getAction().value().equals(action)){
                    if( priceLowerLimit <= o.getPrice().value() && o.getPrice().value() <= priceUpperLimit){
                        ids.add(o.getPropertyId().value());
                    }
                    //System.out.println(priceLowerLimit + " " + o.getPrice().value() + " " + priceUpperLimit);
                }
            }
        }else{
            for(Offer o : offers){

                    if( priceLowerLimit <= o.getPrice().value() && o.getPrice().value() <= priceUpperLimit){
                        ids.add(o.getPropertyId().value());
                    }
                    //System.out.println(priceLowerLimit + " " + o.getPrice().value() + " " + priceUpperLimit);

            }
        }




        return Optional.ofNullable(ids);
    }

    @Override
    public Optional<List<Offer>> all() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Offer");
        return Optional.ofNullable(query.list());
    }

    private Optional<List<Offer>> allAscending(){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Offer o ORDER BY o.price");
        return Optional.ofNullable(query.list());
    }

}