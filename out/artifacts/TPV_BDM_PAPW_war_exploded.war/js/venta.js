/**
 * Created by jose.espinoza.lopez on 11/10/2015.
 */

$(document).ready(function(){
    var count = 0;
    console.log($(".addform").children("#addproduct"));
    $(".addform").on("submit","#addproduct",function(e){
        e.preventDefault();
        console.log("you submited the form")
        console.log($("#articulo").val());
        var articulo = $("#articulo").val();
        $.post("agregaproducto",{articulo:articulo},function(response){
            count++;
            console.log(response);
            $("#product-list").append(response);
            var selector = "#totalIn"+count;
            var total = $(selector).val();
            var htm = "<h2 class='three columns'>$"+ total + "</h2>";
            $("#totalOut").children().remove();
            $("#totalOut").html(htm);
        });
    });
});