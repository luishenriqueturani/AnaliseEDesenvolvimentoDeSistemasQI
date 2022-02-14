package model;

import java.util.ArrayList;
import java.util.List;

public class Metodos {

    //INSTâNCIAS DE LIST, CRIANDO ARRAYS LIST
    private List<ClienteA> listA = new ArrayList<>();
    private List<ClienteB> listB = new ArrayList<>();
    private List<ClienteC> listC = new ArrayList<>();

    //METODO DE CADASTRO DOS CLIENTES
    public String cadastrarCliente(String nome, String documento, String tipoCliente, String dataAtual){

        //SE FOR DO TIPO A
        if(tipoCliente.equals("A")){

            //CRIA INSTANCIA DE CLIENTEA, INICIANDO O CONSTRUTOR COM NOME, DOCUMENTO E A DATA ATUAL
            ClienteA ca = new ClienteA(nome, documento, dataAtual);

            //O OBJETO É ADICIONADO NO ARRAY LIST LISTA, QUE PASSARÁ A MANIPULAR OS CLIENTES A
            listA.add(ca);

            //RETORNA MENSAGEM DE SUCESSO
            return "Cliente "+nome+" adicionado no plano Top.";

        }else if(tipoCliente.equals("B")){//FAZ MESMA COISA MAS COM O CLIENTE B

            //INSTÂNCIA COM CONSTRUTOR
            ClienteB cb = new ClienteB(nome, documento, dataAtual);

            //RECEBE O OBJETO PARA MANIPULAR
            listB.add(cb);
            
            //RETORNA MENSAGEM DE SUCASSO
            return "Cliente "+nome+" adicionado no plano Intermediário.";

        }else if(tipoCliente.equals("C")){//MESMA COISA MAS COM O CLIENTE C

            //INSTANCIA COM CONSTRUTOR
            ClienteC cc = new ClienteC(nome, documento, dataAtual);

            //RECEBE O OBJETO PARA MANIPULAR OS DADOS
            listC.add(cc);

            //RETORNA MENSAGEM DE SUCESSO
            return "Cliente "+nome+" adicionado no plano Básico.";
        }

        //CASO O TIPO DE CLIENTE SEJA INVÁLIDO, RETORNA MENSAGEM DE ERRO DO USUARIO
        return "Não foi possível detectar o tipo de cliente";
    }

    //METODO DE MOSTRAR OS CLIENTES DE ACORDO COM O PLANO RECEBIDO
    public String mostrarClientesDoPlano(String plano){

        //INICIADO ATRIBUTO VAZIO PARA RECEBER O RETORNO
        String retorno = "";

        switch(plano){
            case "A"://CASO SEJA DO TIPO A

                if(listA.size() != 0){

                    //PERCORRE LISTA ATÉ SEU TAMANHO TOTAL
                    for(int i = 0; i < listA.size(); i++){
                        //ATRIBUTO RETORNO É CONCATENADO COM O RESULTADO DE LIST A. O ID + 1 É PARA NÃO MOSTRAR O PRIMEIRO VALOR COM ID 0, APENAS ESTÉTICA
                        retorno += "ID: " + (i+1) + " - Nome: "+ listA.get(i).getNome() + "\n";
                    }
                }else{
                    retorno = "Ainda não há clientes para este plano.";
                }
                
                break;
            case "B"://CASO SEJA TIPO B
                if(listB.size() != 0){

                    //MESMA COISA, RETORNO É CONCATENADO COM O RETORNO DE LIST B. ID TAMBÉM É COMPENSADO PARA NÃO MOSTRAR O 0 COMO PRIMEIRO RESULTADO
                    for(int i = 0; i < listB.size(); i++){
                        retorno += "ID: " + (i+1) + " - Nome: "+ listB.get(i).getNome() + "\n";
                    }
                }else{
                    retorno = "Ainda não há clientes para este plano.";
                }
                
                break;
            case "C"://CASO SEJA TIPO C
                if(listC.size() != 0){

                    //PERCORRE LIST C E RETORNO É CONCATENADO COM SEU RESULTADO. ID TAMBÉM É COMPENSADO
                    for(int i = 0; i < listC.size(); i++){
                        retorno += "ID: " + (i+1) + " - Nome: "+ listC.get(i).getNome() + "\n";
                    }
                }else{
                    retorno = "Ainda não há clientes para este plano.";
                }
                break;
            default://CASO O PLANO SEJA DE UM VALOR INVÁLIDO
                //RETORNO RECEBE MENSAGEM DE ERRO
                retorno = "O plano escolhido é inválido. Por favor, escolha um plano válido.";
                break;
        }
        //RETORNO DO METODO
        return retorno;
    }

