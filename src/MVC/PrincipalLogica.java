
package MVC;

public class PrincipalLogica {
    int suma = 0;
    boolean ganador = false;
    int matriz  [] [] = new int [3] [3]; //matriz esencial del triki
    int fila, columna;
    int turno; //Debe oscilar entre 1 y 2 
    int clicks; //se tiene parar saber cuantas turnos van 
    
    public PrincipalLogica(){}

    public void llenarMatriz(){
        for(int i = 0; i < 3; i++){
            for(int j= 0; j < 3; j++){
                matriz[i][j] = 0;
            }
        }
        this.turno = 1;
        this.clicks = 1;
    }

    //Se captura la posicion de la casilla presionada
    public void setPosiciones(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
        clicks++; 
    }
    
    //Se modifica la matriz esencial  y se busca si alguien ha ganado
    public int setMatriz(){
        int a = 0;
        if(turno==1){
            matriz [fila] [columna] = 2;
            this.turno = 2;
        }else{
            matriz [fila] [columna] = 7;
            this.turno = 1;
        }

        if(clicks > 4 && clicks<=10){
            a = getGanador();
            if( a==0 && clicks >= 10){
                return -1;
            }
            return a;
        }
    
        return 0;
    }
    
    
    //Se busca un ganador Horizontal,vertical o diagonal
    public int getGanador(){
        //Para los Horizontales
        for(int i = 0; i < 3; i++){
            this.suma = 0;
            for(int j= 0; j < 3; j++){
                if(matriz[i][j] != 0){
                    suma =  suma + matriz[i][j];
                }                
            } 
            switch(suma){
                case 6:
                    return 1;
                case 21:
                    return 2;
            }
        }
        
        //Para los Verticales
        for(int i = 0; i < 3; i++){
            this.suma = 0;
            for(int j= 0; j < 3; j++){
                if(matriz[j][i] != 0){
                    suma =  suma + matriz[j][i];
                }
            }
            switch(suma){
                case 6:
                    return 1;
                case 21:
                    return 2;
            }
        }

        //Para las Diagonales
        this.suma = 0;
        int j=2;
        for(int i = 0; i < 3; i++){
            if(matriz[i][j] != 0){
                suma =  suma + matriz[j][i];
            }
            j--;
        }

        switch(suma){
            case 6:
                return 1;
            case 21:
                return 2;
        }
        
        this.suma = 0;
        j = 0;
        for(int i = 0; i < 3; i++){
            if(matriz[i][j] != 0){
                suma =  suma + matriz[i][j];
            }
            j++;
        }
        
        switch(suma){
            case 6:
                return 1;
            case 21:
                return 2;
        }
        
        return 0;
    }
}
