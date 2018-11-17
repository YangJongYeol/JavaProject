package Model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> productList;
    private boolean delivery;
    private String address;

    public Order(boolean delivery, String address) {
        this.productList = new ArrayList<>();
        this.delivery = delivery;
        this.address = address;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
