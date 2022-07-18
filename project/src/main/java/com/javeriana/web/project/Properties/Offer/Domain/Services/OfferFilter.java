package com.javeriana.web.project.Properties.Offer.Domain.Services;

import com.javeriana.web.project.Properties.Offer.Domain.Exeptions.NoOffersFoundException;
import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;


import java.util.List;
import java.util.Optional;

public class OfferFilter {

    private OfferRepository repository;

    public OfferFilter(OfferRepository repository) {
        this.repository = repository;
    }

    public Optional<List<String>> execute(int priceLowerLimit, int priceUpperLimit, String action) {

            Optional<List<String>> propiedades = repository.filter(priceLowerLimit,priceUpperLimit, action);

            if(propiedades.get().isEmpty()){
                throw new NoOffersFoundException("No se encontraron propiedades con los parametros de oferta especificados");
            }

        return propiedades;
    }
}
