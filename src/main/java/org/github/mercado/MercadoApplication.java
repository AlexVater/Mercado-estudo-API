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
            clientRepository.saveClient(new Client("João"));
            clientRepository.saveClient(new Client("Maria"));

            clientRepository.findByName("João").forEach(System.out::println);

            clientRepository.updateClient(new Client(1, "João - Atualizado"));

            clientRepository.deleteClient(2);

            clientRepository.getAllClient().forEach(System.out::println);
        };
    }
}
