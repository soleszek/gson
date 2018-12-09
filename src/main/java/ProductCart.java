import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductCart {
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("products")
    @Expose
    private List<Product> products = null;

    public ProductCart() {
    }

    public ProductCart(String username, List<Product> products) {
        this.username = username;
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductCart{" +
                "username='" + username + '\'' +
                ", products=" + products +
                '}';
    }
}

