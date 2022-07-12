/*
* Template Name: Catalogo Sistema
* Author: jose de leon
* License: https://securitymedicareapp.com/license/
*/
 var seccionMotivo = localStorage.getItem('SeccionMotivo');
 var seccionMunicipio = localStorage.getItem('SeccionMunicipio');
 var seccionNacionalidad = localStorage.getItem('SeccionNacionalidad');

console.log("seccionMotivo: "+seccionMotivo);
console.log("seccionMunicipio: "+ seccionMunicipio);
console.log("seccionNacionalidad: "+seccionNacionalidad);

window.onload = function loadPreviouspageState(){
    console.log("entering loadPreviouspageState");
    console.log("execute after load");
    if(seccionMotivo == 'true'){
        showSection('section-motivo-estado');
    }else if(seccionMunicipio ==  'true'){
        showSection('section-municipio');
    }else if(seccionNacionalidad == 'true'){
        showSection('section-nacionalidad');
    }
    console.log("existing loadPreviouspageState");
}

 function resetView(seccionMotivoIn, seccionMunicipioIn, seccionNacionalidadIn){

    if(seccionMotivoIn == 'false'){
     var element = document.getElementById("section-motivo-estado");
     element.style.display = "none";
     var elementLink = document.getElementById("motivo-table-link");
     elementLink.style.borderBottom ="";
    }

    if(seccionMunicipioIn == 'false'){
     var element = document.getElementById("section-municipio");
     element.style.display = "none";
     var elementLink = document.getElementById("municipio-table-link");
     elementLink.style.borderBottom ="";
    }

    if(seccionNacionalidadIn == 'false'){
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

      localStorage.setItem('SeccionMotivo', 'true');
      localStorage.setItem('SeccionMunicipio', 'false');
      localStorage.setItem('SeccionNacionalidad', 'false');

      if(localStorage.getItem('SeccionMotivo')){
        var element = document.getElementById("section-motivo-estado");
        element.style.display = "block";

        var elementLink = document.getElementById("motivo-table-link");
        elementLink.style.borderBottom ="solid 5px gray";
      }
    }

   if(nombreSeccion == 'section-municipio'){

      localStorage.setItem('SeccionMotivo', 'false');
      localStorage.setItem('SeccionMunicipio', 'true');
      localStorage.setItem('SeccionNacionalidad', 'false');

      if(localStorage.getItem('SeccionMunicipio')){
        var element = document.getElementById("section-municipio");
        element.style.display = "block";

        var elementLink = document.getElementById("municipio-table-link");
        elementLink.style.borderBottom ="solid 5px blue";
      }
    }

    if(nombreSeccion == 'section-nacionalidad'){

      localStorage.setItem('SeccionMotivo', 'false');
      localStorage.setItem('SeccionMunicipio', 'false');
      localStorage.setItem('SeccionNacionalidad', 'true');

      if(localStorage.getItem('SeccionNacionalidad')){
        var element = document.getElementById("section-nacionalidad");
        element.style.display = "block";

        var elementLink = document.getElementById("nacionalidad-table-link");
        elementLink.style.borderBottom ="solid 5px green";

      }
    }

    resetView(localStorage.getItem('SeccionMotivo'), localStorage.getItem('SeccionMunicipio'), localStorage.getItem('SeccionNacionalidad'));
    window.scrollTo(0, document.body.scrollHeight);
}