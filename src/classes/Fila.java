package classes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    Queue<Senha> filaNormal;
    Queue<Senha> filaPreferencial;
    Queue<Senha> filaAuxiliar;
    
    public Fila() {
        this.filaNormal = new LinkedList<>();
        this.filaPreferencial = new LinkedList<>();
        this.filaAuxiliar = new LinkedList<>();
    }

    // Adiciona uma senha normal à fila normal
    public void adicionarSenhaNormal(Senha senha) {
        filaNormal.add(senha);
    }

    // Adiciona uma senha preferencial à fila preferencial
    public void adicionarSenhaPreferencial(Senha senha) {
        filaPreferencial.add(senha);
    }

    // Move senhas para a fila auxiliar se ultrapassarem o limite de tentativas
    public void moverParaFilaAuxiliar(Senha senha) {
        if (filaNormal.contains(senha)) {
            filaNormal.remove(senha);
        } else if (filaPreferencial.contains(senha)) {
            filaPreferencial.remove(senha);
        }
        filaAuxiliar.add(senha);
    }
    
    // Retorna o número da última senha normal gerada
    public int getUltimaSenhaNormal() {
        if (filaNormal.isEmpty()) {
            return 0; // Se não houver senhas normais, retorna 0
        } else {
            // Retorna o número da última senha na fila normal
            Senha ultimaSenha = ((LinkedList<Senha>) filaNormal).getLast();
            return ultimaSenha.getNumero();
        }
    }

    // Retorna o número da última senha preferencial gerada
    public int getUltimaSenhaPreferencial() {
        if (filaPreferencial.isEmpty()) {
            return 0; // Se não houver senhas preferenciais, retorna 0
        } else {
            // Retorna o número da última senha na fila preferencial
            Senha ultimaSenha = ((LinkedList<Senha>) filaPreferencial).getLast();
            return ultimaSenha.getNumero();
        }
    }
    
}


