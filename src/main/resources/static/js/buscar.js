//HABILITAÇÃO DO BOTÃO APÓS INSERIR DADOS NO CAMPO COMUNIDADE
var comunidade = document.querySelectorAll('input.form-control');


comunidade.forEach(function (e) {

    e.addEventListener("keyup", function () {
        if (e.value.length != 0) {
            document.getElementById("buscarDados").disabled = false;
        }
    });

});


//HABILITA A TABELA APOS CLICAR NO BOTÃO DE BUSCA
function buscarDados() {
    document.getElementById("tabelaOculta").style.display = "";

}
//DEIXA A TABELA OCULTA CASO NÃO TENHA PESQUISA FEITA
var ocultar = document.getElementById("tabelaOculta");
document.getElementById("tabelaOculta").style.display = "none";

//ADICIONA CONTEUDO AO CARRINHO

function verificarCheckbox(e) {
    //opacity50  
    //console.log("este check: " + e.target.checked);

    if (e.target.checked == true) {
        adicionarItemCarrinho()
    } else {
        removerItem()
    }

    if ( $('.custom-control-input:checked').length == 0 ) {
            document.querySelector('.opacity').classList.add('opacity50');
    } else {
            document.querySelector('.opacity').classList.remove('opacity50');
    }
}

var total = 0;
    

function adicionarItemCarrinho(){

    var itens = document.getElementById("totalItensAdicionados");    
     total += 1;
     itens.innerText = total;
}

function removerItem() {
    var itens = document.getElementById("totalItensAdicionados");
    total -= 1;
    itens.innerText = total;
}
