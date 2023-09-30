package entidades;

/**
 *
 * @author nmmat
 */
public class DVD {

    private int numero;
    private String titulo;
    private String atorPrincipal;
    private String atorCoadjuvante;
    private String diretor;
    private int ano;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(String atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public String getAtorCoadjuvante() {
        return atorCoadjuvante;
    }

    public void setAtorCoadjuvante(String atorCoadjuvante) {
        this.atorCoadjuvante = atorCoadjuvante;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
