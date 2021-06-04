package Controller;

import java.util.HashMap;
import java.util.Map;

public class LoginController {

    private Map<String, String> cadastrados = new HashMap<String, String>();

    public boolean validarUsuario(String usuario, String senha){
        String s = cadastrados.get(usuario);
        if(s.equals(senha)){
            return true;
        }
        return false;
    }

    public void setCadastrados(Map<String, String> cadastrados) {
        this.cadastrados = cadastrados;
    }
}
