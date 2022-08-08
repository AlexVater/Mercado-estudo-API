package org.github.mercado.entity;

public class OrderItem {

    private Integer id;
    private OrderClient orderClient;
    private Product product;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderClient getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
