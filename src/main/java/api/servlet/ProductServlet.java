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

@WebServlet("/product")
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
                // String docType =
                // "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
                // out.println(docType +
                // "<html>\n" +
                // "<head><title>" + productName + "</title></head>\n" +
                // "<body bgcolor = \"#f0f0f0\">\n" +
                // "<h1 align = \"center\">" + price + "</h1>\n");

                try {
                    // Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");
           
                    // Open a connection
                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
           
                    // Execute SQL query
                    Statement stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT * FROM wallet.cart";
                    ResultSet rs = stmt.executeQuery(sql);
                    // Extract data from result set

         while(rs.next()){
            //Retrieve by column name
            Product product = new Product();
            product.setId(rs.getString("0007"));
            product.setProductName(rs.getString("Coco"));
            product.setPrice(rs.getDouble("55.00"));
                }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), product);

        // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
     } catch(SQLException se) {
        //Handle errors for JDBC
        se.printStackTrace();
     } catch(Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
     } finally {
        //finally block used to close resources

    }
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

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet){
        this.wallet = wallet;
    }
}
}
}
