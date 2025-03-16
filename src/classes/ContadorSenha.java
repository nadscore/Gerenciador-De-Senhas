/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author damns
 */
public class ContadorSenha {
    private static int contadorNormal = 0;
    private static int contadorPreferencial = 0;
    private static int contadorNormalAtendidas = 0;
    private static int contadorPreferencialAtendidas = 0;
    private static int contadorNaoAtendidas = 0;
    private static long tempoTotalDeEspera = 0;

    public static void resetarContadores() {
        contadorNormal = 0;
        contadorPreferencial = 0;
        contadorNormalAtendidas = 0;
        contadorPreferencialAtendidas = 0;
        contadorNaoAtendidas = 0;
        tempoTotalDeEspera = 0;
    }
    
    // Incrementa as senhas normais
    public static void incrementarNormal() {
        contadorNormal++;
    }
    
    public static int getContadorNormal() {
        return contadorNormal;
    }
    
    // incrementa a senhas preferenciais
    public static void incrementarPreferencial() {
        contadorPreferencial++;
    }
    
    public static int getContadorPreferencial() {
        return contadorPreferencial;
    }
    
    // Soma o total normal + preferencial
    public static int getTotalDeSenhasGeradas() {
        return contadorNormal + contadorPreferencial;
    }
    
    // Total de senhas Normais Atendidas
    public static void incrementarNormaisAtendidas() {
        contadorNormalAtendidas++;
    }
    
    // Total de senhas Preferenciais Atendidas
    public static void incrementarPreferenciaisAtendidas() {
        contadorPreferencialAtendidas++;
    }
    
    
    // Soma Atendidas normal + preferencial
    public static int getTotalDeSenhasAtendidas() {
        System.out.println("NORMAL ATENDIDAS " + contadorNormalAtendidas);
        System.out.println("PREFERENCIAL ATENDIDAS " + contadorPreferencialAtendidas);
        return contadorNormalAtendidas + contadorPreferencialAtendidas;
    }
    
    // Calcula a porcentagem de senhas normais atendidas
    public static double getPorcentagemNormal() {
        int total = getContadorNormal();
        return (total == 0) ? 0 : (contadorNormalAtendidas * 100.0) / total;
    }

    // Calcula a porcentagem de senhas preferenciais atendidas
    public static double getPorcentagemPreferencial() {
        int total = getContadorPreferencial();
        return (total == 0) ? 0 : (contadorPreferencialAtendidas * 100.0) / total;
    }
    
    // Incrementação de senhas não Atendidas
    public static void incrementarNaoAtendidas(){
        contadorNaoAtendidas++;
    }
    
    // Total de senhas não atendidas
    public static int getTotalNaoAtendidas(){
        return contadorNaoAtendidas;
    }
    
    public static void incrementarTimestamps(long diferencaSegundos) {
        tempoTotalDeEspera = tempoTotalDeEspera + diferencaSegundos;
    }
  
    public static double getTempoMedioDeEsperaEmMinutos() {
        if (tempoTotalDeEspera == 0) {
            return 0;
        } 
        
        double tempoMedioEmSegundos = (double) tempoTotalDeEspera / getTotalDeSenhasGeradas();
        
        return tempoMedioEmSegundos / 60; 
    }
}
