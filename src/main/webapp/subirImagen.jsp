<%-- 
    Archivo que muestra un formulario que nos permite subir una imagen 
    a traves de un servlet para testear la API de Cloudinary
    Author     : Ojeda Alberto Daniel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="POST" action="SubirImagenTest" enctype="multipart/form-data">
            <p><input type="file" name="cover"/></p>
            <input type="submit" value="Subir imagen"/>
        </form>
    </body>
</html>
