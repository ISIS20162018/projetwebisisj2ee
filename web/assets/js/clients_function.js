
var clientsModules = function () {

    //Création du module
    var self = {};

    self.displayAllClients = function () {
        //Création d'un module de display clients
        var mod = {};
        //Méthode pour le bouton qui fait la requête Ajax:
        mod.clickToDisplay = function () {
            $('#displayAllClients').click(function () {
                //Requête Ajax !
                $.ajax({
                    method: "GET",
                    url: "testdb",
                    data: {} //Comme le JSON
                }).success(function (response) {
                    //On récupère le JSON:
                    var render = "<table class='table'> <tr> <td>CODE</td> <td>NOM</td> <td>SOCIETE</td> </tr>";
                    
                        for(var i=0; i<response.length; i++){
                            render += "<tr> <td>"+response[i].code+"</td> <td>"+response[i].contact+"</td> <td>"+response[i].societe+"</td> </tr>";
                        }
                    render += "</table>";
                    $('.ajaxResponse').html(render);
                });

            });
        };
        
        mod.cleanDisplay = function(){
            $('#cleanClients').click(function() {
                 $('.ajaxResponse').html('');
            });
           
        };


        //On retourne le module de displayAllCLients
        return [
            mod.clickToDisplay(),
            mod.cleanDisplay()
        ];

    }();

    $(document).ready(function () {
        return self;
    });


}();