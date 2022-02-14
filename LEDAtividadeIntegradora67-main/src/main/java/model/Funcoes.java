package model;

/**
 *
 * @author luis_
 */
public class Funcoes {
    
    public String proposto(){
        Lista l = new Lista();

        for (int i = 1; i <= 10; i++) {
            l.adicionar(i, 2);//adiciona o índice do for no final
        }
        
        //System.out.println(l.imprimirDOInicioAoFim());
        //System.out.println(l.imprimirInverso());
        
        return "Imprimir do início ao fim: "+l.imprimirDOInicioAoFim()+"\nImprimir Inverso: "+l.imprimirInverso();
    }
    
    public String propostoInverso(){
        Lista l = new Lista();

        for (int i = 1; i <= 10; i++) {
            l.adicionar(i, 1);//adiciona o índice do for no final
        }
        
        //System.out.println(l.imprimirDOInicioAoFim());
        //System.out.println(l.imprimirInverso());
        
        return "Imprimir do início ao fim: "+l.imprimirDOInicioAoFim()+"\nImprimir Inverso: "+l.imprimirInverso();
        
    }
    
}
