package Model;

import java.util.List;

public class Order {
    private List<Product> productList;
    private boolean delivery;

    public Order(Product product, boolean delivery) {
        productList.add(product);
        this.delivery = delivery;
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
}
