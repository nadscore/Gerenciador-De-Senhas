import classes.Fila;
import classes.Senha;

public class Teste {
    public static void main(String[] args) {
        // Criando a instância de Fila
        Fila fila = new Fila();

        // Gerando algumas senhas
        Senha senha1 = new Senha(1, "n");  // Senha normal
        Senha senha2 = new Senha(2, "n");  // Senha normal
        Senha senha3 = new Senha(3, "p");  // Senha preferencial
        Senha senha4 = new Senha(4, "n");  // Senha normal
        Senha senha5 = new Senha(5, "p");  // Senha preferencial

        // Adicionando as senhas à fila
        fila.adicionarSenhaNormal(senha1);
        fila.adicionarSenhaNormal(senha2);
        fila.adicionarSenhaPreferencial(senha3);
        fila.adicionarSenhaNormal(senha4);
        fila.adicionarSenhaPreferencial(senha5);

        // Exibindo as senhas na fila
        System.out.println("Fila de senhas (com preferenciais primeiro):");
        fila.listarSenhas(); // Supondo que a fila tem um método para listar as senhas
    }
}