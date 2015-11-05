/**
 * Created by jose.espinoza.lopez on 11/5/2015.
 */
$(document).ready(function(){
    $(".popup").on("submit","#search",function(e){
        e.preventDefault();
        console.log($("#search").attr('searchFor'));
        console.log($("#searchParam").val());
        $.post('search',{
            searchParam:$("#searchParam").val()
        },function(response){
            console.log(response);
            $(".userList").html(response);
        });
        return false;
    });
});
