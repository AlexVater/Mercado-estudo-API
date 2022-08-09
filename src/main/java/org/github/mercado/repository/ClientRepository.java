package org.github.mercado.repository;

import org.github.mercado.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepository {

    private static String INSERT = "INSERT INTO CLIENT (NAME) VALUES (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENT";
    private static String UPDATE = "UPDATE CLIENT SET NAME = ? WHERE ID = ?";
    private static String DELETE = "DELETE FROM CLIENT WHERE ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save(Client client) {
        jdbcTemplate.update(INSERT, client.getName());
        return client;
    }

    public Client update(Client client) {
        jdbcTemplate.update(UPDATE, client.getName(), client.getId());
        return client;
    }

    public void delete(Integer id) {
        jdbcTemplate.update(DELETE, id);
    }

    public List<Client> findByName(String name) {
        return jdbcTemplate.query(
                SELECT_ALL.concat(" WHERE NAME LIKE ?"),
                new Object[]{"%" + name + "%"},
                getClientRowMapper());
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(SELECT_ALL, getClientRowMapper());
    }

    private RowMapper<Client> getClientRowMapper() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("ID");
                String name = rs.getString("NAME");
                return new Client(id, name);
            }
        };
    }
}
