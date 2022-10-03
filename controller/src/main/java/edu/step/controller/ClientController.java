package edu.step.controller;

import edu.step.model.Client;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public interface ClientController {

    @GetMapping
    Client findOne(@RequestParam Long id);

    @GetMapping("/all")
    Set<Client> findAll();

    @PostMapping("/save")
    Client save(@RequestBody Client client);

    @DeleteMapping("/remove")
    void remove(@RequestParam Long id);

//    @GetMapping("/client_amount")
//    Long getAmountOfClients();
//
//    @GetMapping("/sort_by_price")
//    Set<Client> sortByPrice();
//
//    @GetMapping("/found_tariff")
//    Tariff foundTariff(@RequestParam Double price,
//                       @RequestParam Integer minutes);

}
