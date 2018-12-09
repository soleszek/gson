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

        String user = "oleszek";
        double productId = 8.0;

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

        /*ProductCart productCart = new ProductCart();
        productCart.setUsername(user);

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId(productId);
        product.setQuantity(11.0);
        products.add(product);
        productCart.setProducts(products);
        productCartList.add(productCart);*/

        for(ProductCart pc : productCartList){
            if(pc.getUsername().equals(user)){
                isUserExist = true;
                Product product = new Product();
                for(Product p : pc.getProducts()){
                    if(p.getProductId().equals(productId)){
                        System.out.println(p);
                    }
                }
            }
        }

        /*String json = gson.toJson(productCartList, type);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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
