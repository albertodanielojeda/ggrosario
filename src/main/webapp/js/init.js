$(document).ready(function () {
    /* Activa el menú de usuario desplegable de Materialize CSS */
    $(".dropdown-button").dropdown();
    
    /* Permite el uso del control datepicker de Materialize CSS */
    $('.datepicker').pickadate({
        selectMonths:   true, // Creates a dropdown to control month
        selectYears: 21 // Creates a dropdown of 15 years to control year
    });
});