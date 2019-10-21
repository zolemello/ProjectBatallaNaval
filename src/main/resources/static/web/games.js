// AJAX REQUEST
$(function() {

  // display text in the output area
  function showOutput(text) {
  $("#gameInfo").text(text);

  }

  // load and display JSON sent by server for /api/game

  function loadData() {
    $.get("/api/game")
    .done(function(data) {
      showOutput(JSON.stringify(data, null, 2));
    })
    .fail(function( jqXHR, textStatus ) {
      showOutput( "Error: NO FUNCA " + textStatus );
    });
  }

  loadData();
});


