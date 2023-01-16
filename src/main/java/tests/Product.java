package tests;



    public class Product {
        private final String product;
        private final int quantity;

        public Product(String product, int quantity) {
            this.product =  product;
            this.quantity = quantity;
        }

        public String getProduct() {
            return product;
        }
        public int getQuantity() {
            return quantity;
        }

        public void setProduct(String product) {
            System.out.print(product + " ");;
        }

        public void setQuantity(int quantity) {
            System.out.println(quantity);
        }


    }
