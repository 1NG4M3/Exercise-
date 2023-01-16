package tests;

import java.util.List;

public interface Basket {
    void addProduct(String product, int quantity);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProductsList();

    int getProductQuantity(String product);

}
