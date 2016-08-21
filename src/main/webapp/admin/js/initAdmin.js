$(document).ready(function () {
    /* Activa los modals de Materialize CSS */
    $('.modal-trigger-add-juego').leanModal();
    $('.modal-trigger-add-usuario').leanModal();
    
    /* Activa los elementos select de un formulario con los estilos 
     * de Materialize CSS */
    $('select').material_select();
    
    /* Devuelve las categorías de un catálogo seleccionado */
    $("#listaCatalogos").change(function(){
        var infoCatalogo = {
            id : $(this).val()
        };
        $.post("ObtenerCategoriasCatalogo", $.param(infoCatalogo), function(response){
            $.each(response, function(index, categoria){
               console.log(categoria.nombre); 
            });
        });
        
    });
});