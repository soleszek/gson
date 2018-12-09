import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("productId")
    @Expose
    private Double productId;

    @SerializedName("quantity")
    @Expose
    private Double quantity;

    public Product() {
    }

    public Product(Double productId, Double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Double getProductId() {
        return productId;
    }

    public void setProductId(Double productId) {
        this.productId = productId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
