package api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/wallet")
public class CheckMoneyServlet extends HttpServlet {



class CheckMoney {

    private String id;
    private String name;
    private String cerrentmoney;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCerrent() {
        return cerrentmoney;
    }

    public void setCerrent(String string) {
        this.cerrentmoney = cerrentmoney;
    }
}
}