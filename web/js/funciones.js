$(document).ready(function () {
    $("tr #deleteItem").click(function (e) {
        e.preventDefault();
        var idServicio = $(this).parent().find('#item2').val();        
        swal({
            title: "DeseaEliminar?",
         
            icon: "warning",
            buttons: true,
            dangerMode: true  
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idServicio);
                swal(" ¡Oh! ¡Registro Borrado! ", {
                    icon: "success",
                }).then((willDelete) => {
                    if (willDelete) {
                        parent.location.href = "Controlador?menu=Venta";
                    }
                });
            }
        }); 
    });
    function eliminar(idServicio) {
        var url = "Controlador?menu=Eliminar&idServicio=" + idServicio;
        console.log("hol");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
            }
        });
    }

    
   
});



