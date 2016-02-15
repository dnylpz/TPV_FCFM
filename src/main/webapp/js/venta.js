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
            var selector = ".totalIn";
            var total = $(selector).last().val();
            if(total!=null) {
                var exists =$(".stillExists").last().val();
                if(exists != "false") {
                    $(".product").removeClass("hidden");
                    var htm = "<h2 class='three columns'> $" + total + "</h2>"
                    $("#totalOut").children().remove();
                    $("#totalOut").html(htm);
                    $(".removeItem").on("click",function(event){
                        $(this).parent().parent().remove();
                        var idx = $(this).attr("id");
                        $.post("removeIt",{index:idx});
                    });
                }else{
                    $(".product").last().remove();
                    alert("Producto agotado");
                }
            }else{
                $("#product-list").children(".sResults").remove();
                $(".resultlist").html(response);
                $(".sResults").removeClass("hidden");
                $(".add").on("click",function(res){
                    var upc = $(this).attr("itemId");
                    $(".resultlist").children().remove();
                    $.post("agregaproducto",{articulo:upc},function(res){
                        $("#product-list").append(res);
                        var total = $("totalIn").last().val();
                        if($(".stillExists").last().val() != "false") {
                            $(".product").removeClass("hidden");
                            var htm = "<h2 class='three columns'> $" + total + "</h2>"
                            $("#totalOut").children().remove();
                            $("#totalOut").html(htm);
                        }else{
                            $(".product").last().remove();
                            alert("Producto agotado");
                        }

                    });
                });
            }
        });
    });
    $("#closeSale").on("click",function(e){
        e.preventDefault();
        $.post("formadepago",{},function(response){
            $(".metodos").html(response);
            $(".main").children().addClass("inactive");
        });
        $(".main").on("submit","#fpago",function(e){
            e.preventDefault();
            $(".main").fadeIn(300);
            alert("Usted ha completado una venta");
            $(this).submit();
        });
    });
});