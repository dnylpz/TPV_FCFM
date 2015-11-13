/**
 * Created by jose.espinoza.lopez on 9/17/2015.
 */
$(document).ready(function(){
    $(".content").on("click",".button",function(event){
        event.preventDefault();
        console.log($(this).attr('id'));
        $.post("adminajax",{to: $(this).attr('id')},function(response){
            $('.content').addClass('inactive');
            $(".popup").html(response);
            if($("#datePicker").length){
                $("#datePicker").datepicker();
            }
            $(".popup").on('click','#cerrar',function(event){
                console.log("clicked!");
                $(".popup").children().remove();
                $(".content").removeClass('inactive');
            });
        });
    });
});


