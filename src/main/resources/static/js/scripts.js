function actorSelected(select){
    //Seleccionando el index del item selcccionado
    let index = select.selectedIndex;
    //Obteniendo el elemento option
    let option = select.options[index];
    //Obteniendo el id desde el value
    let id = option.value
    //Obteniendo el nombre desde text
    let nombre = option.text;
    //Obteniendo la imagen desdd data-url
    let urlImagen = option.dataset.url

    //Para despues que se seleccione un actor de la lista del combo, se deshabilita para que ya no se pueda seleccionar nuevamente
    option.disabled = "disabled";
    //Aquí permite seleccionar un actor diferente
    select.selectedIndex = 0;

    //Agrega al actor
    agregarActor(id, nombre, urlImagen)

    //Obteniendo el id de cada actor desde la etiqueta input con id="ids"
    let ids = $("#ids").val();
    //Si ids es igual a vacío se agrega el id del actor, si no es vacío, se agrega el id, pero se concatena con ","
    if(ids == ""){
        $("#ids").val(id);
    } else {
        $("#ids").val(ids + "," + id);
    }
}

function agregarActor(id, nombre, urlImagen) {
    //Template de html para dibujar las imagenes de los actores
    let htmlString = `
        <div class="main-card card col-md-3 m-2">
            <img src="{URL-IMAGEN}" class="card-img-top">
            <div class="card-body d-flex flex-column align-items-center">
                <p class="card-text">{NOMBRE}</p>
                <button class="button-eliminar btn btn-danger" data-id="{ID}" onclick="eliminarActor(this); return false;">Eliminar</button>
            </div>
        </div>`;
    
    htmlString = htmlString.replace("{URL-IMAGEN}", urlImagen);
    htmlString = htmlString.replace("{NOMBRE}", nombre);
    htmlString = htmlString.replace("{ID}", id);

    //Agrega el template a el div del html
    $("#actores_container").append(htmlString);
}

function eliminarActor(btn){
    let id = btn.dataset.id;
    let node = btn.parentElement.parentElement;
    //Se tiene una lista de ids tipo: 1,2,3,4,5,...,n lo convierte en [1,2,3,4,5,...,n] y luego cambia a [1,2,3,5,...,n] suponiendo que el actor con id 4 fue el que se eliminó
    let array = $("#ids").val().split(",").filter(idActor => idActor != id);

    $("#ids").val(array.join(",")); //Esto hace que el array generado, despues de filtrar quedé como string de la siguiente manera "1,2,3,5,...,n"
    
    //Para habilitar la opcion del actor en el combo
    $("#actor option[value='" + id + "']").prop("disabled", false);
    //Quita al actor de los actores agregados del template
    $(node).remove();
}
