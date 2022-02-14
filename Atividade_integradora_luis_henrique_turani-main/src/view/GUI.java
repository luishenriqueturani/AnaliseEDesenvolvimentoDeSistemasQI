package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Luís Henrique
 */
public class GUI {
    String aux;

    //Criao menu do app
    public String criarMenu(){

        aux = JOptionPane.showInputDialog(
                null,
                "1. Adicionar novo Cliente\n" +
                "2. Acessar com um cliente existente\n" +
                "0. Sair\n\n", //Mensagem
                "Escolha uma Operação", //Tí­tulo
                JOptionPane.PLAIN_MESSAGE);

        return aux;
    }//fecha criar menu

    //Cria tela para cadastro de dados
    public String informarDado(String mensagem) {

        aux = JOptionPane.showInputDialog(
                null,
                mensagem,
                "Informar dado", //Tí­tulo
                JOptionPane.INFORMATION_MESSAGE);

        return aux;

    }// fecha informar dado

    public String informarDadoA(String mensagem) {

        aux = JOptionPane.showInputDialog(
                null,
                "Informe a " + mensagem,
                "Informar dado", //Título
                JOptionPane.INFORMATION_MESSAGE);

        return aux;

    }// fecha informar dado

    //Confirma fechamento
    public int confirmarFechar(){
        int info = JOptionPane.showConfirmDialog(
                null,
                "Tem certeza?",
                "Fechar o Sistema?",
                JOptionPane.YES_NO_OPTION);

        return info;
    }//Fecha ConfirmarFechar

    //Mostrar mensagem, para mostrar dados e informações gerais
    public void mostrarMensagem(String msg, String titulo, int numIcone){
        /*
        LISTA DE ÍCONES

        -1 = PLAIN_MESSAGE
        0 = ERROR_MESSAGE
        1 = INFORMATION_MESSAGE
        2 = WARNING_MESSAGE
        3 = QUESTION_MESSAGE

        */

        JOptionPane.showMessageDialog(null, msg, titulo, numIcone);

    }//fecha mostrarMensagem

}