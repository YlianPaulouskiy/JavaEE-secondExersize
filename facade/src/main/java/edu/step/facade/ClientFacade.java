package edu.step.facade;

import edu.step.model.Client;
import edu.step.model.Tariff;

import java.util.Set;

public interface ClientFacade {

    Long getAmountOfClients();

    Set<Client> sortByPrice();

    Tariff foundTariff(Double price, Integer minutes);

}
