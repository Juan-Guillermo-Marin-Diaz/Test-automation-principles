import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UsuarioService {

    private Map<String, Usuario> usuarios = new HashMap<>();

    public String agregarUsuario(String username, String password, boolean isAdmin) {
        if (usuarios.containsKey(username)) {
            return "El nombre de usuario ya existe.";
        }
        usuarios.put(username, new Usuario(username, password, 0.0, isAdmin));
        return "Usuario agregado exitosamente.";
    }

    public String depositar(String username, double monto) {
        Usuario user = usuarios.get(username);
        if (user != null) {
            user.setBalance(user.getBalance() + monto);
            return "Depósito exitoso.";
        }
        return "Usuario no encontrado.";
    }

    public String retirar(String username, double monto) {
        Usuario user = usuarios.get(username);
        if (user != null) {
            if (user.getBalance() >= monto) {
                user.setBalance(user.getBalance() - monto);
                return "Retiro exitoso.";
            } else {
                return "Fondos insuficientes.";
            }
        }
        return "Usuario no encontrado.";
    }

    public String transferir(String remitenteUsername, String destinatarioUsername, double monto) {
        Usuario remitente = usuarios.get(remitenteUsername);
        Usuario destinatario = usuarios.get(destinatarioUsername);

        if (remitente != null && destinatario != null) {
            if (remitente.getBalance() >= monto) {
                remitente.setBalance(remitente.getBalance() - monto);
                destinatario.setBalance(destinatario.getBalance() + monto);
                return "Transferencia exitosa.";
            } else {
                return "Fondos insuficientes para el remitente.";
            }
        }
        return "Uno o ambos usuarios no encontrados.";
    }

}
