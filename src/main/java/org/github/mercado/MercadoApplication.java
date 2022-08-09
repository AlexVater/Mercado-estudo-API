package org.github.mercado;

import org.github.mercado.entity.Client;
import org.github.mercado.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MercadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercadoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client("Cliente 1"));
            clientRepository.save(new Client("Cliente 2"));

            clientRepository.getAll().forEach(System.out::println);

            clientRepository.getAll().forEach(client -> {
                        client.setName(client.getName() + " - Atualizado");
                        clientRepository.update(client);
                    }
            );

            clientRepository.findByName("Clien").forEach(System.out::println);

            clientRepository.getAll().forEach(client -> {
                        clientRepository.delete(client.getId());
                    }
            );

            clientRepository.getAll().forEach(System.out::println);

        };
    }
}
