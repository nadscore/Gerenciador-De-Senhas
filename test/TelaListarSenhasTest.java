import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.Fila;
import classes.Senha;
import classes.TelaListarSenhas;

import javax.swing.DefaultListModel;

public class TelaListarSenhasTest {

    private TelaListarSenhas tela;
    private Fila fila;

    @BeforeEach
    public void setUp() {
        fila = new Fila();
        tela = new TelaListarSenhas(fila);
        
        tela.listarSenhas();
    }

    @Test
    public void testarListarSenhasVazias() {
        DefaultListModel<String> model = tela.getListaModel();
    
        assertEquals(0, model.getSize(), "A lista de senhas deve estar vazia");
    }

    @Test
    public void testarListarSenhasComSenhasNormais() {
        fila.adicionarSenhaNormal(new Senha(1, "n"));
        fila.adicionarSenhaNormal(new Senha(2, "n"));

        tela.listarSenhas();
    
        DefaultListModel<String> model = tela.getListaModel();

        assertEquals(2, model.getSize(), "Deve haver 2 senhas normais");
        assertEquals("Senha 1 - Normal", model.getElementAt(0), "A primeira senha deve ser 'Senha 1 - Normal'");
        assertEquals("Senha 2 - Normal", model.getElementAt(1), "A segunda senha deve ser 'Senha 2 - Normal'");
    }

    @Test
    public void testarListarSenhasComSenhasPreferenciais() {
        fila.adicionarSenhaPreferencial(new Senha(1, "p"));
        fila.adicionarSenhaPreferencial(new Senha(2, "p"));
        tela.listarSenhas();

        DefaultListModel<String> model = tela.getListaModel();

        assertEquals(2, model.getSize(), "Deve haver 2 senhas preferenciais");
        assertEquals("Senha 1 - Preferencial", model.getElementAt(0), "A primeira senha preferencial deve ser 'Senha 1 - Preferencial'");
        assertEquals("Senha 2 - Preferencial", model.getElementAt(1), "A segunda senha preferencial deve ser 'Senha 2 - Preferencial'");
    }

    @Test
    public void testarListarSenhasComNormaisEPreferenciais() {
        fila.adicionarSenhaNormal(new Senha(1, "n"));
        fila.adicionarSenhaPreferencial(new Senha(2, "p"));

        tela.listarSenhas();

        DefaultListModel<String> model = tela.getListaModel();

        assertEquals(2, model.getSize(), "Deve haver 2 senhas na lista");
        assertEquals("Senha 1 - Normal", model.getElementAt(0), "A primeira senha deve ser 'Senha 1 - Normal'");
        assertEquals("Senha 2 - Preferencial", model.getElementAt(1), "A segunda senha deve ser 'Senha 2 - Preferencial'");
    }
}
