$(document).ready(function () {
    /* Activa el menú de usuario desplegable de Materialize CSS */
    $(".dropdown-button").dropdown();
    
    $('.button-collapse').sideNav({
      menuWidth: 300, // Default is 240
      edge: 'right', // Choose the horizontal origin
      closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
    }
  );
    
    /* Permite el uso del control datepicker de Materialize CSS */
    $('.datepicker').pickadate({
        selectMonths:   true, // Creates a dropdown to control month
        selectYears: 21 // Creates a dropdown of 15 years to control year
    });
    
    $('#loginForm').submit(function(){
        if (!$('#nick').val().toString()){
            $('#lblNick').addClass('invalid');
            return false;
        }
        if (!$('#password').val().toString()){
            $('#lblPassword').addClass('invalid');
            return false;
        }
    });
    
    $('#signupForm').validate({
        rules:{
            nombre:{
                required: true,
                minlength: 5
            },
            apellido:{
                required: true,
                minlength: 5
            },
            email:{
                required: true,
                email: true
            },
            nickNew:{
                required: true,
                minlength: 5
            },
            passwordNew: {
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
        messages:{
            nombre: {
                required: "Ingrese su nombre",
                minlength: "5 caracteres como mínimo"
            },
            apellido: {
                required: "Ingrese su apellido",
                minlength: "5 caracteres como mínimo"
            },
            email:{
                required: "Ingrese su e-mail",
                email: "El formato del e-mail no es válido"
            },
            nickNew:{
                required: "Ingrese su nick",
                minlength: "5 caracteres como mínimo"
            },
            passwordNew: {
                required: "Ingrese su contraseña",
                minlength: "10 caracteres como mínimo"
            },
            telefono: {
                required: "Ingrese su teléfono"
            },
            fechanacimiento: {
                required: "Ingrese su fecha de nacimiento"
            }
            
        },
        errorElement: 'div',
        errorPlacement: function(error, errorElement){
            var placement = $(errorElement).data('error');
            $(placement).addClass('red-text');
            if (placement){
                $(placement).append(error);
            } else {
                error.insertAfter(errorElement);
            }
        }
    });
});