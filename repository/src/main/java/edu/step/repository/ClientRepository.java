package edu.step.repository;

import edu.step.model.Client;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;


@Getter
@Repository
public class ClientRepository {

    private static ClientRepository instance;
    private final Set<Client> clientSet;

    private ClientRepository(Set<Client> clientSet) {
        this.clientSet = clientSet;
    }

    public static ClientRepository getInstance(Set<Client> clientSet) {
        if (instance == null) {
            instance = new ClientRepository(new HashSet<>());
        }
        if (clientSet != null && !clientSet.isEmpty()) {
            instance = new ClientRepository(clientSet);
        }
        return instance;
    }

}

