package model;

public class ClienteB extends Clientes{

    //ATRIBUTOS
    private double bonus, consumo;

    //CONSTRUTOR, COMO HERDA CLIENTES, O CONSTRUTOR POSSUI OS ATRIBUTOS DE CLIENTES
    public ClienteB(final String nome, final String documento, final String dataCadastro) {
        super(nome, documento, dataCadastro, 5000);
        this.bonus = 0;
        this.consumo = 0;
    }

//METODOS ASSESSORES, SÃO PROTECTED POIS SÃO USADOS APENAS POR METODOS QUE ESTÁ NO MESMO PACOTE, ASSIM NÃO HÁ MOTIVOS PARA SER PUBLIC E NÃO PODE SER PRIVATE
    protected double getBonus() {
        return bonus;
    }

    protected void setBonus(double bonus) {
        this.bonus = bonus;
    }

    protected double getConsumo() {
        return consumo;
    }

    protected void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}
