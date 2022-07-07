/*
* Template Name: Catalogo Sistema
* Author: jose de leon
* License: https://securitymedicareapp.com/license/
*/
 var seccionMotivo = false;
 var seccionMunicipio = false;
 var seccionNacionalidad = false;

 function resetView(seccionMotivoIn, seccionMunicipioIn, seccionNacionalidadIn){

    if(seccionMotivoIn == false){
     var element = document.getElementById("section-motivo-estado");
     element.style.display = "none";
     var elementLink = document.getElementById("motivo-table-link");
     elementLink.style.borderBottom ="";
    }

    if(seccionMunicipioIn == false){
     var element = document.getElementById("section-municipio");
     element.style.display = "none";
     var elementLink = document.getElementById("municipio-table-link");
     elementLink.style.borderBottom ="";
    }

    if(seccionNacionalidadIn == false){
     var element = document.getElementById("section-nacionalidad");
     element.style.display = "none";
     var elementLink = document.getElementById("nacionalidad-table-link");
     elementLink.style.borderBottom ="";
    }
 }

 function showSection(nombreSeccion){
    console.log("entrando en function showSection");
    console.log("param: "+ nombreSeccion);

    if(nombreSeccion == 'section-motivo-estado'){

      seccionMotivo= true;
      seccionMunicipio = false;
      seccionNacionalidad = false;

      if(seccionMotivo){
        var element = document.getElementById("section-motivo-estado");
        element.style.display = "block";

        var elementLink = document.getElementById("motivo-table-link");
        elementLink.style.borderBottom ="solid 5px gray";
      }
    }

   if(nombreSeccion == 'section-municipio'){

      seccionMotivo= false;
      seccionMunicipio = true;
      seccionNacionalidad = false;

      if(seccionMunicipio){
        var element = document.getElementById("section-municipio");
        element.style.display = "block";

        var elementLink = document.getElementById("municipio-table-link");
        elementLink.style.borderBottom ="solid 5px blue";
      }
    }

    if(nombreSeccion == 'section-nacionalidad'){

      seccionMotivo= false;
      seccionMunicipio = false;
      seccionNacionalidad = true;

      if(seccionNacionalidad){
        var element = document.getElementById("section-nacionalidad");
        element.style.display = "block";

        var elementLink = document.getElementById("nacionalidad-table-link");
        elementLink.style.borderBottom ="solid 5px green";

      }
    }

    resetView(seccionMotivo, seccionMunicipio, seccionNacionalidad);
    window.scrollTo(0, document.body.scrollHeight);
}