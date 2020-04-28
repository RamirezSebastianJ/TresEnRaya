
package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PrincipalControlador implements ActionListener{
    
    VistaPrincipal ventanaPrincipal;
    PrincipalLogica controlLogica;
    
    public PrincipalControlador(){}
    
    public PrincipalControlador(PrincipalLogica controlLogica, VistaPrincipal ventanaPrincipal){
        this.controlLogica = controlLogica;
        this.ventanaPrincipal = ventanaPrincipal;
    
        //Botonoes del Tablero de Juego
        
        this.ventanaPrincipal.Casilla1.addActionListener(this);
        this.ventanaPrincipal.Casilla2.addActionListener(this);
        this.ventanaPrincipal.Casilla3.addActionListener(this);
        this.ventanaPrincipal.Casilla4.addActionListener(this);
        this.ventanaPrincipal.Casilla5.addActionListener(this);
        this.ventanaPrincipal.Casilla6.addActionListener(this);
        this.ventanaPrincipal.Casilla7.addActionListener(this);
        this.ventanaPrincipal.Casilla8.addActionListener(this);
        this.ventanaPrincipal.Casilla9.addActionListener(this);
        
        //Boton para visualizar el turno
        this.ventanaPrincipal.Turno.addActionListener(this);
        
    }
    
    public void iniciar(){
        ventanaPrincipal.setTitle("Triki");
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setResizable(false);
        controlLogica.llenarMatriz();
    }
    
    //Limpiar los botonos en caso de reiniciar el juego
    public void limpiar(){
        controlLogica.llenarMatriz();
        ventanaPrincipal.Casilla1.setText("");
        ventanaPrincipal.Casilla1.setEnabled(true);
        ventanaPrincipal.Casilla2.setText("");
        ventanaPrincipal.Casilla2.setEnabled(true);
        ventanaPrincipal.Casilla3.setText("");
        ventanaPrincipal.Casilla3.setEnabled(true);
        ventanaPrincipal.Casilla4.setText("");
        ventanaPrincipal.Casilla4.setEnabled(true);
        ventanaPrincipal.Casilla5.setText("");
        ventanaPrincipal.Casilla5.setEnabled(true);
        ventanaPrincipal.Casilla6.setText("");
        ventanaPrincipal.Casilla6.setEnabled(true);
        ventanaPrincipal.Casilla7.setText("");
        ventanaPrincipal.Casilla7.setEnabled(true);
        ventanaPrincipal.Casilla8.setText("");
        ventanaPrincipal.Casilla8.setEnabled(true);
        ventanaPrincipal.Casilla9.setText("");
        ventanaPrincipal.Casilla9.setEnabled(true);
        ventanaPrincipal.Turno.setText("Juega el 1");    
    }
    
    //Poner en la casilla el Simbolo del jugador que la Tocó
    public JButton modificarBoton (JButton casilla, int a){
        JButton e = casilla;
        if(a == 1){
            e.setText("X");
        }else{
            e.setText("0");
        }
        e.setEnabled(false);
        return e;
    }
    
    //Preguntar si se desea reiniciar o salir
    public void continuar(){
        int a = JOptionPane.showConfirmDialog(null, "Seguir Jugando ?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(a == 1){
            System.exit(0);
        }else{
            limpiar();
        }
    }
    

    /*
    *Se identifica que boton fue presionado, se manda a buscar en el control logico si el jugador ha ganado
    *con modificarBoton() se modifica el texto del boton con el simbolo del jugador
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton casilla = (JButton) e.getSource();
        
        if(casilla == this.ventanaPrincipal.Casilla1){
            controlLogica.setPosiciones(0, 0);   
            ventanaPrincipal.Casilla1 = modificarBoton(ventanaPrincipal.Casilla1,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla2){
            controlLogica.setPosiciones(0, 1);
            ventanaPrincipal.Casilla2 = modificarBoton(ventanaPrincipal.Casilla2,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla3){
            controlLogica.setPosiciones(0, 2);  
            ventanaPrincipal.Casilla3 = modificarBoton(ventanaPrincipal.Casilla3,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla4){
            controlLogica.setPosiciones(1, 0);  
            ventanaPrincipal.Casilla4 = modificarBoton(ventanaPrincipal.Casilla4,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla5){
            controlLogica.setPosiciones(1, 1);   
            ventanaPrincipal.Casilla5 = modificarBoton(ventanaPrincipal.Casilla5,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla6){
            controlLogica.setPosiciones(1, 2);    
            ventanaPrincipal.Casilla6 = modificarBoton(ventanaPrincipal.Casilla6,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla7){
            controlLogica.setPosiciones(2, 0);
            ventanaPrincipal.Casilla7 = modificarBoton(ventanaPrincipal.Casilla7,controlLogica.turno);   
        }
        
        if(casilla == this.ventanaPrincipal.Casilla8){
            controlLogica.setPosiciones(2, 1);   
            ventanaPrincipal.Casilla8 = modificarBoton(ventanaPrincipal.Casilla8,controlLogica.turno);   
        }
        if(casilla == this.ventanaPrincipal.Casilla9){
            controlLogica.setPosiciones(2, 2); 
            ventanaPrincipal.Casilla9 = modificarBoton(ventanaPrincipal.Casilla9,controlLogica.turno);   
        }

        //Identificar de quien es el suiguiente Turno
        if(controlLogica.turno == 1){
            ventanaPrincipal.Turno.setText("Juega el 2");
        }else{
            ventanaPrincipal.Turno.setText("Juega el 1");
        }
        
        int a = controlLogica.setMatriz();
        switch(a){
            case 1:
                JOptionPane.showMessageDialog(null,"Gana el Jugador 1");
                continuar();
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"Gana el Jugador 2");
                continuar();
                break;
            case -1:
                JOptionPane.showMessageDialog(null,"Tablas");
                continuar();
                break;
        } 
    }
}

