/**
 * Created by jose.espinoza.lopez on 9/17/2015.
 */
$(document).ready(function(){
  console.log("hello world");
  $('#users').on('click', function(){
    $.get('templates/admin/users.html',function(response){
      $('.content').children().slideUp();
      $('.content').html(response);
    });
  });
});
