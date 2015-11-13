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
            if(total!=null) {
                $(".product").removeClass("hidden");
                var htm = "<h2 class='three columns'> $" + total + "</h2>"
                $("#totalOut").children().remove();
                $("#totalOut").html(htm);
            }else{
                $("#product-list").children(".sResults").remove();
                $(".resultlist").html(response);
                $(".sResults").removeClass("hidden");
                $(".add").on("click",function(res){
                    var upc = $(this).attr("itemId");
                    $(".resultlist").children().remove();
                    $.post("agregaproducto",{articulo:upc},function(res){
                        $("#product-list").append(res);
                        var selector = "#totalIn"+count;
                        var total = $(selector).val();
                        $(".product").removeClass("hidden");
                        var htm = "<h2 class='three columns'> $" + total + "</h2>"
                        $("#totalOut").children().remove();
                        $("#totalOut").html(htm);
                    });
                });
            }
        });
    });
    $("#closeSale").on("click",function(e){
        e.preventDefault();
        $.post("formadepago",{},function(response){
            $(".metodos").html(response);
            $(".main").addClass("inactive");
        });
        $("#fpago").on("submit",function(e){
            e.preventDefault();
            alert("Usted ha completado una venta");
            $(this).submit();
        });
    });
});