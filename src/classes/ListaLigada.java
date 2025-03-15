package classes;

public class ListaLigada {
    private No cabeca;
    private No cauda;
    private int tamanho;

    public ListaLigada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }
    
    public void adicionarPosicao(Senha dado, int posicao) {
    if (posicao < 0 || posicao > tamanho) {
        throw new IndexOutOfBoundsException("Posição inválida");
    }

    if (posicao == 0) {
        adicionarInicio(dado); // Se for posição 0, chama o método de adicionar no início
    } else if (posicao == tamanho) {
        adicionarFim(dado); // Se for a última posição, chama o método de adicionar no fim
    } else {
        No novoNo = new No(dado);
        No atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        // Ajuste de links
        novoNo.anterior = atual.anterior;
        novoNo.proximo = atual;
        atual.anterior.proximo = novoNo;
        atual.anterior = novoNo;

        tamanho++;
    }
}

    public void adicionarInicio(Senha dado) { //manipulando informações do tipo senha
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void adicionarFim(Senha dado) { //manipulando informações do tipo senha
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        }
        tamanho++;
    }

    public Senha removerInicio() {
        if (cabeca == null) {
            return null;
        }
        Senha dadoRemovido = cabeca.dado;
        if (cabeca == cauda) {
            cabeca = null;
            cauda = null;
        } else {
            cabeca = cabeca.proximo;
            cabeca.anterior = null;
        }
        tamanho--;
        return dadoRemovido;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        No atual = cabeca;
        while (atual != null) {
            sb.append(atual.dado);
            if (atual.proximo != null) {
                sb.append(", ");
            }
            atual = atual.proximo;
        }
        sb.append("]");
        return sb.toString();
    }

    int indexOf(Senha ultimaPreferencial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
