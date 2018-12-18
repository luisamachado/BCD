package bcd.tabelas;

/**
 *
 * @author luisa
 */
public class Pergunta {

    private int id;
    private String pergunta;
    private String resposta;
    private int idAssunto;
    private boolean flag;
    private String alternativas;

    public Pergunta(String pergunta, int idAssunto, boolean flag) {
        this.pergunta = pergunta;
        this.idAssunto = idAssunto;
        this.flag = flag;
    }

    

    public int getId() {
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public int getIdAssunto() {
        return idAssunto;
    }

    public boolean getFlag() {
        return flag;
    }

    public String getAlternativas() {
        return alternativas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setIdAssunto(int idAssunto) {
        this.idAssunto = idAssunto;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setAlternativas(String alternativas) {
        this.alternativas = alternativas;
    }
}
