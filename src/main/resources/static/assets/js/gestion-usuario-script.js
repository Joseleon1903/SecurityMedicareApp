
$( ".menu-button-solicitud.btn.btn-warning" ).on( "click", function( event ) {
    console.log('entereing click buttom detail ');

    console.log('usuario Id : '+ $(this).data('text'));
    let usuarioId = $(this).data('text');

    var request = $.ajax({
    method: "GET",
    url: "/SecurityMedicareApp/api/usuario/"+usuarioId
    });

    request.done(function( msg ) {
         console.log('solicitud encontrado success: '+msg);

         var profileUrl = msg['profilePicture'];
         console.log('profileUrl: '+ profileUrl);

         var usuarioId = msg['usuarioId'];
         var codigo = msg['codigo'];
         var tipoUsuarioId = msg['tipoUsuarioId'].tipoUsuarioId;
         var descripcionTipoUsuario = msg['tipoUsuarioId'].descripcion;
         var contactoId = msg['contactoId'].contactoId;
         var descripcionContacto = msg['contactoId'].descripcion;
         var correoPrimario = msg['contactoId'].correoPrimario;
         var posicion = msg['contactoId'].posicion;
         var estado = msg['estado'];

         $("#usuarioIdDetail").val(usuarioId);
         $("#codigoDetail").val(codigo);
         $("#tipoUsuarioIdDetail").val(tipoUsuarioId);
         $("#descripcionTipoUsuarioDetail").val(descripcionTipoUsuario);
         $("#contactoIdDetail").val(contactoId);
         $("#descripcionContactoDetail").val(descripcionContacto);
         $("#correoPrimarioDetail").val(correoPrimario);
         $("#posicionDetail").val(posicion);
         $("#estadoDetail").val(estado);

         $("#profileUrlDetail").attr("src",profileUrl);

         jQuery('#detail-modal-buttom').click();
    });


 });