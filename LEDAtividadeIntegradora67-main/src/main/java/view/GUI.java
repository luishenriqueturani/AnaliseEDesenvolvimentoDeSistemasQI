package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Luí­s Henrique
 */
public class GUI {
    String aux;
    
    //Criao menu do app
    public String criarMenu(){
     
        aux = JOptionPane.showInputDialog(
                null,
                "1. O proposto no enunciado\n" + 
                "2. O proposto no enunciado inverso\n" + 
                "0.Sair\n\n", //Mensagem
                "Escolha uma Operação", //Tí­tulo
                JOptionPane.PLAIN_MESSAGE);
        
        return aux;
    }//fecha criar menu
    
    //Cria tela para cadastro de dados
    public String informarDado(String tipo) { 
        
        aux = JOptionPane.showInputDialog(
                null,
                "Informe o " + tipo,
                "Informar dado", //Tí­tulo
                JOptionPane.INFORMATION_MESSAGE);
               
        return aux;
    
    }// fecha informar dado
    
    public String informarDadoA(String tipo) { 
        
        aux = JOptionPane.showInputDialog(
                null,
                "Informe a " + tipo,
                "Informar dado", //Tí­tulo
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
    
    //Mostrar informaÃ§Ã£o
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
