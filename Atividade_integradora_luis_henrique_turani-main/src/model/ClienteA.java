package model;

public class ClienteA extends Clientes{

    //ATRIBUTOS
    private int compraBonus;
    private  double bonus, consumo;

    //CONSTRUTOR, COMO HERDA CLIENTES, O CONSTRUTOR POSSUI OS ATRIBUTOS DE CLIENTES
    public ClienteA(final String nome, final String documento, final String dataCadastro) {
        super(nome, documento, dataCadastro, 10000);
        this.bonus = 0;
        this.consumo = 0;
        this.compraBonus = 0;
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

    protected int getCompraBonus() {
        return this.compraBonus;
    }

    protected void setCompraBonus(final int compraBonus) {
        this.compraBonus = compraBonus;
    }
}
