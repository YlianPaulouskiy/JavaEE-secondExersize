package edu.step.view;

import edu.step.dao.impl.ClientDaoImpl;
import edu.step.facade.ClientFacade;
import edu.step.facade.impl.ClientFacadeImpl;
import edu.step.model.*;
import edu.step.model.parent.BaseModel;
import edu.step.repository.ClientRepository;
import edu.step.service.ClientService;
import edu.step.service.impl.ClientServiceImpl;

import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class View {

    public void view() {
        while (true) {
            System.out.println(getMainMenu());
            try {
                Scanner scanner = new Scanner(System.in);
                Number choice = scanner.nextInt();
                if (choice.equals(0)) break;
                foundOperation(choice);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }


    }

    private String getMainMenu() {
        return "Главное меню:\n" +
                "0) выход\n" +
                "1) Вывести клиента по id\n" +
                "2) Вывести всех клиентов\n" +
                "3) Добавить клиента\n" +
                "4) Удалить клиента\n" +
                "5) Количество всех клиентов\n" +
                "6) Отсортировать клиентов по стоимости тарифа\n" +
                "7) Найти соотствующий тариф\n";
    }

    private Long getNum() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLong();
    }

    private String getLine() {
        Scanner scn = new Scanner(System.in);
        return scn.nextLine();
    }

    private Long getId() {
        ClientService service = new ClientServiceImpl(new ClientDaoImpl(ClientRepository.getInstance(null)));
        Optional<Client> optionalClient = service.findAll().stream().max(Comparator.comparing(BaseModel::getId));
        return optionalClient.map(client -> client.getId() + 1).orElse(1L);
    }

    private Client getClient() {
        Client client = new Client();

        client.setId(getId());

        System.out.println("Введите номер");
        client.setNumber(getLine());
        System.out.println("Выберите тариф");
        showTariffs();
        client.setTariff(choiceTariff(getNum()));
        System.out.println("Запонлните личные данные");
        client.setPerson(getPerson());

        return client;
    }

    private Person getPerson() {
        Person person = new Person();
        System.out.println("Введите имя");
        person.setName(getLine());
        System.out.println("Введите Фамилию");
        person.setLastName(getLine());
        System.out.println("Введите возраст");
        person.setAge(getNum().intValue());
        return person;
    }

    private void showTariffs() {
        System.out.println(
                "1) Безлимит звонков\n" +
                        "2) Безлимит интернета\n" +
                        "3) Легкий\n"
        );
    }

    private Tariff choiceTariff(Number choice) {
        try {
            switch (choice.intValue()) {
                case 1:
                    return new UnlimitedCallsTariff();
                case 2:
                    return new UnlimitedInternetTariff();
                case 3:
                    return new EasyTariff();
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    private void foundOperation(Number choice) {
        ClientService service = new ClientServiceImpl(new ClientDaoImpl(ClientRepository.getInstance(null)));
        ClientFacade facade = new ClientFacadeImpl(service);
        switch (choice.intValue()) {
            case 1:
                System.out.println(service.findOne(getNum()));
                break;
            case 2:
                System.out.println(service.findAll());
                break;
            case 3:
                service.save(getClient());
                break;
            case 4:
                System.out.println("Введите id клиента, которого нужно удалить");
                service.remove(getNum());
                break;
            case 5:
                System.out.println("Всего клиентов = " + facade.getAmountOfClients());
                break;
            case 6:
                System.out.println("Отсортированно по цене: ");
                System.out.println(facade.sortByPrice());
                break;
            case 7:
                System.out.println("введите цену и количество минут");
                facade.foundTariff(getNum().doubleValue(), getNum().intValue());
        }
    }
}