    //METODO PARA VALIDAR O INDICE DA LISTAGEM DE CLIENTES
    public boolean testarIndiceLista(String tipoCliente, int indiceLista){

        switch(tipoCliente){
            case "A"://CASO O CLIENTE SEJA DO TIPO A
                //TESTA COM LISTA, SE FOR MENOR IGUAL AO TAMANHO DE LISTA E FOR MAIOR QUE 0
                if(listA.size() >= indiceLista && indiceLista > 0){
                    return true;
                }

                break;
            case "B":
                //TESTA COM LISTB, SE FOR MENOR IGUAL AO TAMANHO DE LISTB E FOR MAIOR QUE 0
                if(listB.size() >= indiceLista && indiceLista > 0){
                    return true;
                }
                break;
            case "C":
                //TESTA COM LISTC, SE FOR MENOR IGUAL AO TAMANHO DE LISTC E FOR MAIOR QUE 0
                if(listC.size() >= indiceLista && indiceLista > 0){
                    return true;
                }
                break;
        }

        return false;
    }

    //METODO PARA MOSTRAR DADOS DE DETERMINADO CLIENTE
    public String mostrarDadosCliente(String tipoCliente, int indice){
        String retorno = "";

        indice = indice -1;

        switch(tipoCliente){
            case "A"://CASO O CLIENTE SEJA DO TIPO A
                retorno += "Nome: " + listA.get(indice).getNome() +
                            "\nLimite de Crédito: R$ " + listA.get(indice).getCreditoLimite() +
                            "\nCrédito Usado: R$ " + listA.get(indice).getCreditoUsado() + 
                            "\nConsumo Usado: R$ " + listA.get(indice).getConsumoUsado() +
                            "\nBônus: " + (listA.get(indice).getBonus() == 0 ? "Nenhum" : "10% de desconto");

                break;
            case "B"://CASO SEJA TIPO B
            retorno += "Nome: " + listB.get(indice).getNome() +
                "\nLimite de Crédito: R$ " + listB.get(indice).getCreditoLimite() +
                "\nCrédito Usado: R$ " + listB.get(indice).getCreditoUsado() + 
                "\nConsumo Usado: R$ " + listB.get(indice).getConsumoUsado() +
                "\nBônus: " + (listB.get(indice).getBonus() == 0 ? "Nenhum" : "5% de desconto");
                
                break;
            case "C"://CASO SEJA TIPO C
            retorno += "Nome: " + listC.get(indice).getNome() +
                    "\nLimite de Crédito: R$ " + listC.get(indice).getCreditoLimite() +
                    "\nCrédito Usado: R$ " + listC.get(indice).getCreditoUsado() + 
                    "\nConsumo Usado: R$ " + listC.get(indice).getConsumoUsado();
                
                break;
        }


        return retorno;
    }

