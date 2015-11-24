    /**
    * Created by jose.espinoza.lopez on 9/17/2015.
    */
    $(document).ready(function(){
    $(".content").on("click",".button",function(event){
        event.preventDefault();
        console.log($(this).attr('id'));
        $.post("adminajax",{to: $(this).attr('id')},function(response){
            $('.content').addClass('inactive');
            console.log(response);
            $(".popup").html(response);
            if($("#datePicker").length){
                $("#datePicker").datepicker();
            }
            if($(".datePicker").length){
              $(".datePicker").datepicker();
                if($(this).attr('id') == "reporte"){
                $(".popup").on("submit","form",function(ev){
                    console.log("submitev trigg");
                    ev.preventDefault();
                    $.post("reporte",{inic: $("#fInic").val(), fin: $("#fFin").val()},function(response){
                        console.log(response);
                        $(".reporteResults").html(response);
                    });
                });
            }else{
                    $(".popup").on("submit","form",function(ev){
                       console.log("subb");
                        $(this).submit();
                        $(".popup").children().remove();
                        $(".content").removeClass('inactive');
                    });
                }
            }
            $(".popup").on('click','#cerrar',function(event){
                console.log("clicked!");
                $(".popup").children().remove();
                $(".content").removeClass('inactive');
            });
        });
    });
    });
