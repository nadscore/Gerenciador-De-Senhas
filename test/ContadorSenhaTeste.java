import classes.ContadorSenha;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContadorSenhaTeste {
    
    @BeforeEach
    void setUp() {
        // Resetando valores antes de cada teste
        ContadorSenha.resetarContadores();
    }

    @Test
    public void testIncrementarNormal() {
        ContadorSenha.incrementarNormal();
        assertEquals(1, ContadorSenha.getContadorNormal());
    }
    
    @Test
    public void testIncrementarPreferencial() {
        ContadorSenha.incrementarPreferencial();
        assertEquals(1, ContadorSenha.getContadorPreferencial());
    }

    @Test
    void testTotalDeSenhasGeradas() {
        ContadorSenha.incrementarNormal();
        ContadorSenha.incrementarPreferencial();
        assertEquals(2, ContadorSenha.getTotalDeSenhasGeradas());
    }

    @Test
    void testIncrementarNormaisAtendidas() {
        ContadorSenha.incrementarNormaisAtendidas();
        assertEquals(1, ContadorSenha.getTotalDeSenhasAtendidas());
    }

    @Test
    void testIncrementarPreferenciaisAtendidas() {
        ContadorSenha.incrementarPreferenciaisAtendidas();
        assertEquals(1, ContadorSenha.getTotalDeSenhasAtendidas());
    }

    @Test
    void testPorcentagemNormal() {
        ContadorSenha.incrementarNormal();
        ContadorSenha.incrementarNormal();
        ContadorSenha.incrementarNormaisAtendidas();
        assertEquals(50.0, ContadorSenha.getPorcentagemNormal());
    }

    @Test
    void testPorcentagemPreferencial() {
        ContadorSenha.incrementarPreferencial();
        ContadorSenha.incrementarPreferencial();
        ContadorSenha.incrementarPreferenciaisAtendidas();
        assertEquals(50.0, ContadorSenha.getPorcentagemPreferencial());
    }

    @Test
    void testIncrementarNaoAtendidas() {
        ContadorSenha.incrementarNaoAtendidas();
        assertEquals(1, ContadorSenha.getTotalNaoAtendidas());
    }

    @Test
    void testTempoMedioDeEspera() {
        ContadorSenha.incrementarNormal();
        ContadorSenha.incrementarNormal();
        ContadorSenha.incrementarPreferencial();
        ContadorSenha.incrementarPreferencial();
        ContadorSenha.incrementarTimestamps(300); // 5 minutos (300 segundos)
        assertEquals(1.25, ContadorSenha.getTempoMedioDeEsperaEmMinutos());
    }
}