    public String realizarCompra(String tipoCliente, int indice, double valorCompra){
        String retorno = "";
        double desconto = 0;
        double total = 0;

        indice = indice -1;

        switch(tipoCliente){
            case "A"://CASO O CLIENTE SEJA DO TIPO A
                //SE O VALOR NÃO FOR MAIOR DO QUE O LIMITE DE CRÉDITO NEM FOR MENOR QUE 0
                if(listA.get(indice).getCreditoLimite() >= (valorCompra + listA.get(indice).getCreditoUsado()) && valorCompra > 0 ){
                    //SE POSSUI BONUS
                    if(listA.get(indice).getBonus() != 0){
                        //CALCULA DESCONTO
                        desconto = valorCompra * listA.get(indice).getBonus();

                        //CALCULA O VALOR TOTAL
                        total = valorCompra - desconto;
                        //REDUZ EM 1 A QUANTIDADE DE COMPRAS BONUS
                        listA.get(indice).setCompraBonus( listA.get(indice).getCompraBonus() - 1 );
                        //SE TIVAR ACABADO A QUANTIDADE DE COMPRAS BONUS
                        if( listA.get(indice).getCompraBonus() == 0 ){
                            //BONUS RECEBE 0
                            listA.get(indice).setBonus(0);
                        }

                        //COMEÇA A MENSAGEM DE RETORNO
                        retorno = "Compra realizada com sucesso!" +
                                "\nQuantidade de compras bonus restantes: " + listA.get(indice).getCompraBonus() +
                                "\nDesconto de R$" + desconto +
                                "\nTotal: R$ " + total;
                    }else{
                        //"CALCULA" O VALOR TOTAL
                        total = valorCompra;
                        //COMEÇA A MENSAGEM DE RETORNO
                        retorno = "Compra realizada com sucesso!\nTotal: R$ " + total;
                    }

                    //ATRIBUTOS RECEBEM SEUS NOVOS VALORES
                    listA.get(indice).setConsumoUsado( listA.get(indice).getConsumoUsado() + total );
                    listA.get(indice).setCreditoUsado( listA.get(indice).getCreditoUsado() + total );
                    listA.get(indice).setConsumo( listA.get(indice).getConsumo() + total );

                    //SE CONSUMO FOI MAIOR DO QUE 5000, LIMITE DE CREDITO AUMENTA E MENSAGEM DE RETORNO É CONCATENADO COM MENSAGEM DESTE AUMENTO
                    if( listA.get(indice).getConsumo() >= 5000 ){
                        listA.get(indice).setCreditoLimite( listA.get(indice).getCreditoLimite() + 500);
                        listA.get(indice).setConsumo( listA.get(indice).getConsumo() - 5000 );
                        retorno += "\nLimite de crédito aumentado para R$ " + listA.get(indice).getCreditoLimite();
                    }
                    

                }else{//SE O VALOR FOR INVÁLIDO, APENAS MOSTRA MENSAGEM DE ERRO
                    retorno = "Não é possível realizar uma compra neste valor.";
                }
                break;
            case "B"://CASO CLIENTE B
                //SE O VALOR DA COMPRA NÃO EXCEDER O CREDITO TOTAL NEM FOR MENOR QUE 0
                if(listB.get(indice).getCreditoLimite() >= (valorCompra + listB.get(indice).getCreditoUsado()) && valorCompra > 0 ){
                    //SE POSSUIR BONUS DE DESCONTO, ISSO É, ELE SER DIFERENTE DE 0
                    if(listB.get(indice).getBonus() != 0){
                        //CALCULADO O DESCONTO
                        desconto = valorCompra * listB.get(indice).getBonus();
                        //CALCULADO O VALOR TOTAL, É FEITO AQUI PARA TER O VALOR A SER MOSTRADO
                        total = valorCompra - desconto;
                        //MUDA O VALOR DOS ATRIBUTOS NA CLASSE
                        listB.get(indice).setConsumoUsado( listB.get(indice).getConsumoUsado() + total );
                        listB.get(indice).setCreditoUsado( listB.get(indice).getCreditoUsado() + (valorCompra - desconto) );
                        //MENSAGEM DE RETORNO
                        retorno = "Compra realizada com sucesso!\nValor: R$ " + valorCompra +
                                    "\nBônus desconto de " + (listB.get(indice).getBonus() * 100 ) + "% usado." +
                                    "\nValor de desconto: R$" + desconto +
                                    "\nTotal pago: R$ " + total;
                        //BONUS FICA NOVAMENTE EM 0                        
                        listB.get(indice).setBonus(0);

                    }else{//SE NÃO POSSUI AINDA UM DESCONTO
                        
                        total = valorCompra;
                        //SETA OS ATRIBUTOS COM SEUS NOVOS VALORES
                        listB.get(indice).setConsumoUsado( listB.get(indice).getConsumoUsado() + total );
                        listB.get(indice).setCreditoUsado( listB.get(indice).getCreditoUsado() + (valorCompra - desconto) );
                        
                        retorno = "Compra realizada com sucesso!\nValor: R$ " + valorCompra +
                        "\nTotal pago: R$ " + total ;
                        
                    }

                }else{
                    retorno = "Não é possível realizar uma compra neste valor.";
                }
                break;
            case "C"://CASO CLIENTE C
                //SE O VALOR DA COMPRA NÃO EXCEDER O LIMITE DE CREDITO NEM FOR MENOR DO QUE 0
                if(valorCompra > 0 && listC.get(indice).getCreditoLimite() >= (listC.get(indice).getCreditoUsado() + valorCompra) ){
                    //CONSUMO USADO RECEBE SEU NOVO VALOR
                    listC.get(indice).setConsumoUsado( listC.get(indice).getConsumoUsado() + valorCompra );
                    //CREDITO USADO RECEBE SEU NOVO VALOR
                    listC.get(indice).setCreditoUsado( listC.get(indice).getCreditoUsado() + valorCompra );
                    //MENSAGEM DE RETORNO
                    retorno = "Compra realizada com sucesso no valor de R$ " + valorCompra + ".\nSeu crédito restante é de R$ " + 
                                ( listC.get(indice).getCreditoLimite() - listC.get(indice).getCreditoUsado());

                }else{//SE O VALOR NÃO FOR VÁLIDO, MOSTRA MENSAGEM DE ERRO
                    retorno = "Não é possível realizar uma compra neste valor.";
                }
                
                break;
        }
        //RETORNO DE METODO
        return retorno;
    }

