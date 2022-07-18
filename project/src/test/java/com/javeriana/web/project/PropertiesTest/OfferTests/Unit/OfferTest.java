package com.javeriana.web.project.PropertiesTest.OfferTests.Unit;

import com.javeriana.web.project.Properties.Offer.Application.CreateOffer.OfferCreator;
import com.javeriana.web.project.Properties.Offer.Application.DeleteOffer.OfferDeleter;
import com.javeriana.web.project.Properties.Offer.Application.UpdateOffer.OfferModifier;
import com.javeriana.web.project.Properties.Offer.Domain.Offer;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Action;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.OfferId;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.Price;
import com.javeriana.web.project.Properties.Offer.Domain.ValueObjects.PropertyId;
import com.javeriana.web.project.Properties.Property.Application.Find.PropertyFinder;
import com.javeriana.web.project.Shared.Bus.Event.EventBus;
import com.javeriana.web.project.Shared.Domain.Offers.OfferActionEnum;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OfferTest {


    @Test
    void should_create_rent_offer(){
        OfferRepository repository=mock(OfferRepository.class);
        EventBus eventBus=mock(EventBus.class);
        PropertyFinder propertyFinder=mock(PropertyFinder.class);
        OfferCreator offerCreator= new OfferCreator(repository,eventBus,propertyFinder);
        Offer offer = new Offer(new OfferId("4a229224-759d-4234-8871-ef352ca516ce"),new PropertyId("4a229224-759d-4234-8871-ef352ca516cf"),new Price(10000),new Action("RENT"));
        offerCreator.execute("4a229224-759d-4234-8871-ef352ca516ce","4a229224-759d-4234-8871-ef352ca516cf",10000,"RENT");
        verify(repository, atLeastOnce()).save(offer);
    }

    @Test
    void should_create_sale_offer(){
        OfferRepository repository=mock(OfferRepository.class);
        EventBus eventBus=mock(EventBus.class);
        PropertyFinder propertyFinder=mock(PropertyFinder.class);
        OfferCreator offerCreator= new OfferCreator(repository,eventBus,propertyFinder);
        Offer offer = new Offer(new OfferId("4a229224-759d-4234-8871-ef352ca516ce"),new PropertyId("4a229224-759d-4234-8871-ef352ca516cf"),new Price(10000),new Action("SALE"));
        offerCreator.execute("4a229224-759d-4234-8871-ef352ca516ce","4a229224-759d-4234-8871-ef352ca516cf",10000,"SALE");
        verify(repository, atLeastOnce()).save(offer);
    }

    @Test
    void should_modify_offer(){
        Offer offer = new Offer(new OfferId("4a229224-759d-4234-8871-ef352ca516ce"),new PropertyId("4a229224-759d-4234-8871-ef352ca516cf"),new Price(10000),new Action("RENT"));
        Offer offerEdited = new Offer(new OfferId("4a229224-759d-4234-8871-ef352ca516ce"),new PropertyId("4a229224-759d-4234-8871-ef352ca516cf"),new Price(2000000),new Action("RENT"));
        OfferRepository repository=mock(OfferRepository.class);
        Mockito.when(repository.find("4a229224-759d-4234-8871-ef352ca516ce")).thenReturn(Optional.of(offer));
        EventBus eventBus=mock(EventBus.class);
        OfferModifier offerModifier=new OfferModifier(repository,eventBus);
        offerModifier.execute("4a229224-759d-4234-8871-ef352ca516ce",2000000,"4a229224-759d-4234-8871-ef352ca516cf");
        verify(repository,atLeastOnce()).update("4a229224-759d-4234-8871-ef352ca516ce",offerEdited);
    }

    @Test
    void should_delete_offer(){
        Offer offer = new Offer(new OfferId("4a229224-759d-4234-8871-ef352ca516ce"),new PropertyId("4a229224-759d-4234-8871-ef352ca516cf"),new Price(10000),new Action("RENT"));
        OfferRepository repository=mock(OfferRepository.class);
        Mockito.when(repository.find("4a229224-759d-4234-8871-ef352ca516ce")).thenReturn(Optional.of(offer));
        EventBus eventBus=mock(EventBus.class);
        OfferDeleter offerDeleter=new OfferDeleter(repository,eventBus);
        offerDeleter.execute("4a229224-759d-4234-8871-ef352ca516ce","4a229224-759d-4234-8871-ef352ca516cf");
        verify(repository,atLeastOnce()).delete(offer);
    }
}
