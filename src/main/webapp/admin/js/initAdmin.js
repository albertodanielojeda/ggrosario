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
        }).done(function () {
            Materialize.toast(mensaje, 3000);
        }).fail(function () {
            window.location.replace("../errores/403");
        });
        ;
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

    /* Validación de entrada de datos para agregar un nuevo usuario */
    $('#signupForm').validate({
        rules: {
            nombre: {
                required: true,
                minlength: 5
            },
            apellido: {
                required: true,
                minlength: 5
            },
            email: {
                required: true,
                email: true
            },
            nick: {
                required: true,
                minlength: 5
            },
            password: {
                required: true,
                minlength: 10
            },
            telefono: {
                required: true
            },
            fechanacimiento: {
                required: true,
                date: true
            }
        },
        messages: {
            nombre: {
                required: "Ingrese un nombre",
                minlength: "5 caracteres como mínimo"
            },
            apellido: {
                required: "Ingrese un apellido",
                minlength: "5 caracteres como mínimo"
            },
            email: {
                required: "Ingrese un e-mail",
                email: "El formato del e-mail no es válido"
            },
            nick: {
                required: "Ingrese un nick",
                minlength: "5 caracteres como mínimo"
            },
            password: {
                required: "Ingrese una contraseña",
                minlength: "10 caracteres como mínimo"
            },
            telefono: {
                required: "Ingrese un teléfono"
            },
            fechanacimiento: {
                required: "Ingrese una fecha de nacimiento"
            }

        },
        errorElement: 'div',
        errorPlacement: function (error, errorElement) {
            var placement = $(errorElement).data('error');
            $(placement).addClass('red-text');
            if (placement) {
                $(placement).append(error);
            } else {
                error.insertAfter(errorElement);
            }
        }
    });


    /* Validación de entrada de datos para agregar un nuevo catálogo */
    $('#formNuevoCatalogo').validate({
        rules: {
            nombreCatalogo: {
                required: true,
                minlength: 3
            }
        },
        messages: {
            nombreCatalogo: {
                required: "Ingrese un nombre para el catálogo",
                minlength: "3 caracteres como mínimo"
            }
        },
        errorElement: 'div',
        errorPlacement: function (error, errorElement) {
            var placement = $(errorElement).data('error');
            $(placement).addClass('red-text');
            if (placement) {
                $(placement).append(error);
            } else {
                error.insertAfter(errorElement);
            }
        }
    });

    /* Validación de entrada de datos para agregar un nuevo rol */
    $('#formNuevoRol').validate({
        rules: {
            nombreRol: {
                required: true,
                minlength: 3
            }
        },
        messages: {
            nombreRol: {
                required: "Ingrese un nombre para el rol",
                minlength: "3 caracteres como mínimo"
            }
        },
        errorElement: 'div',
        errorPlacement: function (error, errorElement) {
            var placement = $(errorElement).data('error');
            $(placement).addClass('red-text');
            if (placement) {
                $(placement).append(error);
            } else {
                error.insertAfter(errorElement);
            }
        }
    });


    /* Nueva regla para validar la selección de una categoría al momento de 
     * agregar un nuevo juego */
    $.validator.addMethod("selectedValue", function (value, element, arg) {
        return arg !== value;
    }, "El valor no puede ser igual al argumento");


    /* Validación de entrada de datos para agregar un nuevo juego */
    $('#formNuevoJuego').validate({
        rules: {
            nombre: {
                required: true,
                minlength: 5
            },
            descripcion: {
                required: true
            },
            precio: {
                required: true
            },
            stock: {
                required: true
            },
            listaCatalogos: {
                required: true,
                selectedValue: ""
            },
            cover: {
                required: true
            },
            minOS: {
                required: true
            },
            recOS: {
                required: true
            },
            minCPU: {
                required: true
            },
            recCPU: {
                required: true
            },
            minRAM: {
                required: true
            },
            recRAM: {
                required: true
            },
            minGPU: {
                required: true
            },
            recGPU: {
                required: true
            },
            minHDD: {
                required: true
            },
            recHDD: {
                required: true
            }
        },
        messages: {
            nombre: {
                required: "Ingrese un nombre",
                minlength: "5 caracteres como mínimo"
            },
            descripcion: {
                required: "Ingrese una descripción"
            },
            precio: {
                required: "Ingrese un precio"
            },
            stock: {
                required: "Ingrese la cantidad actual en stock"
            },
            listaCatalogos: {
                required: "Seleccione una categoría",
                selectedValue: "Seleccione un catálogo para el juego"
            },
            cover: {
                required: "Ingrese una imagen de portada"
            },
            minOS: {
                required: "Ingrese un sistema operativo"
            },
            recOS: {
                required: "Ingrese un sistema operativo"
            },
            minCPU: {
                required: "Ingrese un CPU"
            },
            recCPU: {
                required: "Ingrese un CPU"
            },
            minRAM: {
                required: "Ingrese una cantidad de memoria RAM"
            },
            recRAM: {
                required: "Ingrese una cantidad de memoria RAM"
            },
            minGPU: {
                required: "Ingrese una placa de video"
            },
            recGPU: {
                required: "Ingrese una placa de video"
            },
            minHDD: {
                required: "Ingrese la capacidad del disco rígido"
            },
            recHDD: {
                required: "Ingrese la capacidad del disco rígido"
            }

        },
        errorElement: 'div',
        errorPlacement: function (error, errorElement) {
            var placement = $(errorElement).data('error');
            $(placement).addClass('red-text');
            if (placement) {
                $(placement).append(error);
            } else {
                error.insertAfter(errorElement);
            }
        }
    });

    /* Confirmar canje de una reserva */
    $(this).on("click", "a.confirmar-canje", function () {
        var parametrosReserva = {
            idR: $('p.res').attr('id'),
            idU: $('p.user').attr('id')
        };
        $(this).parent().html("<p>Confirmando canje...<div class='progress'> <div class='indeterminate'></div> </div></p>");
        $.post("confirmar-canje-reserva", $.param(parametrosReserva), function (respuesta) {
            Materialize.toast(respuesta, 3000);
        });
    });
});