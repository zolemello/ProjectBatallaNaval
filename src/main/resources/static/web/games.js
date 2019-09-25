// AJAX REQUEST



//var variableData = document.getElementById("gamesInfo");


var str = JSON.stringify(data, null, 2)
var valor = JSON.parse(str)
var pro = document.getElementById("gamesInfo")
var tbody= document.createElement("tbody")
var arreglo = valor.results[0];


armarTabla(arreglo)

function armarTabla(data){ // Esta es la funcion de hacer la tabla
 
  var tabla="<thead class='thead-dark'><tr><th class='text-center'>Creation Date</th></tr></thead>"

  for (let i=0;i<data.length;i++){
  
     tabla +="<tr>" // Agrega una fila por cada vuelta

    tabla+="<td><a "+data[i].id+"></a></td>"
}
   

  //  tabla+="<td>"+" "+data[i]+" "+"</td>"
   
    // tabla+="<td>"+" "+data[i]+ "+"</td></tr>"

//

// tbody.appendChild(tabla)

// pro.appendChild(tbody)

pro.innerHTML=tabla
}



function loadData() {
        $.get("/api/games")
            .done(function(data) {
                armarTabla(data);
            })
            .fail(function( jqXHR, textStatus ) {
                alert( "ERROR!!!! "+ " " + textStatus );
            });
    }

    loadData();
});



/*

$(function() {

    // display list

    function updateList(data) {
        let htmlList = data.map(function (games) {
            return  '<li>' + new Date(games.created).toLocaleString() + ' ' + games.gamePlayers.map(function(p) { return p.player.email}).join(', ')  +'</li>';
        }).join('');
        document.getElementById("gameInfo").innerHTML = htmlList;
    }

    // load and display JSON sent by server for /api/games

    function loadData() {
        $.get("/api/games")
            .done(function(data) {
                updateList(data);
            })
            .fail(function( jqXHR, textStatus ) {
                alert( "Failed:" + textStatus );
            });
    }

    loadData();
});

/*