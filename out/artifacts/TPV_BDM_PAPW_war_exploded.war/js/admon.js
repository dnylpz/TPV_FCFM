/**
 * Created by jose.espinoza.lopez on 9/17/2015.
 */
$(document).ready(function(){
    $('#home').on('click',{wereTo:'home'},callAjax);
    $('#users').on('click',{wereTo:'users', popup:'adduser'}, callAjax);

});
function callPopup(event){
    event.preventDefault();
    console.log('You want the popup right?');
    $.ajax({
        type:"POST",
        url:"adminajax",
        data:{
            to:event.data.popup
        },
        beforeSend:function(){
            setTimeout(function(){
                $('.content').fadeTo(200,0.80);
                $('.content').addClass('inactive');
            },200);
        },
        success:function(response){
            var res =  response;
            setTimeout(function(rsps){
                $('.popup').html(rsps);
                $('.popup').show();
                $('#cerrar').on('click',function(event){
                    event.preventDefault();
                    $('.popup').slideUp();
                    $('.popup').hide();
                    $('.popup').children().remove();
                    $('.content').removeClass('inactive');
                });
                $('form').on('submit',function(event){
                    event.preventDefault();
                    var id = $('form').attr('id');
                });
            },200,res);
        }
    });
};
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
                $('#popup').on('click',{popup:event.data.popup},callPopup);
            },400, res);

        }
    });
};