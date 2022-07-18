package com.javeriana.web.project.Properties.Offer.Application.filterOffers;

import com.javeriana.web.project.Properties.Offer.Domain.Ports.OfferRepository;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferDomainFinder;
import com.javeriana.web.project.Properties.Offer.Domain.Services.OfferFilter;

import java.util.List;

public class FilterOffers {
    OfferRepository repository;
    OfferFilter filter;

    public FilterOffers(OfferRepository repository) {
        this.repository = repository;
        this.filter = new OfferFilter(repository);
    }


    public List<String> execute(int priceLowerLimit, int priceUpperLimit, String action) {
        return filter.execute(priceLowerLimit,priceUpperLimit,action).get();
    }
}
