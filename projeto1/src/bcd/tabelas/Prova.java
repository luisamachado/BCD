package bcd.tabelas;

/**
 *
 * @author luisa
 */
public class Prova {

    private int id;
    private int ano;
    private int semestre;
    private int idDisc;

    public Prova(int semestre, int idDisc) {
        this.semestre = semestre;
        this.idDisc = idDisc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setIdDisc(int idDisc) {
        this.idDisc = idDisc;
    }

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getIdDisc() {
        return idDisc;
    }
}
