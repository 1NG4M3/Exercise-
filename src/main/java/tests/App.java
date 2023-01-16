package tests;

public class App {
    public static void main(String[] args) {
        BasketOnlineStore basketOnlineStore = new BasketOnlineStore();
        basketOnlineStore.addProduct("Продукт1", 100);
        basketOnlineStore.addProduct("Продукт2", 1000);
        basketOnlineStore.addProduct("Продукт3", 850);
        basketOnlineStore.addProduct("Продукт4", 12000);

        for (String product : basketOnlineStore.getProductsList()) {
            System.out.println(product + " " + basketOnlineStore.getProductQuantity(product));
        }

        basketOnlineStore.removeProduct("Продукт3");
        basketOnlineStore.updateProductQuantity("Продукт2", 999);

        for (String product : basketOnlineStore.getProductsList()) {
            System.out.println(product + " " + basketOnlineStore.getProductQuantity(product));
        }
    }
}
