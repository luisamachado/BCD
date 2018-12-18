package bcd.tabelas;

/**
 *
 * @author luisa
 */
public class Historico {

    private int idProva;
    private int idPerg;

    public Historico(int idProva, int idPerg) {
        this.idProva = idProva;
        this.idPerg = idPerg;
    }

    public int getIdProva() {
        return idProva;
    }

    public int getIdPerg() {
        return idPerg;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public void setIdPerg(int idPerg) {
        this.idPerg = idPerg;
    }

}
