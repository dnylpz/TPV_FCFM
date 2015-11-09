/**
 * Created by jose.espinoza.lopez on 11/5/2015.
 */
$(document).ready(function(){
    $(".popup").on("submit","#search",function(e){
        e.preventDefault();
        console.log($("#search").attr('searchFor'));
        console.log($("#searchParam").val());
        $.post('search',{searchParam:$("#searchParam").val()},function(response){
            console.log(response);
            $(".userList").html(response);
        });
        return false;
    });
    $(".popup").on('click',".edit",function(e){
        e.preventDefault();
        console.log("you clicked the edit button with id: "+$(this).attr("userId"));
        $.post('adminajax',{userid:$(this).attr("userId"), to:'doEditUser'},function(response){
            console.log(response);
            $(".popup").children().remove();
            $(".popup").html(response);
        });
    });
    $(".popup").on("click",".delete",function(e){
        e.preventDefault();
        console.log("you clicked the delete button with id: "+$(this).attr("userId"));
        $.post('serveusers',{servicio:"borrar", usrId:$(this).attr('userId')},function(reponse){
            alert("Usuario Eliminado!");
            $(".popup").children().remove();
            $(".content").removeClass("inactive");
        });
    });
});
