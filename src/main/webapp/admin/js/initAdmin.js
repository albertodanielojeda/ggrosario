$(document).ready(function () {
    /* Activa los modals de Materialize CSS */
    $('.modal-trigger-add-juego').leanModal();
    $('.modal-trigger-add-usuario').leanModal();

    /* Activa los elementos select de un formulario con los estilos 
     * de Materialize CSS */
    $('select').material_select();

    /* Devuelve las categorías de un catálogo seleccionado */
    $("#listaCatalogos").change(function () {
        var infoCatalogo = {
            id: $(this).val()
        };
        $.post("ObtenerCategoriasCatalogo", $.param(infoCatalogo), function (response) {
            $.each(response, function (index, categoria) {
                console.log(categoria.nombre);
            });
        });

    });

    $(this).on("click", "a.editar-nombre-catalogo", function () {
        var nombreActual = $(this).parent().parent().children().first().html();
        $(this).parent().parent().children().first().html("<div class='input-field col s12'> <input placeholder='" + nombreActual + "' id='nuevo-nombre-catalogo' type='text' class='validate'> <label for='first_name'>Nuevo nombre del catálogo</label> </div>");
        $("#nuevo-nombre-catalogo").focus();
        $(this).parent().html("<a class='cambiar-nombre-catalogo' href='#!'><i class='material-icons left'>save</i>Guardar</a>");
    });

    $(this).on("click", "a.cambiar-nombre-catalogo", function () {
        var mensaje;
        var parametrosCatalogo = {
            id: $(this).parent().parent().attr('id'),
            nuevoNombre: $('input#nuevo-nombre-catalogo').val()
        };
        $(this).parent().html("<p>Guardando...<div class='progress'> <div class='indeterminate'></div> </div></p>");
        $.post("cambiar-nombre-catalogo", $.param(parametrosCatalogo), function (respuesta) {
            mensaje = respuesta;
            location.reload();
        }).done(function(){
            Materialize.toast(mensaje, 3000);
        }).fail(function () {
            window.location.replace("../errores/403");
        });;
    });

    $(this).on("click", "a.eliminar-catalogo", function () {
        var parametrosCatalogo = {
            id: $(this).parent().parent().attr('id')
        };
        $(this).parent().html("<p>Eliminando...<div class='progress'> <div class='indeterminate'></div> </div></p>");
        $.post("eliminar-catalogo", $.param(parametrosCatalogo), function (respuesta) {
            location.reload();
            Materialize.toast(respuesta, 3000);
        });
    });
});