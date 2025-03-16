/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import classes.Senha;

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.Test;
 
 class SenhaTest {
     @Test
     void testCriacaoSenha() {
         Senha senha = new Senha(1, "n");
         
         assertEquals(1, senha.getNumero(), "O número da senha deve ser 1");
         assertEquals("n", senha.getTipo(), "O tipo da senha deve ser 'n' (normal)");
         assertNotNull(senha.getTimestamp(), "O timestamp da senha não deve ser null");
     }
 
     @Test
     void testToString() {
         Senha senha = new Senha(1, "n");
         
         String descricao = senha.toString();
         assertTrue(descricao.contains("Senha 1"), "A descrição deve conter 'Senha 1'");
         assertTrue(descricao.contains("não atendida"), "A descrição deve conter 'não atendida' inicialmente");
     }
 }