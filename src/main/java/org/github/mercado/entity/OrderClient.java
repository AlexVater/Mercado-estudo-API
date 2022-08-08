package org.github.mercado.entity;

import sun.util.resources.LocaleData;

import java.math.BigDecimal;

public class OrderClient {

    private Integer id;
    private Client client;
    private LocaleData orderData;
    private BigDecimal total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocaleData getOrderData() {
        return orderData;
    }

    public void setOrderData(LocaleData orderData) {
        this.orderData = orderData;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
