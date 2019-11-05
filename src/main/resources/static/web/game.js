/*$(function() {
     loadData();
 });

 */
 $(function () {

     // parametros de URL
     const urlParams = new URLSearchParams(window.location.search);
     let salvoLocationsEnemy= [];
     // encabezados de la grilla
     let numbers = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"];
     let letters = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"];

     // posiciones de todos los barcos del jugador
     let shipLocations = [];

     const colorHit = "red";

     // posiciones de todos los salvos lanzados
     let salvoLocations = [];

     // genera el HTML de los encabezados de la grilla
     function getHeadersHtml(headers) {
         return "<tr><th></th>" + headers.map(function (header) {
             return "<th>" + header + "</th>";
         }).join("") + "</tr>";
     }

     // dibuja los encabezados
     function renderHeaders(numbersId) {
         var html = getHeadersHtml(numbers);
         document.getElementById(numbersId).innerHTML = html;
     }

     // genera el HTML de las columnas
     function getColumnsHtmlForShips(i, locations, color) {
         let html = "";
         //debugger;
         for (let j = 0; j < numbers.length; j++) {
             let cellColor = "lightblue";
             let text= "";
             for (let k = 0; k < locations.length; k++) {
                 if (locations[k] == letters[i] + numbers[j]) {
                     //debugger
                     cellColor = color;
                     for(let l = 0; l< salvoLocationsEnemy.length; l ++) {
                         if(salvoLocationsEnemy[l].location == letters[i] + numbers[j]){
                             cellColor = colorHit;
                         }
                     }
                 }
             }
             html = html + "<td style='background-color: " + cellColor + "'></td>";
         }
         return html;
     }


     // genera el HTML de las columnas
     function getColumnsHtmlForSalvo(i, locations, color) {
         let html = "";
         for (let j = 0; j < numbers.length; j++) {
             let cellColor = "lightblue";
             let text= "";
             for (let k = 0; k < locations.length; k++) {
                 if (locations[k].location == letters[i] + numbers[j]) {
                     cellColor = color;
                     text= locations[k].turno;
                 }
             }
             html = html + "<td style='background-color: " + cellColor + "'>"+text+"</td>";
         }
         return html;
     }

     // genera el HTML de las filas (depende de getColumnsHtml)
     function getRowsHtml(locations, color, functionToRender) {
         let html = "";
         for (let i = 0; i < letters.length; i++) {
             html = html + "<tr><th>" + letters[i] + "</th>" + functionToRender(i, locations, color) + "</tr>";
         }
         return html;
     }

     // dibuja las filas de la grilla
     function renderRows(locations, rowsId, color, functionToRender) {
         var html = getRowsHtml(locations, color, functionToRender);
         document.getElementById(rowsId).innerHTML = html;
     }

     // dibuja la grilla de barcos
     function renderShipTable(shipLocations) {
         renderHeaders("ship-grid-numbers");
         renderRows(shipLocations, "ship-grid-rows", "darkblue", getColumnsHtmlForShips);
     }

     // dibuja la grilla de salvos
     function renderSalvoTable(salvoLocations) {
         renderHeaders("salvo-grid-numbers");
         renderRows(salvoLocations, "salvo-grid-rows", "red", getColumnsHtmlForSalvo);
     }

     // muestra los datos de los jugadores de la partida
     function showPlayersData(data) {
         let thisPlayer;
         let otherPlayer;
         let gamePlayer1 = data.gamePlayers[0];
         let gamePlayer2 = data.gamePlayers[1];
         // según el ID del gameplayer actual asigna thisPlayer al jugador correspondiente, otherPlayer al contrincante
         if (gamePlayer1.id == urlParams.get('gp')) {
             thisPlayer = gamePlayer1.player.firstName;
             otherPlayer = gamePlayer2.player.firstName;

         } else {
             thisPlayer = gamePlayer2.player.firstName;
             otherPlayer = gamePlayer1.player.firstName;
         }
         document.getElementById("players-data").innerHTML = "You:" + thisPlayer + " vs Your Adversary:  " + otherPlayer;
     }

     // recibe los datos del gameplayer y setea en el array locations las posiciones de todos los barcos del jugador
     function setShipLocations(data) {
         //debugger
         mappedLocations = data.ships.map(function (ship) {
             return ship.locations
         });
         shipLocations = [].concat.apply([], mappedLocations);



     }

     // recibe los datos del gameplayer y setea en el array locations las posiciones de todos los salvos lanzados
     function setSalvoLocations(data) {
         mappedLocations = data.salvoes.map(function (salvo) {
             let valueToReturn = [];
             salvo.locations.forEach((item, index ) => {
                 valueToReturn.push({location: item, turno: salvo.turn});
             });
             return valueToReturn;
        });
         salvoLocations = [].concat.apply([], mappedLocations);


     }

     function setSalvoLocationsEnemy(data) {
         mappedLocations = data.enemySalvoes.map(function (salvo) {
             let valueToReturn = [];
             salvo.locations.forEach((item, index ) => {
                 valueToReturn.push({location: item, turno: salvo.turn});
             });
             return valueToReturn;
         });
         salvoLocationsEnemy = [].concat.apply([], mappedLocations);
     }

     // carga los datos del gameplayer según el parámetro 'gp' en la URL y llama a los métodos que dibujan la grilla
     function loadData() {
         $.get("/api/gameplayer/game_view/" + urlParams.get('gp'))
             .done(function (data) {
                 debugger;
                 setShipLocations(data);
                 setSalvoLocations(data);
                 setSalvoLocationsEnemy(data);
                 showPlayersData(data);
                 renderShipTable(shipLocations);
                 renderSalvoTable(salvoLocations);
             })
             .fail(function (jqXHR, textStatus) {
                 alert("NO FUNCA! :(  " + textStatus);
                 // renderTable();
             });
     }

     loadData();

 });

