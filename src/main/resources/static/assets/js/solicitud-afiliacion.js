

function showForm(element){
    var element = document.getElementById(element);
    element.style.display = "block";
}

function hideForm(element){
    var element = document.getElementById(element);
    element.style.display = "none";
}


function nextButton(formName){

    console.log("entering in nextButton");
    console.log("formName: "+ formName);

    if(formName == 'datos-ubicacion'){
       showForm(formName);
       hideForm("datos-solicitante");
       hideForm("datos-titular");
    }

    if(formName == 'datos-titular'){
       showForm(formName);
       hideForm("datos-solicitante");
       hideForm("datos-ubicacion");
    }

}