package bcd.tabelas;

/**
 *
 * @author luisa
 */
public class Disciplina {

    private int idDisc;
    private String nome_disc;

    public Disciplina(String nome_disc) {
        this.nome_disc = nome_disc;
    }

    public int getIdDisc() {
        return idDisc;
    }

    public String getNome_disc() {
        return nome_disc;
    }

    public void setIdDisc(int idDisc) {
        this.idDisc = idDisc;
    }

    public void setNome_disc(String nome_disc) {
        this.nome_disc = nome_disc;
    }
}
