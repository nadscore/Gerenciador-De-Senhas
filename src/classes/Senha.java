package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Senha {
    private int numero;
    private String tipo; // "n" para normal, "p" para preferencial
    private boolean atendida;
    private LocalDateTime dataHora;

    public Senha(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.atendida = false;
        this.dataHora = LocalDateTime.now();
    }

    //Getter para o número da senha
    public int getNumero() {
        return numero;
    }
    
    @Override
    public String toString() {
        // Formatação da data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Senha " + numero + " (" + tipo + ") - " + (atendida ? "atendida" : "não atendida") + " - Chegada: " + dataHora.format(formatter);
    }
    
    public String getTipo() {
        return tipo;
    }
}