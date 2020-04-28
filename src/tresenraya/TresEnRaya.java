
package tresenraya;

import MVC.PrincipalControlador;
import MVC.PrincipalLogica;
import MVC.VistaPrincipal;


public class TresEnRaya {

    public static void main(String[] args) {
        
        VistaPrincipal vista = new VistaPrincipal();
        PrincipalLogica logica = new PrincipalLogica();
        PrincipalControlador control = new PrincipalControlador(logica,vista );

        control.iniciar();
        vista.setVisible(true);
        
    }
}
