<?php
//constantes com os valores para a conexão
define("DSN", "mysql");
define("SERVIDOR", "sql202.epizy.com");
define("USUARIO", "epiz_28871846");
define("SENHA", "a1L09N1lTjHB4DW");
define("BANCODEDADOS", "epiz_28871846_ativ_desaf");
function conectar() {
    
    $conn = new PDO(DSN.':host='.SERVIDOR.';dbname='.BANCODEDADOS,USUARIO,SENHA);//a conexão é estabelecida, recebendo as constantes como valor nos seus campos
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);//seta atributos para tratar os erros
    return $conn;//retorna a conexão, retornando todo o Objeto da conexão
}

?>