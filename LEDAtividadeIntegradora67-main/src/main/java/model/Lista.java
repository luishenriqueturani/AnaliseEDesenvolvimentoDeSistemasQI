/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luis_
 */
public class Lista {
    private int tamanho;
    private Nodo inicio;
    private Nodo fim;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFim() {
        return fim;
    }

    public void setFim(Nodo fim) {
        this.fim = fim;
    }
    
    
    
    
    
    //métodos de operações da classe
    public void adicionar(int dado, int op){
        Nodo nodo = new Nodo();
        switch(op){
            case 1://adicionar no início
                
                //Nodo nodo = new Nodo();
                nodo.setDado(dado);
                nodo.setAnterior(null);
                nodo.setProximo(this.getInicio());
                if(this.getInicio() != null){
                    inicio.setAnterior(nodo);
                }
                setInicio(nodo);
                if(getTamanho() == 0){
                    setFim(getInicio());
                }
                setTamanho(getTamanho()+1);
                
                
                break;
            case 2://adicionar no final
                nodo.setDado(dado);
                nodo.setProximo(null);
                nodo.setAnterior(getFim());
                if(getFim() != null){
                    fim.setProximo(nodo);
                }
                setFim(nodo);
                if(getTamanho() == 0){
                    setInicio(getFim());
                }
                setTamanho(getTamanho()+1);
                
                break;
            default:
                break;
        }
    }
    
    public boolean remover(int op){
        int out;
        switch(op){
            case 1://remove do início
                if(getInicio() == null){
                    return false;
                }
                out = this.inicio.getDado();
                setInicio(inicio.getProximo());
                if(getInicio() != null){
                    this.inicio.setAnterior(null);
                }else{
                    setFim(null);
                }
                setTamanho(getTamanho()-1);
                break;
            case 2://remove do fim
                if(getFim() == null){
                    return false;
                }
                out = fim.getDado();
                setFim(fim.getAnterior());
                if(getFim() != null){
                    fim.setProximo(null);
                }else{
                    setInicio(null);
                }
                setTamanho(getTamanho()-1);
                break;
            default:
                break;
        }
        return true;
    }
    
    public String imprimirDOInicioAoFim(){
        String str = "Tamanho = " + getTamanho() + ";\n";
        Nodo nodo = getInicio();
        while(nodo != null){
            str += nodo.getDado() + " ";
            nodo = nodo.getProximo();
        }
        
        return str;
    }
    
    public String imprimirInverso(){
        String str = "Tamanho = " + getTamanho() + ";\n";
        Nodo nodo = getFim();
        while(nodo != null){
            str += nodo.getDado() + " ";
            nodo = nodo.getAnterior();
        }
        
        return str;
    }
    
}
