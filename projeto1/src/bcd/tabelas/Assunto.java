package bcd.tabelas;

/**
 *
 * @author luisa
 */
public class Assunto {

    private int id;
    private String nome;
    private int idDisc;

    public Assunto(String nome, int idDisc) {
        this.nome = nome;
        this.idDisc = idDisc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdDisc(int idDisc) {
        this.idDisc = idDisc;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdDisc() {
        return idDisc;
    }
}
