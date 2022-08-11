package org.github.mercado.repository;

import org.github.mercado.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Transactional
    Client saveClient(Client client);

    @Transactional
    Client updateClient(Client client);

    @Transactional
    void deleteClient(Integer id);

    @Transactional(readOnly = true)
    List<Client> findByName(String name);

    List<Client> getAllClient();
}
