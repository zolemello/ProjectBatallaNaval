// AJAX REQUEST

var data;
var url = "/api/game"  // ESto es de donde saca los datos ?

var request = {
    method: 'GET',
    body: JSON.stringify(data),
};

fetch(url, request)
    .then(response => response.json())
    .then(data => {
        console.log('test');
        var gameHTML = getListHtml(data);
           document.getElementById("game").innerHTML = gameHTMÑ;
    })
    .catch(error => {
        console.log(error);
    })

    function 
