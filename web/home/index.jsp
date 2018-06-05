<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../partials/blank_header.jsp">
  <jsp:param name="title" value="Main title" />
</jsp:include>
  <div class="row">
    <div class="col-md-4" id="formTableDepartamento">
      <h5 class="subtitulo" style="margin-bottom:15px">Departamentos</h5>
      <label class="texto-der" id="mensajeRpta"></label>
      <table class="table table-striped" style="" id="tablaDepatartamento">
        <thead>
          <tr>
            <th style="width: 10px; display:none;">id</th>
            <th style="width: 250px;">Nombre</th>
            <th style="width: 80px;">Botones</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <td colspan="1000" style="text-align:right">
              <button class="btn btn-default agregar-fila"> <i class="fa fa-plus" style="margin-right:5px"></i>Agregar Registro</button>
              <button class="btn btn-default guardar-tabla"> <i class="fa fa-check" style="margin-right:5px"></i>Guardar Cambios</button>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
    <div class="col-md-4 oculto" id="formTableProvincia">
      <h5 class="subtitulo" style="margin-bottom:15px">Provncias</h5>
      <label class="texto-der" id="mensajeRptaProvincias"></label>
      <table class="table table-striped" style="" id="tablaProvincias">
        <thead>
          <tr>
            <th style="width: 10px; display:none;">id</th>
            <th style="width: 250px;">Nombre</th>
            <th style="width: 80px;">Botones</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <td colspan="1000" style="text-align:right">
              <button class="btn btn-default agregar-fila"> <i class="fa fa-plus" style="margin-right:5px"></i>Agregar Registro</button>
              <button class="btn btn-default guardar-tabla"> <i class="fa fa-check" style="margin-right:5px"></i>Guardar Cambios</button>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
    <div class="col-md-4 oculto" id="formTableDistrito">
      <h5 class="subtitulo" style="margin-bottom:15px">Distritos</h5>
      <label class="texto-der" id="mensajeRptaDistritos"></label>
      <table class="table table-striped" style="" id="tablaDistritos">
        <thead>
          <tr>
            <th style="width: 10px; display:none;">id</th>
            <th style="width: 250px;">Nombre</th>
            <th style="width: 80px;">Botones</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <td colspan="1000" style="text-align:right">
              <button class="btn btn-default agregar-fila"> <i class="fa fa-plus" style="margin-right:5px"></i>Agregar Registro</button>
              <button class="btn btn-default guardar-tabla"> <i class="fa fa-check" style="margin-right:5px"></i>Guardar Cambios</button>
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
<jsp:include page="../partials/blank_footer.jsp">
  <jsp:param name="title" value="Main title" />
</jsp:include>