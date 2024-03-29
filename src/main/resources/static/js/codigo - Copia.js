$(document).ready(function() {
   $("#btAdd").click(function() {
       var nome = $("#txtNome").val();
       var mail = $("#txtMail").val();
       var fone = $("#txtFone").val();
       var sal = $("#txtSalario").val();
       
       if($(this).data("tipo")=="N") {
       
           bloco  = "<tr>";
           bloco += "<td>" + nome + "</td>";
           bloco += "<td>" + mail + "</td>";
           bloco += "<td>" + fone + "</td>";
           bloco += "<td style='text-align:right' class='valor'>" + sal + "</td>";
           bloco += "<td>";
           bloco += "   <button class='btn btn-warning btn-sm btEdit'><i class='fa fa-pencil'></i> Editar</button>";
           bloco += "</td>";
           bloco += "<td>";
           bloco += "<button class='btn btn-success btn-sm btDel'><i class='fa fa-times'></i> Apagar</button>";
           bloco += "</td>";
           bloco += "</tr>";

           $("#tabela tbody").append(bloco);
           $("form")[0].reset();
           conta();
       } else {
           $(".active").find("td:eq(0)").html(nome);
           $(".active").find("td:eq(1)").html(mail);
           $(".active").find("td:eq(2)").html(fone);
           
           $(".active").removeClass("active");
           $("#form")[0].reset();
       }
       
       $("#insere").modal("hide");
           
   }); 
    
    $(document).on("click",".btDel",function() {
        var el = $(this);
        bootbox.confirm("<h3 class='alert alert-danger'>ATENÇÃO!!!</h3><p>Deseja mesmo apagar?</p>",function(ok) {
            if(ok) {                
                el.closest("tr").remove();
                conta();
            }
        })
    });
    
    $("#btInsere").click(function() {
        $("#btAdd").data("tipo","N");
        $("#insere").modal("show");
    });
    
    $(document).on("click",".btEdit",function() {
       el = $(this);
       var nome = el.closest("tr").find("td:eq(0)").html();      
       var mail = el.closest("tr").find("td:eq(1)").html();
       var fone = el.closest("tr").find("td:eq(2)").html();
        
        //insere uma classe na linha pra marcá-la
        el.closest("tr").addClass("active");
        
        //alimenta os campos do modal
        $("#txtNome").val(nome);
        $("#txtMail").val(mail);
        $("#txtFone").val(fone);
        
        $("#btAdd").data("tipo","E");
        $("#btAdd").html("<i class='fa fa-edit'></i> Editar");
        
        $("#insere").modal("show");
        
    });
    
    $("#btCalcula").click(function() {
        total = calcular();
        alert(total);
    });
    
    function conta() {
        var total = 0;
        total = $("#tabela tbody tr").length;
        $("#numReg").html(total);
    }
    
    function calcular() {
        s = 0;
        $(".valor").each(function(idx) {
            v = parseFloat($(this).html());
            s = s + v;
        });
        return s;
    }
    conta();
});