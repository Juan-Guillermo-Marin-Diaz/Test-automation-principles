import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private UsuarioService us;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        us = new UsuarioService();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void agregarusuarioExitoso() {

        String resultado = us.agregarUsuario("NuevoUsuario", "123", false);

        assertEquals("Usuario agregado exitosamente.", resultado);
        assertEquals(1, us.getUsuarios().size());
        //assertTrue(us.getUsuarios().isEmpty());

        System.out.println(us.getUsuarios().isEmpty());


    }

    @Test
    void agregarusuarioExistente() {
        us.agregarUsuario("UsuarioExistente", "321", true);

        String resultado = us.agregarUsuario("UsuarioExistente", "000", false);

        assertEquals("El nombre de usuario ya existe.", resultado);
    }

    @org.junit.jupiter.api.Test
    void depositar() {
        us.agregarUsuario("UsuarioExistente", "321", true);
        String respuesta = us.depositar("UsuarioExistente", 100);

        assertEquals(us.getUsuarios().get("UsuarioExistente").getBalance(), 100);
        assertEquals("Depósito exitoso.", respuesta);
    }

    @Test
    void depositarError() {
        //us.agregarUsuario("UsuarioExistente", "321", true);
        String respuesta = us.depositar("UsuarioNoEncontrado", 100);

        //assertEquals(us.getUsuarios().get("UsuarioNoEncontrado").getBalance(), 0);
        assertEquals("Usuario no encontrado.", respuesta);
    }

    @org.junit.jupiter.api.Test
    void retirar() {
        us.agregarUsuario("UsuarioExistente", "321", false);
        us.depositar("UsuarioExistente", 100);

        assertEquals(us.getUsuarios().get("UsuarioExistente").getBalance(), 100);
        String respuesta = us.retirar("UsuarioExistente", 50);
        assertEquals(us.getUsuarios().get("UsuarioExistente").getBalance(), 50);
        assertEquals("Retiro exitoso.", respuesta);

    }

    @org.junit.jupiter.api.Test
    void transferir() {
        us.agregarUsuario("Usuario1Existente", "321", false);
        us.agregarUsuario("Usuario2Existente", "321", false);

        us.depositar("Usuario1Existente", 100);

       String respuesta = us.transferir("Usuario1Existente", "Usuario2Existente", 50);

        assertEquals(us.getUsuarios().get("Usuario1Existente").getBalance(), 50);
        assertEquals(us.getUsuarios().get("Usuario2Existente").getBalance(), 50);
        assertEquals("Transferencia exitosa.", respuesta);
    }
}