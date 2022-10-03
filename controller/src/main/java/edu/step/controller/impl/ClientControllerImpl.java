package edu.step.controller.impl;

import edu.step.controller.ClientController;
import edu.step.model.Client;
import edu.step.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    public Client findOne(Long id) {
        return clientService.findOne(id);
    }

    @Override
    public Set<Client> findAll() {
        return clientService.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientService.save(client);
    }

    @Override
    public void remove(Long id) {
        clientService.remove(id);
    }

//    @Override
//    public Long getAmountOfClients() {
//        return (long) clientService.findAll().size();
//    }
//
//    @Override
//    public Set<Client> sortByPrice() {
//        return clientService.findAll()
//                .stream()
//                .sorted(Comparator.comparing(client -> client.getTariff().getPrice()))
//                .collect(Collectors.toCollection(LinkedHashSet::new));
//    }
//
//    @Override
//    public Tariff foundTariff(Double price, Integer minutes) {
//        return clientService
//                .findAll()
//                .stream()
//                .filter(client -> client.getTariff().getPrice().equals(price)
//                        && client.getTariff().getMinutes().equals(minutes))
//                .findFirst().orElseThrow(
//                        () -> new RuntimeException("Client not found")
//                ).getTariff();
//    }
}
