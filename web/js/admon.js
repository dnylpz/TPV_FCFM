/**
 * Created by jose.espinoza.lopez on 9/17/2015.
 */
$(document).ready(function(){

});

$('#users').on('click',function(event){
  event.preventDefault();
  console.log("you clicked the link basterd");
  console.log
  $.ajax('templates/admin/users.html',{
    success: function(response){
      console.log("i got your file basterd won't give it to you now");
      $('.content').hide();
    },
    error: function(response, errorType, errormsg){
      console.log('Error: ' + errorType + ' ' + errormsg);
    },
    timeout: 3000,
    beforeSend: function(){
      $('.content').hide();
    },
    complete: function(){

    }
  });
});