    //METODO DE QUITAÇÃO DE CONTA
    public String pagarConta(String tipoCliente, int indice){

        String retorno = "";

        indice = indice -1;

        switch(tipoCliente){
            case "A":
                //A MENSAGEM COMEÇA AQUI PARA PODER CONCATENAR E MOSTRAR UMA MENSAGEM MELHOR
                retorno = "Suas contas foram pagas com sucesso.";
                //SE O VALOR A SER PAGO FOR 2000 OU MAIS, O CLIENTE GANHA UM BONUS
                if(listA.get(indice).getCreditoUsado() >= 2000){
                    listA.get(indice).setBonus(0.1);
                    listA.get(indice).setCompraBonus( listA.get(indice).getCompraBonus() + 2 );
                    retorno += "\nVocê ganhou um bonus de " + (listA.get(indice).getBonus() * 100) +"% para as próximas "+listA.get(indice).getCompraBonus()+" compras.";
                }
                //CONSUMO E CREDITO SE TORNAM 0
                listA.get(indice).setConsumoUsado(0);
                listA.get(indice).setCreditoUsado(0);

                break;
            case "B":
                //A MENSAGEM COMEÇA AQUI PARA PODER CONCATENAR E MOSTRAR UMA MENSAGEM MELHOR
                retorno = "Suas contas foram pagas com sucesso.";
                //SE O VALOR A SER PAGO FOR 2000 OU MAIS, O CLIENTE GANHA UM BONUS
                if(listB.get(indice).getCreditoUsado() >= 2000){
                    listB.get(indice).setBonus(0.05);
                    retorno += "\nVocê ganhou um bonus de 5% para a próxima compra.";
                }
                //CONSUMO E CREDITO SE TORNAM 0
                listB.get(indice).setConsumoUsado(0);
                listB.get(indice).setCreditoUsado(0);

                break;
            case "C":
                //CONSUMO E CREDITO USADOS RECEBEM 0 E MOSTRA MENSAGEM
                listC.get(indice).setConsumoUsado(0);
                listC.get(indice).setCreditoUsado(0);
                retorno = "Suas contas foram pagas com sucesso.";
                break;
        }

        return retorno;
    }


}
