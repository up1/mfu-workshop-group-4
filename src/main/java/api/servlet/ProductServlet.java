package api.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/hello")
public class ProductServlet extends HttpServlet {

                // JDBC driver name and database URL
                static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                static final String DB_URL="jdbc:mysql://localhost/3300/wallet";
          
                //  Database credentials
                static final String USER = "root";
                static final String PASS = "1234";
				private Object product;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        Product product = new Product();
        product.setId("0007");
        product.setWallet(1500.00);
        product.setProductName("Coco");
        product.setPrice(55.00);
        product.setCurrentMoney(1445.00);
        product.setFee(1.00);


        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), product);

      
}

class Product {
    private String id;
    private String productName;
    private Double price;
    private Double currentMoney;
    private Double fee;
    private Double wallet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(Double currentMoney){
        this.currentMoney = currentMoney;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee){
        this.fee = fee;
    }

    public Double getWAllet() {
        return wallet;
    }

    public void setWallet(Double wallet){
        this.wallet = wallet;
    }
}
}
