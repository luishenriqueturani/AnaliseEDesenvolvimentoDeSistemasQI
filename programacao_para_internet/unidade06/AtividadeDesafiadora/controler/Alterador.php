<?php
if (session_status() !== PHP_SESSION_ACTIVE) {
    session_start();
}
require_once '../view/GUI.php'; //chamado do gui
$gui = new GUI(); //instância do objeto de gui
if ((!isset($_SESSION['usuario']) == true) and (!isset($_SESSION['senha']) == true)) {
    unset($_SESSION['usuario']);
    unset($_SESSION['senha']);
    echo $gui->gerarInformativo("Atenção", "Seu tempo de seção espirou ou não foi feito Login!");//gera um modal informando a situação
    header("refresh: 3; ../view/Login.php");//após aguardar 3 segundos transfere para a tela de login
}
//termina verificação de session


require_once '../model/CRUD.php';
require_once '../model/Produto.php';
require_once '../view/GUI.php';
$gui = new GUI();
$prod = new Produtos();
$prod->setCod($_REQUEST["cod"]);
try {
    //o objeto chama o método set levando por parâmetro o post com o dado passado pelo usuário, se não foi nada preenchido
    $prod->setMarca(isset($_REQUEST['inputMarca']) ? $_REQUEST['inputMarca'] : null);//é passado o valor null
    $prod->setModelo(isset($_REQUEST['inputModelo']) ? $_REQUEST['inputModelo'] : null);
    $prod->setCor(isset($_REQUEST['inputCor']) ? $_REQUEST['inputCor'] : null);
    $prod->setPreco(isset($_REQUEST['inputPreco']) ? $_REQUEST['inputPreco'] : null);
    $prod->setCodFornecedor(isset($_REQUEST['select-fornecedor']) ? $_REQUEST['select-fornecedor'] : null);
    $prod->setDataFabricacao(isset($_REQUEST['inputData']) ? $_REQUEST['inputData'] : null);
    $prod->setDataCadastro(isset($_REQUEST['input-data-cad']) ? $_REQUEST['input-data-cad'] : null);
    
        //este campo dificilmente será null, ele pode ter o valor da comparação do if
    if($prod->getCodFornecedor() == "Escolha o fornecedor"){                                                      //assim há esta comparação, para o caso de ter este valor
        $prod->setCodFornecedor(null);                                                                         //ser atribuido o valor de null, impedindo um grande bug
    }
    
    
    if($prod->getMarca() != null){                         //é para todos, se a variável não está nula, roda uma function com o cod e o valor a ser alterado por parâmetro
        alterarMarca($prod->getCod(), $prod->getMarca());   
    }
    if($prod->getModelo() != null){
        alterarModelo($prod->getCod(), $prod->getModelo());
    }
    if($prod->getCor() != null){
        alterarCor($prod->getCod(), $prod->getCor());
    }
    if($prod->getPreco() != null){
        alterarPreco($prod->getCod(), $prod->getPreco());
    }
    if($prod->getDataFabricacao() != null){
        alterarDataFab($prod->getCod(), $prod->getDataFabricacao());
    }
    if($prod->getDataCadastro() != null){
        alterarDataCad($prod->getCod(), $prod->getDataCadastro());
    }
    if($prod->getCodFornecedor() != null){
        alterarFornecedor($prod->getCod(), $prod->getCodFornecedor());
    }
    echo $gui->gerarInformativo("Alterado", "Operação realizada com sucesso!");
    header("refresh: 3; ../view/index.php");//envia o usuário para a tela inicial
    
} catch (Exception $ex) {
    echo $gui->gerarInformativo("Erro! :( ", "$ex");                                   //essa mensagem eu estava vendo o tempo inteiro quando tentava fazer com botão para cada campo
    header("refresh: 3; ../view/index.php");            //fazendo com essa montueira de ifelse não vi nenhuma vez
}   
?>