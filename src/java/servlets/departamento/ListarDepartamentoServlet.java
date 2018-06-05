package servlets.departamento;

import daos.DepartamentoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class ListarDepartamentoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      String rpta = "";
      DepartamentoDao departamentoDao = new DepartamentoDao();
      try {
        rpta = departamentoDao.listar();
      }catch (Exception e) {
        String[] error = {"Se ha producido un error en  listar los departamentos registrados", e.toString()};
        JSONObject rptaTry = new JSONObject();
        rptaTry.put("tipo_mensaje", "error");
        rptaTry.put("mensaje", error);
        rpta = rptaTry.toString();
      } finally {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(rpta);
      }
  }
}
