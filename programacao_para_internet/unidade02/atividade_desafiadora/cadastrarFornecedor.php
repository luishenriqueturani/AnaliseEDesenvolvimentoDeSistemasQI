<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Atividade Desafiadora - Cadastrar produtos</title>
    </head>

    <body>
        <!-- Começa a navbar -->
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
            </div>
        </nav><!-- termina a navbar -->

        <div class="container">
            <!-- 
                Começa o formulário, atua nesta mesma página
                Usa o método POST para maior segurança
            -->
            <form action="cadastrarFornecedor.php" method="POST" name="cad-fornecedor">
                <!-- formulário do fronecedor -->

                <h3>Dados do Fornecedor</h3>
                <div class="form-row">
                    <!-- pede o nome -->
                    <div class="form-group col-md-6">
                        <label for="inputNome">Nome<span>*</span></label>
                        <input type="text" class="form-control" id="inputNome" name="nome" placeholder="Nome do fornecedor..." required="">
                    </div>
                    <!-- pede o e-mail -->
                    <div class="form-group col-md-6">
                        <label for="inputEmail">Email<span>*</span></label>
                        <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email..." required="">
                    </div>
                    <!-- pede o telefone -->
                    <div class="form-group col-md-6">
                        <label for="inputFone">Telefone<span>*</span></label>
                        <input type="text" class="form-control" id="inputFone" name="telefone" placeholder="Telefone..." required="">
                    </div>
                </div>
                <!-- termina aqui a primeira parte do formulário -->
                <hr/>
                <!-- esta parte é para a parte do endereço -->
                <h4>Endereco<span>*</span></h4>
                <div class="Form-group">
                    <!-- aqui é pedido que entre com o cep -->
                    <label for="inputCEP">Digite o cep<span>*</span></label>
                    <input type="number" class="form-control" size="50" id="inputCEP" name="cep" placeholder="Digite o cep..." min="0"  required=""/>
                    <small>Digite o cep sem o " - ".</small>
                    <!-- deve-se realizar a pesquisa do cep --> 
                    <button type="button" onclick="consultarCEP()" class="btn btn-primary" id="btnCep">Pesquisar</button>
                    <small>Entre com o CEP para ser pesquisado</small>
                    <fieldset>
                        <label for="rua">Rua</label>
                        <input type="text" id="rua" name="rua" class="form-control" placeholder="Rua..."> <!-- aqui é devolvido o nome da rua -->
                        <label for="cidade">Cidade</label>
                        <input type="text" id="cidade" name="cidade" class="form-control" placeholder="Cidade..."> <!-- aqui é devolvido a cidade -->
                        <label for="estado">Estado</label>
                        <input type="text" id="estado" name="estado" class="form-control" placeholder="Estado..."> <!-- aqui é devolvido a sigla do estado -->
                    </fieldset>
                    
                    <!-- aqui é pedido o número do endereço -->
                    <label for="num">Número<span>*</span></label>
                    <input type="number" class="form-control" size="50" id="num" name="num" placeholder="Número do rua..." min="0" required=""/>

                </div>
                <hr/>
                
                <!-- botão para realizar o cadastro -->
                <button type="submit" name="cadastrar" class="btn btn-primary">Cadastrar</button>
                <small>Os campos com " * " são obrigatórios</small>
            </form>
            <?php
                if(isset($_REQUEST['cadastrar'])){//se o botão cadastrar é clicado...
                    $banco = mysqli_connect("sql202.epizy.com", "epiz_28871846", "a1L09N1lTjHB4DW", "epiz_28871846_ativ_desaf");//a variável banco recebe a conexão,valores( local ou endereço, usuário ou adm do banco, senha de conexão, nome do BD)
                    if(!$banco){ //o retorno da conexão é um boleano, 0 ou 1
                        die ("Erro ao conectar!"); //caso dê o valor 0, significa que não conectou, então encerra os trabalhos e dá uma mensagem de erro ao conectar
                    }else{//senão
                        echo '<script>console.log("Conectado")</script>';//solta uma mensagem de conectado no console do navegador
                        $nome = $_REQUEST['nome'];                      //os valores de cada campo é adicionado em uma variável
                        $email = $_REQUEST['email'];
                        $telefone = $_REQUEST['telefone'];
                        $rua = $_REQUEST['rua'];
                        $numero = $_REQUEST['num'];
                        $cidade = $_REQUEST['cidade'];
                        $estado = $_REQUEST['estado'];
                        $cep = $_REQUEST['cep'];                        //na variável cadastro é adicionado o camando com o valor das variáveis no campo dos valores da query
                        $cadastro = "INSERT INTO fornecedor(id,nome,telefone,emails,rua,num_end,cidade,estado,cep) "
                                . "VALUES (default,'$nome','$telefone','$email','$rua','$numero','$cidade','$estado','$cep'); ";
                        $retorno = mysqli_query($banco, $cadastro);         //a query é executada e seu retorno é inserido na variável retorno
                        echo "<script>alert($retorno);</script>";           //caso haja um erro ele é informado na forma de um alert
                        
                        
                    }
                }
                
                
                
                
                
                
            ?>



        </div>
        <script>
            function consultarCEP() {
                var cep = $("#inputCEP").val(); //a variável cep recebe o valor do cep digitado
                var url = "http://viacep.com.br/ws/" + cep + "/json/"; //a variável url recebe um endereço do site de pesquisa de cep, no espaço
                                                                       //onde entra o cep, o valor da variável cep inserido
                $.getJSON(url, function (result) {      //usando o jquery, é usado uma function para manipular json, entrando com a url e recebendo o json em uma function...
                    console.log(result);                //o resultado em json tem seu retorno no console
                    if (result.erro) {                  //caso o resultado de erro, cep inválido
                        alert("CEP inválido!");         //solta um alerta de cep inválido
                    } else {                            //senão...
                        document.getElementById('rua').value = result.logradouro;       //o imput rua recebe o valor de logradouro
                        document.getElementById('cidade').value = result.localidade;    //o imput cidade recebe o valor de localidade
                        document.getElementById('estado').value = result.uf;            //o imput estado recebe o valor de uf
                    }                                                                   //eu sei que é estranho usar comandos mesclando jquery e js "puro", mas na pressa vai o que está na ponta da lingua
                }).fail(function () {                   //caso dê erro, retorna um alert informando o erro
                    alert('Falha ao consultar o CEP!');
                });
            }
        </script>



        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </body>

</html>