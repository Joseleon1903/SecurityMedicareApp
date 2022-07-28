
  $( ".menu-button-solicitud.btn.btn-primary" ).on( "click", function( event ) {
  console.log('entereing click buttom detail ');

  console.log('solicitud Id : '+ $(this).data('text'));
  let solicitud = $(this).data('text');

   jQuery('#detail-modal-buttom').click();

 });