/**
 * Created by jose.espinoza.lopez on 9/17/2015.
 */
$(document).ready(function(){
  $('#home').on('click',{wereTo:'home'},callAjax);
  $('#users').on('click',{wereTo:'users'}, callAjax);

    function callAjax(event){
        event.preventDefault();
        $.ajax({
            type:"POST",
            url:"adminajax",
            data:{
                to:event.data.wereTo
            },
            beforeSend:function(){
                setTimeout(function(){$('.content').slideUp(400)},300);
            },
            success:function(response){
                var res = response;
                setTimeout(function(response){
                    $('.content').html(response);
                    $('.content').slideDown(800);
                },400, res);
            }
        });
    };
});
