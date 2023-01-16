package tests;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BasketOnlineStore implements Basket{
        private List<Product> products = new ArrayList<>();
        private Product product;

        @Override
        public void addProduct(String product, int quantity) {
            products.add(new Product(product, quantity));
        }

        @Override
        public void removeProduct(String product) {
            for (int index = 0; index < products.size(); index++) {
                if (Objects.equals(products.get(index).getProduct(), product)) {
                    products.remove(index);
                    System.out.println("Продукт3 удален из списка");
                    return;
                }
            }
        }

        @Override
        public void updateProductQuantity(String product, int quantity) {
            for (int index = 0; index < products.size(); index++) {
                if (Objects.equals(products.get(index).getProduct(), product)) {
                    System.out.print("Изменен: ");
                    products.get(index).setProduct(product);
                    products.get(index).setQuantity(quantity);
                    return;
                }
            }
        }

        @Override
        public void clear() {
            products.clear();
        }

        @Override
        public List<String> getProductsList() {
            List<String> stringList = new ArrayList<>();
            for (Product product : products) {
                stringList.add(product.getProduct());
            }
            return stringList;
        }

        @Override
        public int getProductQuantity(String product) {
            for (Product product1 : products) {
                if (Objects.equals(product1.getProduct(), product)) {
                    return product1.getQuantity();
                }
            }
            return 0;
        }
    }
