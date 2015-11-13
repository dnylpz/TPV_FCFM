/**
 * Created by jose.espinoza.lopez on 11/10/2015.
 */

$(document).ready(function(){
    console.log($(".addform").children("#addproduct"));
    $(".addform").on("submit","#addproduct",function(e){
        e.preventDefault();
        console.log("you submited the form")
        console.log($("#articulo").val());
        var articulo = $("#articulo").val();
        $.post("agregaproducto",{articulo:articulo},function(response){
            console.log(response);
            $("#product-list").append(response);
        });
    });

    $("#closeSale").on("click",function(e){
        e.preventDefault();
        $.post("metododepago",{},function(response){

        });
    });
});