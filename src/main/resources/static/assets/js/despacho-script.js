
$( ".menu-button-solicitud.btn.btn-warning" ).on( "click", function( event ) {
    console.log('entereing click buttom detail ');

    console.log('solicitud Id : '+ $(this).data('text'));
    let solicitudId = $(this).data('text');

    var request = $.ajax({
    method: "GET",
    url: "/SecurityMedicareApp/api/solicitud/afiliacion/detail/"+solicitudId
    });

    request.done(function( msg ) {
         console.log('solicitud encontrado success');

       var solicitudId = msg['solicitudId'];
       var entidadNombre = msg['entidadNombre'];
       var tipoAfiliado  = msg['tipoAfiliado'];
       var tipoDependiente = msg['tipoDependiente'];
       var cedula = msg['cedula'];
       var nss = msg['nss'];
       var nombre = msg['nombre'];
       var primerApellido = msg['primerApellido'];
       var segundoApellido = msg['segundoApellido'];
       var institucionPensionado = msg['institucionPensionado'];
       var estado = msg['estado'] ;
       var motivo = msg['motivo'];
       var descripcionEstado = msg['descripcionEstado'];


       $("#solicitudIdDetail").val(solicitudId);
       $("#cedulaDetail").val(cedula);
       $("#nssDetail").val(nss);
       $("#nombreDetail").val(nombre);
       $("#primerApellidoDetail").val(primerApellido);
       $("#segundoApellidoDetail").val(segundoApellido);
       $("#tipoAfiliadoDetail").val(tipoAfiliado);

       $("#tipoDependienteDetail").val(tipoDependiente);
       $("#institucionPensionadoDetail").val(institucionPensionado);
       $("#entidadDetail").val(entidadNombre);
       $("#estadoDetail").val(estado);
       $("#motivoDetail").val(motivo);
       $("#estadoDescripcionDetail").text(descripcionEstado);
       $("#motivoDescripcionDetail").text(motivo);

       if(estado == "RE"){
          console.log("removiendo visibilidad descripcion motivo");
          var element = document.getElementById("motivoDescripcionDetail");
          element.style.display = "inline";
       }

       if(estado == "PE" || estado == "OK" ){
          console.log("habilitando visibilidad descripcion motivo");
          var element = document.getElementById("motivoDescripcionDetail");
          element.style.display = "none";
       }
      jQuery('#detail-modal-buttom').click();
    });


 });