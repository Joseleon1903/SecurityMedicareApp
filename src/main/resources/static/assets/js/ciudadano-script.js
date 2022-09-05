
  $( ".menu-button-solicitud.btn.btn-primary" ).on( "click", function( event ) {
  console.log('entereing click buttom detail ');

  console.log('ciudadano Id : '+ $(this).data('text'));
  let ciudadanoId = $(this).data('text');

  var request = $.ajax({
    method: "GET",
    url: "/SecurityMedicareApp/api/ciudadano/"+ciudadanoId
  });

   request.done(function( msg ) {
      console.log('ciudadano encontrado success');

      var ciudadanoId = msg['ciudadanoId'];
      var cedula = msg['cedula'];
      var nss = msg['nss'];
      var nombre = msg['nombre'];
      var primerApellido = msg['primerApellido'];
      var segundoApellido = msg['segundoApellido'];
      var sexo = msg['genero'];
      var fechaNacimiento = new Date(msg['fechaNacimiento']);

      if(sexo == "F" ){
        sexo = "Femenino";
      }else if (sexo == "M"){
        sexo = "Masculino";
      }

      $("#ciudadanoIdDetail").val(ciudadanoId);

      $("#cedulaDetail").val(cedula);
      $("#nssDetail").val(nss);
      $("#nombreDetail").val(nombre);
      $("#primerApellidoDetail").val(primerApellido);
      $("#segundoApellidoDetail").val(segundoApellido);
      $("#sexoDetail").val(sexo);
      $("#fechaNacimientoDetail").val(fechaNacimiento.toLocaleDateString("en-US"));

      jQuery('#detail-modal-buttom').click();

    });

});


$(".menu-button-solicitud.btn.btn-danger" ).on( "click", function( event ) {
  console.log('entereing click buttom delete ');

  console.log('ciudadano Id : '+ $(this).data('text'));
  let ciudadanoId = $(this).data('text');

  var request = $.ajax({
    method: "DELETE",
    url: "/SecurityMedicareApp/api/ciudadano/delete/"+ciudadanoId
  });

  request.done(function( msg ) {
    console.log('ciudadano eliminado success');
    let htmlcontent = '<div class="section-header"> <span>Se ha eliminado el ciudadano '+ ciudadanoId+' de forma exitosa</span><h2>Se ha eliminado el ciudadano '+ ciudadanoId+' de forma exitosa</h2></div>';
    $( "#delete-modal-body" ).html(htmlcontent );
    jQuery('#delete-modal-buttom').click();
  });

  request.fail(function( jqXHR, textStatus ) {
      let htmlcontent = '<div class="section-header"> <span>Codigo error'+textStatus+' eliminado el ciudadano '+ ciudadanoId+'</span><h2>Codigo error'+textStatus+' eliminado el ciudadano '+ ciudadanoId+'</h2></div>';
        $( "#delete-modal-body" ).html(htmlcontent );
        jQuery('#delete-modal-buttom').click();
  });
  console.log('exiting click buttom delete ');
});

