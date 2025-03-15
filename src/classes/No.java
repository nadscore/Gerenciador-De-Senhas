package classes;

public class No {
    public Senha dado; //manipulando dados do tipo Senha
    public No proximo;
    public No anterior;

    public No(Senha dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }
}