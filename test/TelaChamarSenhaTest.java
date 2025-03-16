import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.Fila;
import classes.Senha;
import classes.TelaChamarSenha;

public class TelaChamarSenhaTest {

    private TelaChamarSenha tela;
    private Fila fila;

    @BeforeEach
    public void setUp() {
        fila = new Fila();
        tela = new TelaChamarSenha(fila);
    }

    @Test
    public void testarChamarProximaSenhaNormal() {
        Senha senha = new Senha(1, "n");
        fila.adicionarSenhaNormal(senha);

        tela.getBtnChamar().doClick(); 

        assertEquals("1", tela.getLblSenhaChamada().getText());
        assertEquals("Normal", tela.getLblTipo().getText());
    }

    @Test
    public void testarChamarProximaSenhaVazia() {
        tela.getBtnChamar().doClick();

        assertEquals("-", tela.getLblSenhaChamada().getText());
        assertEquals("-", tela.getLblTipo().getText());
    }

    @Test
    public void testarChamarNovamente() {
        Senha senha = new Senha(2, "n");
        fila.adicionarSenhaNormal(senha);

        tela.getBtnChamar().doClick(); 

        tela.getBtnChamarNovamente().doClick();  

        assertEquals("2", tela.getLblSenhaChamada().getText());
    }

    @Test
    public void testarLimiteChamarNovamente() {
        Senha senha = new Senha(3, "n");
        fila.adicionarSenhaNormal(senha);

        tela.getBtnChamar().doClick(); 
        tela.getBtnChamarNovamente().doClick(); 
        tela.getBtnChamarNovamente().doClick(); 
        tela.getBtnChamarNovamente().doClick(); 

        assertFalse(tela.getBtnChamarNovamente().isEnabled());
    }
}

