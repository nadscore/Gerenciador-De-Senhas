package classes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Senha {
    private int numero;
    private String tipo; // "n" para normal, "p" para preferencial
    private boolean atendida;
    private LocalDateTime dataHora;
    Instant timestamp;

    public Senha(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.atendida = false;
        this.dataHora = LocalDateTime.now();
        this.timestamp = Instant.now();
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
    
    public Instant getTimestamp() {
        return timestamp;
    }
}