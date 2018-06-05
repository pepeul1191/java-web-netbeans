package servlets.home;

import helpers.HomeHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexHomeServlet extends HttpServlet {
   private HomeHelper helper;
  
  public IndexHomeServlet(){
    this.helper = new HomeHelper();
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    request.setAttribute("name", "Hussein Teresk");
    request.setAttribute("css", this.helper.indexCSS());
    request.setAttribute("js", this.helper.indexJS());
    request.setAttribute("base_url", this.helper.getConfValue("base_url"));
    request.setAttribute("static_url", this.helper.getConfValue("static_url"));
    request.setAttribute("title", "Home");
    request.getRequestDispatcher("home/index.jsp").forward(request, response);
  }
}
