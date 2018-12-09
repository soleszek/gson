import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        String file = "/home/sylwester/Dokumenty/projekty/sklep/test-ok.json";

        String user = "juzyt";
        double productId = 111.0;

        List<ProductCart> productCartList = new ArrayList<>();

        Type type = new TypeToken<ArrayList<ProductCart>>(){}.getType();

        InputStream is = new FileInputStream(file);

        if(is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            productCartList = gson.fromJson(reader, type);
        }

        boolean isUserExist = false;
        boolean isProductExistInCart = false;

        ProductCart productCart = new ProductCart();
        productCart.setUsername(user);

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId(productId);
        product.setQuantity(11.0);
        products.add(product);
        productCart.setProducts(products);
        productCartList.add(productCart);

        String json = gson.toJson(productCartList, type);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*for(Map.Entry<String, ProductsInCart> s : map.entrySet()){
            if(s.getKey().equals(user)){
                isUserExist = true;
                Product productInCart = s.getValue().getProductsInCarts().get(0);
                System.out.println(productInCart);
                for(Product l : productsInCart.getProductInCarts()){
                    System.out.println(s);
                }
            }
        }*/

        /*for(Map.Entry<String, List<Product>> s : map.entrySet()) {

            if (s.getKey().equals(user)) {
                isUserExist = true;
                userList = s.getValue();
                System.out.println(userList.get(3));
                for(Product l : userList){
                    if(l.getProductId() == productId){
                        *//*isProductExistInCart = true;
                        l.setQuantity(l.getQuantity() + 1);*//*
                    }

                }
            }
        }*/

                /*if(isProductExistInCart == false){
                    map.get(user).add(new Product(productId, 1));
                }*/

        /*if(isUserExist == false){
            List<Product> newClientsCart = new ArrayList<>();
            newClientsCart.add(new Product(productId, 1));
            map.put(user, newClientsCart);
        }*/

        /*List<Product> productsInCart = new ArrayList<Product>();

        Product productInCart1 = new Product(1l, 1);
        Product productInCart2 = new Product(2l, 2);
        Product productInCart3 = new Product(3l, 1);

        productsInCart.add(productInCart1);
        productsInCart.add(productInCart2);
        productsInCart.add(productInCart3);

        map.put("soleszek", productsInCart);

        List<Product> productsInCart2 = new ArrayList<Product>();

        Product productInCart4 = new Product(4l, 10);
        Product productInCart5 = new Product(5l, 3);
        Product productInCart6 = new Product(6l, 66);
        Product productInCart7 = new Product(7l, 1);
        Product productInCart8 = new Product(8l, 8);
        Product productInCart9 = new Product(9l, 87);
        Product productInCart10 = new Product(10l, 3);

        productsInCart2.add(productInCart4);
        productsInCart2.add(productInCart5);
        productsInCart2.add(productInCart6);
        productsInCart2.add(productInCart7);
        productsInCart2.add(productInCart8);
        productsInCart2.add(productInCart9);
        productsInCart2.add(productInCart10);

        map.put("koleszek", productsInCart2);


        String json = gson.toJson(map, Map.class);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/


            //System.out.println(map);
    }

}
