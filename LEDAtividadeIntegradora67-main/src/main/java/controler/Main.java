/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import model.Funcoes;
import view.GUI;

/**
 *
 * @author luis_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Foi");
        
        GUI g = new GUI();
        Funcoes f = new Funcoes();
        
        boolean controlaMenu = true;
        
        do{
            try {
                switch(Integer.parseInt(g.criarMenu())){
                    case 1:
                        g.mostrarMensagem(f.proposto(), "Resultado da Atividade Proposta", 1);
                        break;
                    case 2:
                        g.mostrarMensagem(f.propostoInverso(), "Resultado da Atividade Proposta ao inverso", 1);
                        break;
                    case 0:
                        if(g.confirmarFechar() == 0){
                            controlaMenu = false;
                            g.mostrarMensagem("Fechando o aplicativo...\nAt� mais tarde:)", "Fechando...", 1);
                        }
                        break;
                    default:
                        g.mostrarMensagem("Digite um valor v�lido!", "Aten��o", 2);
                        break;
                }
            } catch (Exception e) {
                g.mostrarMensagem("Digite apenas n�meros!", "Aten��o", 2);
            }
        }while(controlaMenu);
         
        
        
        
    }
    
}
