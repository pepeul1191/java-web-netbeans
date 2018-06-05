 var Departamento = Backbone.Model.extend({
  defaults: {
    nombre: '',
    id: 'E',
  },
  initialize: function() {
  },
  toString: function(){
    return "Departamento { id: " +  this.get("id") + " - " + "nombre: '" + this.get("nombre") + "' }";
  },
});

var DepartamentosCollection = Backbone.Collection.extend({
  model: Departamento,
});
  
 var TablaDepatartamentoView = TableView.extend({
  initialize: function(options){
    // herencia de atributos, móetodos y eventos
    TableView.prototype.initialize.apply(this, [options])
    this.inheritEvents(TableView);
    // delegación de eventos
    this.delegateEvents();
  },
  events: {
    // se está usando asignacion dinamica de eventos en el constructor
    "click i.ver-provincia": "verProvincias",
  },
  verProvincias: function(event){
    var departamentoId = event.target.parentElement.parentElement.firstChild.innerHTML;
    //urlListar: BASE_URL + "provincia/listar/" + departamentoId,
    provinciaTable.urlListar = BASE_URL + "provincia/listar/" + departamentoId;
    provinciaTable.el.classList.remove("oculto");
    provinciaTable.limpiarBody();
    provinciaTable.listar();
    provinciaTable.extraData = {departamento_id: departamentoId};
    distritoTable.limpiarBody();
    distritoTable.el.classList.add("oculto");
  },
});

var departamentoTable = new TablaDepatartamentoView({
  el: "#formTableDepartamento",
  idTable: "tablaDepatartamento",
  targetMensaje: "mensajeRpta",
  mensajes: {
    errorListarAjax: "Error en listar los datos del servidor",
    errorGuardarAjax: "Error en guardar los datos en el servidor",
    success: "Se cargado guardo los cambios en los departamentos",
  },
  urlListar: BASE_URL + "departamento/listar",
  urlGuardar: BASE_URL + "departamento/guardar",
  fila: {
    id: { // llave de REST
      tipo: "td_id",
      estilos: "color: blue; display:none",
      edicion: false,
    },
    nombre: { // llave de REST
      tipo: "text",
      estilos: "width: 250px;",
      edicion: true,
    },
    filaBotones: {
      estilos: "width: 80px"
    },
  },
  filaBotones: [
    {
      tipo: "i",
      claseOperacion: "ver-provincia",
      clase: "fa-list",
      estilos: "padding-left: 5px;",
    },
    {
      tipo: "i",
      claseOperacion: "quitar-fila",
      clase: "fa-times",
      estilos: "padding-left: 10px;",
    },
  ],
  collection: new DepartamentosCollection(),
  model: "Departamento",
});
departamentoTable.listar();