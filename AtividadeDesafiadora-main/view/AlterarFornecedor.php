<?php

if (session_status() !== PHP_SESSION_ACTIVE) {
    session_start();
}
require_once './GUI.php'; //chamado do gui
$gui = new GUI(); //instância do objeto de gui
if ((!isset($_SESSION['usuario']) == true) and (!isset($_SESSION['senha']) == true)) {
    unset($_SESSION['usuario']);
    unset($_SESSION['senha']);
    echo $gui->gerarInformativo("Atenção", "Seu tempo de seção espirou ou não foi feito Login!"); //gera um modal informando a situação
    header("refresh: 3; ../view/Login.php"); //após aguardar 3 segundos transfere para a tela de login
}
//termina a verificação de session

require_once '../model/CRUD.php'; //chama o Objeto CRUD, para ser possível usar suas funções
$id = $_REQUEST["id"]; //atribui o cod enviado por get a uma variável, para ser usado na página
?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <?php
        echo '<title>Alteração de dados do Fornecedor ' . retornaValoresFornecedor($id)[1] . '</title>'; //com o echo é criado o title, recebendo um código via get, no CRUD é feito um pesquisa pelo
        ?>                                                                          <!--cod, retornando um array, que na posição 2 vem o nome do produto, sendo posto no title da página
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    </head>
    <body>
        <!-- começa a navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.php">Cadastrados<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastrarProd.php">Cadastro de Produto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastrarFornecedor.php">Cadastro de Fornecedor</a>
                    </li>
                </ul>
                <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                    <li class="nav-item dropdown">
                        <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Espaço do Usuário
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="CadUsuario.php">Cadastrar novo Usuário</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="../controler/SairUsuario.php">Sair</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- termina a navbar -->
        <div class="container">
            <h3>Dados do Fornecedor</h3>
            <div class="row">
                <div class="col-lg">

                    <form name="alterarDados" action="../controler/AlteradorFornecedor.php" method="POST">
                        <input type="hidden" name="id" value="<?php echo "$id"; ?>">
                        <div class="form-group">
                            <label for="Nome">Nome: <?php echo retornaValoresFornecedor($id)[1]; ?></label>
                            <input type="text" class="form-control" id="Nome" name="inputNome" maxlength="100" placeholder="Digite o novo nome do Fornecedor...">
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone: <?php echo retornaValoresFornecedor($id)[2]; ?></label>
                            <input type="text" class="form-control" id="telefone" name="inputTelefone" maxlength="30" placeholder="Digite o novo Telefone...">
                        </div>
                        <div class="form-group">
                            <label for="email">E-mail: <?php echo retornaValoresFornecedor($id)[3]; ?></label>
                            <input type="text" class="form-control" id="email" name="inputEmail" maxlength="50" placeholder="Digite o novo E-mail...">
                        </div>
                        <!-- esta parte é para a parte do endereço -->
                        <h5>Endereco</h5>
                        <div class="Form-group">
                            <!-- aqui é pedido que entre com o cep -->
                            <label for="inputCEP">Cep: <?php echo retornaValoresFornecedor($id)[8]; ?></label>
                            <input type="number" class="form-control" size="50" id="inputCEP" name="cep" placeholder="Digite o cep..." min="0" max="99999999"/>
                            <small>Digite o cep sem o " - ".</small>
                            <!-- deve-se realizar a pesquisa do cep --> 
                            <button type="button" onclick="consultarCEP()" class="btn btn-primary" id="btnCep">Pesquisar</button>
                            <small>Entre com o CEP para ser pesquisado</small>
                            <fieldset>
                                <label for="rua">Rua: <?php echo retornaValoresFornecedor($id)[4]; ?></label>
                                <input type="text" id="rua" name="rua" class="form-control" placeholder="Rua..." maxlength="50"> <!-- aqui é devolvido o nome da rua -->
                                <label for="cidade">Cidade: <?php echo retornaValoresFornecedor($id)[6]; ?></label>
                                <input type="text" id="cidade" name="cidade" class="form-control" placeholder="Cidade..." maxlength="30"> <!-- aqui é devolvido a cidade -->
                                <label for="estado">Estado: <?php echo retornaValoresFornecedor($id)[7]; ?></label>
                                <input type="text" id="estado" name="estado" class="form-control" placeholder="Estado..." maxlength="30"> <!-- aqui é devolvido a sigla do estado -->
                            </fieldset>

                            <!-- aqui é pedido o número do endereço -->
                            <label for="num">Número: <?php echo retornaValoresFornecedor($id)[5]; ?></label>
                            <input type="number" class="form-control" size="50" id="num" name="num" placeholder="Número do rua..." min="0"/>
                        </div>
                        <button type="submit" name="alterar" class="btn btn-primary">Alterar</button><!-- botão para chamar a função de alterar dados -->
                    </form>
                </div>
            </div>
        </div> 
        <script src="../js/funcoes.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>
</html>
