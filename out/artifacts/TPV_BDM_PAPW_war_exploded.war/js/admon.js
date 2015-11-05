/**
 * Created by jose.espinoza.lopez on 9/17/2015.
 */
$(document).ready(function(){
    $(".button").on("click",function(event){
        event.preventDefault();
        console.log($(this).attr('id'));
        $.post("adminajax",{to: $(this).attr('id')},function(response){
            $('.content').addClass('inactive');
            $(".popup").html(response);
            $("#cerrar").on('click',function(event){
                $(".popup").children().remove();
                $(".content").removeClass('inactive');
            });
        });
    });
});


