/**
 * Created by jose.espinoza.lopez on 11/5/2015.
 */
$(document).ready(function(){
    $(".popup").on("submit","#search",function(e){
        e.preventDefault();
        var buscaA  =$("#search").attr('searchFor')
        console.log(buscaA);
        console.log($("#searchParam").val());
        $.post('search',{searchParam:$("#searchParam").val(), searchFor:buscaA},function(response){
            console.log(response);
            $(".resultList").children().remove();
            $(".resultList").html(response);
            $(".content").removeClass("hidden");
        });
        return false;
    });
    $(".popup").on('click',".edit",function(e){
        e.preventDefault();
        console.log("you clicked the edit button with id: "+$(this).attr("itemId"));
        var action = $(this).attr("action");
        var serv = $(this).attr("servicio");
        $.post(action,{itemId:$(this).attr("itemId"), to:serv},function(response){
            console.log(response);
            $(".popup").children().remove();
            $(".popup").html(response);
        });
    });
    $(".popup").on("click",".delete",function(e){
        e.preventDefault();
        var cnfrm = confirm("¿Desea eliminar este elemento?");
        if(cnfrm) {
            var action = $(this).attr("action");
            var itemType = $(this).attr("itemType");
            console.log("you clicked the delete button with id: " + $(this).attr("itemId"));
            var itId = $(this).attr("itemId");
            $.post(action, {itemId: itId, servicio: "borrar"}, function (reponse) {
                alert(itemType + " Eliminado!");
                $(".popup").children().remove();
                $(".content").removeClass("inactive");
            });
        }
    });
    $(".popup").on("click",".addpromo",function(e){
        e.preventDefault();
        var itId = $(this).attr("itemId");
        var action = $(this).attr("action");
        var serv = $(this).attr("servicio")
        $.post(action,{itemId:itId, servicio:"addPromo", to:serv}, function(response){
            console.log(response);
            $(".popup").children().remove();
            $(".popup").html(response);
            $(".datePicker").datepicker();
            $(".popup").on("submit","#addpromo",function(ev){
                alert("promocion guardada");
                $(this).submit();
            });
        });
    });
});
