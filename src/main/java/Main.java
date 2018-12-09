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

        String user = "mama88";
        double productId = 54.0;

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

        for(ProductCart pc : productCartList){
            if(pc.getUsername().equals(user)){
                isUserExist = true;
                for(Product p : pc.getProducts()){
                    if(p.getProductId().equals(productId)){
                        isProductExistInCart = true;
                        p.setQuantity(p.getQuantity() + 1);
                    }
                }
                if(isProductExistInCart == false){
                    Product product = new Product();
                    product.setProductId(productId);
                    product.setQuantity(1.0);
                    List<Product> products = pc.getProducts();
                    products.add(product);
                    pc.setProducts(products);
                }
            }
        }

        if(isUserExist == false){
            ProductCart productCart = new ProductCart();
            productCart.setUsername(user);
            List<Product> products = new ArrayList<>();
            Product product = new Product();
            product.setProductId(productId);
            product.setQuantity(1.0);
            products.add(product);
            productCart.setProducts(products);
            productCartList.add(productCart);
        }

        String json = gson.toJson(productCartList, type);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
