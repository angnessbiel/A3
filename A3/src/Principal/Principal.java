package Principal;

import View.TelaLogin;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Font;
import javax.swing.UIManager;

public class Principal {

    public static void main(String[] args) {

        try {
            FlatMacLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Falha ao iniciar o LaF: " + ex.getMessage());
        }
        
        UIManager.put("defaultFont", new Font("SansSerif", Font.PLAIN, 13));

        TelaLogin objetotela = new TelaLogin();
        objetotela.setVisible(true);
    }
}