<%-- 
    Document   : index
    Created on : 13 sept. 2016, 16:38:54
    Author     : Fabien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/materialize.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <script   src="https://code.jquery.com/jquery-2.2.4.min.js"   integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="   crossorigin="anonymous"></script>
        <script src="./assets/js/materialize.min.js"></script>
        <script src="./assets/js/clients_function.js"></script>
        <title>Notre application Javascript - Clients</title>
    </head>
    <body>

        <header>
            <nav>
                <div class="nav-wrapper green">
                    <a href="#" class="brand-logo right">Leslie & Fabien</a>
                    <ul id="nav-mobile" class="left hide-on-med-and-down">
                        <li><a href="#">Tableau de bord</a></li>
                        <li><a href="#">A propos</a></li>
                    </ul>
                </div>
            </nav>
        </header>

        <!-- Sidebar -->
        <ul id="nav-mobile" class="side-nav fixed">
            <li class="logo">
                <span class="green-text">Bienvenue</span>
            </li>
            <li class="bold"><a href="Client.jsp" class="waves-effect waves-teal">Clients</a></li>
            <li class="bold"><a href="#" class="waves-effect waves-teal">Produits</a></li>
            <li class="bold"><a href="#" class="waves-effect waves-teal">Commandes</a></li>
        </ul>

        <div class="padding-300" id="container">
            
        </div>


        <script type="text/javascript">
            $('.button-collapse').sideNav({
                menuWidth: 300, // Default is 240
                edge: 'right', // Choose the horizontal origin
                closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
            }
            );
        </script>

    </body>
</html>
