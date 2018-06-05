package daos;

import java.util.ArrayList;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import models.Departamento;
import configs.Database;

public class DepartamentoDao extends Database{
  private Dao<Departamento,String> dao; 
  
  public DepartamentoDao() throws Exception{
    try {
      this.dao = DaoManager.createDao(this.connectionSource, Departamento.class);
    } catch (Exception e) {
      throw e;
    }
  }

  public String listar(){
    String rpta = "";
    try {
      Database conexion = new Database();
      ConnectionSource connectionSource = conexion.getConnectionSource();
      List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
      Dao<Departamento, String> departamentoDao = DaoManager.createDao(connectionSource, Departamento.class);
      QueryBuilder<Departamento, String> queryBuilder = departamentoDao.queryBuilder();
      PreparedQuery<Departamento> preparedQuery = queryBuilder.prepare();
      List<Departamento> departamentoList = departamentoDao.query(preparedQuery);
      for (Departamento departamento : departamentoList) {
        JSONObject obj = new JSONObject();
        obj.put("id", departamento.getId());
        obj.put("nombre", departamento.getNombre());
        rptaTemp.add(obj);
      }
      rpta = rptaTemp.toString();
    } catch (Exception e) {
      //e.printStackTrace();
      String[] error = {"Se ha producido un error en  listar los sistemas registrado", e.toString()};
      JSONObject rptaTry = new JSONObject();
      rptaTry.put("tipo_mensaje", "error");
      rptaTry.put("mensaje", error);
      rpta = rptaTry.toString();
    }
    return rpta;
  }
  
    public int crear(String nombre) throws Exception{
      int rpta = 0;
      try {
        Departamento departamento = new Departamento();
        departamento.setNombre(nombre);
        this.dao.create(departamento);
        rpta = departamento.getId();
      }catch (Exception e) {
        throw e;
      }
      return rpta;
    }

    public void editar(int id, String nombre) throws Exception{
      try {
        UpdateBuilder<Departamento, String> updateBuilder = this.dao.updateBuilder();
        updateBuilder.updateColumnValue("nombre", nombre);
        updateBuilder.where().eq("id", id);
        updateBuilder.update();
      }catch (Exception e) {
        throw e;
      }
    }

    public void eliminar(int id) throws Exception{
      try {
        DeleteBuilder<Departamento, String> deleteBuilder = this.dao.deleteBuilder();
        deleteBuilder.where().eq("id", id);
        deleteBuilder.delete();
      }catch (Exception e) {
        throw e;
      }
    }
}