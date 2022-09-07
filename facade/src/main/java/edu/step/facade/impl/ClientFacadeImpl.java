package edu.step.facade.impl;

import edu.step.facade.ClientFacade;
import edu.step.model.Client;
import edu.step.model.Tariff;
import edu.step.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ClientFacadeImpl implements ClientFacade {

    private final ClientService clientService;

    @Override
    public Long getAmountOfClients() {
        return (long) clientService.findAll().size();
    }

    @Override
    public Set<Client> sortByPrice() {
        return clientService.findAll()
                .stream()
                .sorted(Comparator.comparing(client -> client.getTariff().getPrice()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public Tariff foundTariff(Double price, Integer minutes) {
        return clientService
                .findAll()
                .stream()
                .filter(client -> client.getTariff().getPrice().equals(price)
                        && client.getTariff().getMinutes().equals(minutes))
                .findFirst().orElseThrow(
                () -> new RuntimeException("Client not found")
        ).getTariff();
    }
}
