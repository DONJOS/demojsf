<%-- 
    Document   : index
    Created on : 23-jul-2020, 16:45:18
    Author     : Administrador
--%>

<%@page import="persona.Registro"%>
<%@page import="persona.Documento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/js/all.min.js" type="text/javascript"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="row" id="cabecera">

        </div>
        <div id="contenedor">
            <jsp:useBean id="datos" scope="request" class="persona.Persona" />

            <form action="Persona" method="post">
                <div class="form-row">
                    <div class="col-md-6 mb-3">
                        <label for="Server01">Nombres</label>
                        <input type="text" class="form-control" id="validationServer01" name="nombres" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="Server02">Apellidos</label>
                        <input type="text" class="form-control" id="validationServer02" name="apellidos" required>
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                </div>
                <div class="form-row">

                    <div class="col-md-6 mb-3">
                        <label for="validationServer04">Tipo documento</label>
                        <select class="custom-select" id="validationServer04" name="tipoDocumento" required>
                            <% out.println(datos.getselect()); %>
                        </select>

                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="validationServer05">Numero documento</label>
                        <input type="numeric" class="form-control" id="validationServer05"  name="numeroDocumento" required>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit">Enviar</button>
            </form>
            <div class="mt-5">
                <table class="table table-sm table-bordered">            
                    <thead>
                        <tr> 
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Tipo Documento</th>
                            <th>Documento</th>
                            <th>Accion</th>
                        </tr>
                    </thead> 

                    <tbody>
                        <% // out.println(session.getAttribute("html"));%> 
                    
                    <% // out.println(datos.registros.length);
                        if (session.getAttribute("registros") != null) {
                            Registro registros[] = (Registro[]) session.getAttribute("registros");
                            Registro reg;
                            String html = "";
                            for (int i = 0; i < 10; i++) {
                                reg = registros[i];
                                //out.println(reg.getId());
                                if (reg != null && reg.getNombres() != null) { %>
                    <tr>
                        <td> <% out.print(reg.getId()); %></td>
                        <td><% out.print(reg.getNombres()); %></td>
                        <td><% out.print(reg.getApellidos()); %></td>
                        <td><%  out.print(reg.getTipoDocumento()); %></td>
                        <td><%  out.print(reg.getNumeroDocumento()); %></td>
                        <td><a href="index.jsp?edit=<%  out.print(reg.getId()); %>" ><i class="fa fa-edit text-info"></i>Editar</a> &nbsp; | &nbsp;
                            <a href="index.jsp?delete=<%  out.print(reg.getId()); %>masss" class="fa fa-trash">Eliminar</a>
                        </td>

                    </tr>

                    <%
                                }
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="pie">

        </div>

    </body>
</html>
