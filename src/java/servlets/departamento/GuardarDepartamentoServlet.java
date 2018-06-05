package servlets.departamento;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.j256.ormlite.misc.TransactionManager;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;
import daos.DepartamentoDao;
import java.util.concurrent.Callable;

public class GuardarDepartamentoServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String rpta = "";
    JSONObject data = new JSONObject(request.getParameter("data"));
    JSONArray nuevos = data.getJSONArray("nuevos");
    JSONArray editados = data.getJSONArray("editados");
    JSONArray eliminados = data.getJSONArray("eliminados");
    List<JSONObject> listJSONNuevos = new ArrayList<JSONObject>();
    boolean error = false;
    String execption = "";
    try {
      DepartamentoDao departamentoDao = new DepartamentoDao();
      TransactionManager.callInTransaction(departamentoDao.getConnectionSource(),
        new Callable<Void>() {
          public Void call() throws Exception {
            if(nuevos.length() > 0){
              for (int i = 0; i < nuevos.length(); i++) {
                JSONObject departamento = nuevos.getJSONObject(i);
                String antiguoId = departamento.getString("id");
                String nombre = departamento.getString("nombre");
                int nuevoId = departamentoDao.crear(nombre);
                JSONObject temp = new JSONObject();
                temp.put("temporal", antiguoId);
                temp.put("nuevo_id", nuevoId);
                listJSONNuevos.add(temp);
              }
            }
            if(editados.length() > 0){
              for (int i = 0; i < editados.length(); i++) {
                JSONObject departamento = editados.getJSONObject(i);
                int id = departamento.getInt("id");
                String nombre = departamento.getString("nombre");
                departamentoDao.editar(id, nombre);
              }
            }
            if(eliminados.length() > 0){
              for (Object eliminado : eliminados) {
                int eleminadoId = (Integer)eliminado;
                departamentoDao.eliminar(eleminadoId);
              }
            }
            return null;
         };
      }); 
    }catch (Exception e) {
      error = true;
      execption = e.toString();
    } finally {
      //departamentoDao.close();
    }
    if(error){
      String[] cuerpoMensaje = {"Se ha producido un error en  guardar los departamento", execption};
      JSONObject rptaMensaje = new JSONObject();
      rptaMensaje.put("tipo_mensaje", "error");
      rptaMensaje.put("mensaje", cuerpoMensaje);
      rpta = rptaMensaje.toString();
    }else{
      String[] cuerpoMensaje = {"Se ha registrado los cambios en los departamentos", listJSONNuevos.toString()};
      JSONObject rptaMensaje = new JSONObject();
      rptaMensaje.put("tipo_mensaje", "success");
      rptaMensaje.put("mensaje", cuerpoMensaje);
      rpta = rptaMensaje.toString();
    }
    response.setContentType("text/html;charset=UTF-8");
    response.getWriter().write(rpta);
  }
}
