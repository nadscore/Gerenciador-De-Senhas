/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 import classes.Fila;
 import classes.Senha;

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 
 class FilaTest {
     private Fila fila;
     private Senha senhaNormal;
     private Senha senhaPreferencial;
 
     @BeforeEach
     void setUp() {
         fila = new Fila();
         senhaNormal = new Senha(1, "n");
         senhaPreferencial = new Senha(2, "p");
     }
 
     @Test
     void testAdicionarSenhaNormal() {
         fila.adicionarSenhaNormal(senhaNormal);
         assertEquals(1, fila.getUltimaSenhaNormal(), "A última senha normal deve ser 1");
     }
 
     @Test
     void testAdicionarSenhaPreferencial() {
         fila.adicionarSenhaPreferencial(senhaPreferencial);
         assertEquals(2, fila.getUltimaSenhaPreferencial(), "A última senha preferencial deve ser 2");
     }
 
     @Test
     void testMoverParaFilaAuxiliar() {
         fila.adicionarSenhaNormal(senhaNormal);
         fila.adicionarSenhaPreferencial(senhaPreferencial);
 
         fila.moverParaFilaAuxiliar(senhaNormal);
         fila.moverParaFilaAuxiliar(senhaPreferencial);
 
         // Teste para verificar se as senhas foram movidas corretamente para a fila auxiliar
         assertTrue(fila.filaAuxiliar.contains(senhaNormal), "A senha normal deve estar na fila auxiliar");
         assertTrue(fila.filaAuxiliar.contains(senhaPreferencial), "A senha preferencial deve estar na fila auxiliar");
     }
 
     @Test
     void testGetUltimaSenhaNormal() {
         fila.adicionarSenhaNormal(senhaNormal);
         assertEquals(1, fila.getUltimaSenhaNormal(), "A última senha normal deve ser 1");
     }
 
     @Test
     void testGetUltimaSenhaPreferencial() {
         fila.adicionarSenhaPreferencial(senhaPreferencial);
         assertEquals(2, fila.getUltimaSenhaPreferencial(), "A última senha preferencial deve ser 2");
     }
 }