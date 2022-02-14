package controller;

import view.GUI;

import model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class executor {
    public static void main(String[] args) {

        //INSTÂNCIAS
        GUI g = new GUI();
        Metodos m = new Metodos();

        //MENSAGEM DE BOAS VINDAS
        g.mostrarMensagem(
                "Bem vindo a minha atividade integradora, espero que goste :)",
                "Bem vindo",
                -1);

        //ATRIBUTOS DE USO LOCAL, PARA AUXÍLIO
        boolean controleMenu = true;
        boolean controleTipoCliente = true;
        boolean controleIndice = true;
        boolean menuAcoesCliente = true;
        String tipoCliente = null;
        String nome = "";
        String documento = "";
        String dataAtual = "";
        String retLista = "";
        int indiceLista = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                

        //LOOP USADO PARA GERAÇÃO DO MENU
        do {

            //PARA TRATAMENTO DE ERROS
            try {
                //O MENU DE OPÇÕES
                switch (Integer.parseInt(g.criarMenu())){
                    case 1://CASO TENHA ESCOLHIDO CADASTRAR UM NOVO CLIENTE
                        do{//MAIS UM LOOP, ESTE PARA O CASO DE TER ESCOLHIDO UM NÚMERO INVÁLIDO, POIS SE ESCOLHEU UM VALOR NÃO NUMÉRICO VAI CAIR NO CATCH
                            switch(Integer.parseInt(g.informarDado("Qual o tipo de cliente?\n"+
                                                                    "1: Cliente básico, com limite de crédito de R$ 1000,00\n"+
                                                                    "2: Cliente Intermediário, com crédito de R$ 5000,00 + bônus.\n"+
                                                                    "3: Cliente Top, com crédito de R$ 10000,00 + bônus por compras.\n"+
                                                                    "0: Voltar para a tela anterior."))){
                                
                                case 0://CASO ESCOLHEU SAIR, APENAS TORNA POSSÍVEL SAIR DO LOOP
                                    controleTipoCliente = false;
                                    break;
                                case 1://PARA CLIENTE C
                                    tipoCliente = "C";
                                    controleTipoCliente = false;
                                    break;
                                case 2://PARA CLIENTE B
                                    tipoCliente = "B";
                                    controleTipoCliente = false;
                                    break;
                                case 3://PARA CLIENTE A
                                    tipoCliente = "A";
                                    controleTipoCliente = false;
                                    break;
                                default://SE ESCOLHOU UM NÚMERO INVÁLIDO
                                    g.mostrarMensagem("Por favor, informe um valor válido", "Atenção", 1);
                                    break;
                            }

                        }while(controleTipoCliente);
                        controleTipoCliente = true;//PARA O MENU VOLTAR A FUNCIONAR
                        //SE ESCOLHEU VOLTAR PARA O MENÚ ANTERIOR, tipoCliente NÃO É ALTERADO, ASSIM NÃO ENTRA NO IF
                        if(!tipoCliente.equals(null)){
                            do{
                                //PEDE UM NOME PARA O CLIENTE, ENQUANTO NÃO DER UM VALOR, MOSTRA MENSAGEM E PEDE UM NOME
                                nome = g.informarDado("Informe o nome do cliente:");
                                //System.out.println(nome);//PARA DEBUG
                                if(nome.equals("")){
                                    g.mostrarMensagem("O campo de nome é obrigatório. Por favor digite o nome do cliente.", "Atenção", 2);
                                }
                            }while(nome.equals(""));
                            do{
                                //MESMA COISA QUE O NOME, MAS COM O DOCUMENTO
                                documento = g.informarDado("Informe o documento do cliente:");
                                //System.out.println(documento);//PARA DEBUG
                                if(documento.equals("")){
                                    g.mostrarMensagem("O campo de documento é obrigatório. Por favor, digite o documento.", "Atenção", 2);
                                }
                            }while(documento.equals(""));

                            //PEGA A DATA ATUAL
                            dataAtual = dtf.format(LocalDateTime.now());

                            //System.out.println(dataAtual);//PARA DEBUG

                            //ENVIA NOME, DOCUMENTO, TIPO DE CLIENTE E A DATA ATUAL PARA METODOS.CADASTRARCLIENTE
                            g.mostrarMensagem(m.cadastrarCliente(nome, documento, tipoCliente, dataAtual), "Cadastro de cliente", 1);

                            //LIMPA O ATRIBUTO TIPOCLIENTE
                            tipoCliente = null;
                        }

                        break;
                    case 2://CASO TENHA ESCOLHIDO ACESSAR COM UM CLIENTE JÁ CADASTRADO
                        do{
                            //GERA UM MENU PARA ESCOLHA DO TIPO DE CLIENTE
                            switch(Integer.parseInt(g.informarDado("Qual o tipo de cliente?\n"+
                            "1: Cliente básico\n"+
                            "2: Cliente Intermediário\n"+
                            "3: Cliente Top\n"+
                            "0: Voltar para a tela anterior."))){

                            case 0://SE ESCOLHEU VOLTAR PARA A TELA ANTERIOR
                                controleTipoCliente = false;
                                break;
                            case 1://SE ESCOLHEU O CLIENTE TIPO C
                                tipoCliente = "C";
                                controleTipoCliente = false;
                                break;
                            case 2://SE ESCOLHEU O CLIENTE TIPO B
                                tipoCliente = "B";
                                controleTipoCliente = false;
                                break;
                            case 3://SE ESCOLHEU O CLIENTE TIPO A
                                tipoCliente = "A";
                                controleTipoCliente = false;
                                break;
                            default://SE ESCOLHEU UM VALOR INESISTENTE NUMÉRICO
                                g.mostrarMensagem("Por favor, informe um valor válido", "Atenção", 1);
                                break;
                            }
                        }while(controleTipoCliente);
                        //SE ESCOLHEU VOLTAR PARA A TELA ANTERIOR, NÃO ENTRA NO IF
                        if(!tipoCliente.equals(null)){

                            //ATRIBUTO RECEBE O RETORNO DA LISTAGEM DO CLIENTE DO PLANO ESCOLHIDO OU MENSAGEM DE ERRO
                            retLista = m.mostrarClientesDoPlano(tipoCliente);

                            //TRATATIVA FEITA APENAS POR VIA DE DÚVIDA, A CHANCE DE CAIR AQUI É MÍNIMA
                            if(retLista.equals("O plano escolhido é inválido. Por favor, escolha um plano válido.")){
                                g.mostrarMensagem(retLista, "Atenção", 2);
                            }else{

                                do{
                                    //ATRIBUTO RECEBE O ID ESCOLHIDO PELO USUARIO
                                    indiceLista = Integer.parseInt(g.informarDado(retLista + "\n\nDigite o ID do cliente listado ou '0' para retornar:"));
                                    
                                    //SE NÃO FOR 0
                                    if(indiceLista != 0){
                                        if(m.testarIndiceLista(tipoCliente, indiceLista)){
                                            
                                            do{

                                                switch(Integer.parseInt(g.informarDado(
                                                    m.mostrarDadosCliente(tipoCliente, indiceLista) + "\nO que deseja fazer? Digite: " +
                                                                                                        "\n1 - Nova Compra" + 
                                                                                                        "\n2 - Quitar seu consumo de crédito" + 
                                                                                                        "\n0 - Sair" )))
                                                {
                                                    case 1:
                                                        g.mostrarMensagem( m.realizarCompra(tipoCliente, indiceLista, Float.parseFloat(g.informarDado("Qual o valor da compra?")) ) , "", 1);
                                                        break;
                                                    case 2:
                                                        g.mostrarMensagem( m.pagarConta(tipoCliente, indiceLista) , "", 1);

                                                        break;
                                                    case 0:
                                                        menuAcoesCliente = false;
                                                        break;
                                                }

                                            }while(menuAcoesCliente);
                                            menuAcoesCliente = true;//PARA O MENU VOLTAR A FUNCIONAR COMO SE DEVE

                                        }else{
                                            g.mostrarMensagem("O valor informado não é válido. Por favor, escolha um valor válido", "Atenção", 2);
                                        }
                                    }else{
                                        controleIndice = false;
                                    }
                                }while(controleIndice);
                                controleIndice = true;//PARA VOLTAR A FUNCIONAR

                            }

                        }


                        break;

                    case 0://CASO ESCOLHEU SAIR DO APP, PERGUNTA SE REALMENTE QUER SAIR, SE CONFIRMAR, MOSTRA MENSAGEM A SEGUE ATÉ ACABAR OS PROGRAMA
                        if(g.confirmarFechar() == 0){
                            controleMenu = false;
                            g.mostrarMensagem("Fechando o aplicativo...\nAté mais tarde :)", "Fechando...", 1);
                        }
                        break;
                    default:
                        //SE DIGITOU UM NÚMERO INVÁLIDO
                        g.mostrarMensagem("Por favor, digite um valor válido", "Atenção", 2);

                        break;
                }

            }catch (Exception e){//CASO TENHA ENTRADO COM UM VALOR QUE SEJA DE TIPO DIFERENTE DOS TIPOS ACEITOS
                g.mostrarMensagem("Por favor, digite apenas números.", "Atenção", 2);
            }

        }while (controleMenu);

        //SE ESCOLHEU SAIR DO APP E TENHA CONFIRMADO, NÃO HÁ NADA APÓS O WHILE, ENTÃO O APP É ENCERRADO


    }
}
