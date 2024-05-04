import java.util.ArrayList;
import java.util.Scanner;

public class MiParteAL {
    String caracter, buffer;
    int posicion=0;

    String[] reservadas = {"numEn","numRe","letra","oracion","logico","proceso", "grupo", "correcto", "incorrecto", "devuelve", "casoContrario", "bucle", "biblioteca", "iniciador", "entrada", "salida", "enter", "entradaOra","permanente"};
    
    public static void main(String[] args) {
        MiParteAL iniciar = new MiParteAL();
        iniciar.Escaner();
    }
    
    public void Escaner(){
        Scanner entrada = new Scanner(System.in);

        ArrayList<String> tabla1 = new ArrayList<>();
        ArrayList<String> tabla2 = new ArrayList<>();
        
        int t;
        boolean salir = true;
        String aniadir;
        
        System.out.print("Ingrese la cadena: ");
        caracter = entrada.nextLine();

        entrada.close();

        caracter = caracter + "#";
        do{
            t = Scanner();
            switch(t){
                case 0:
                    System.out.println("Programa finalizado");
                    System.out.println("TABLA DE ANALISIS GENERAL:");
                    for(String imprimir : tabla1){
                        System.out.println(imprimir);
                    }
                    System.out.println("\nTABLA DE INDENTIFICADORES: ");
                    for(String imprimir : tabla2){
                        System.out.println(imprimir);
                    }
                    salir = false;
                    break;
                case 100:
                    aniadir = "100 Id ";
                    aniadir += buffer;
                    tabla1.add(aniadir);
                    tabla2.add(aniadir);
                    break;
                case 101:
                    aniadir = "101 Operador ";
                    aniadir += buffer;
                    tabla1.add(aniadir);
                    break;
                case 102:
                    aniadir = "102 Operador ";
                    aniadir += buffer;
                    tabla1.add(aniadir);
                    break;
                case 200:
                    aniadir = "200 Operador ";
                    aniadir += buffer;
                    tabla1.add(aniadir);
                    break;
                case 300:
                    aniadir = "300 Numero ";
                    aniadir += buffer;
                    tabla1.add(aniadir);
                    break;
                case 400:
                case 401:
                case 402:
                case 403:
                case 404:
                case 405:
                case 406:
                case 407:
                case 408:
                case 409:
                case 410:
                case 411:
                case 412:
                case 413:
                case 414:
                case 415:
                case 416:
                case 417:
                case 418:
                    aniadir = t + " Pal.Reserv. " + buffer;
                    tabla1.add(aniadir);
                    break;
                default:
                    System.out.println("FINALIZO POR ERROR");
                    salir = false;
                    break;
            }
        }while(salir == true);
    }
    
    public int Scanner(){
        
        int i = 0, e = 0;
        char a;
        buffer = "";
        while(true){
            a = caracter.charAt(posicion);
            
            if(a=='#' && i==0){
                return 0;
            }
            else{
                if (a == '#') {
                    switch(e){
		        case 1:  return 300;
		        case 2:  return Reservada(buffer);
		    }
                }
                else{
                    buffer = buffer.trim(); // Eliminar espacios en blanco alrededor del buffer
                    switch(e){
                        case 0:
                            buffer += a;
                            if (Character.isDigit(a)) {
                                e = 1;
                                i++;
                            }
                            else{
                                if(Character.isAlphabetic(a)){
                                    e = 2;  
                                    i++;
                                }
                                else{
                                    if(a == '('){
                                        posicion++;
                                        return 101;
                                    }
                                    else{
                                        if(a == ')'){
                                            posicion++;
                                            return 102;
                                        }
                                        else{
                                            if(a == ':'){
                                                posicion++;
                                               return 200; 
                                            }
                                            else{
                                                if(a != ' '){
                                                    posicion++;
                                                    return 1000;
                                                }
                                                else{
                                                    e = 0;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        break;

                        case 1: 
                            if(Character.isDigit(a)){
                                buffer += a;
                                e = 1;
                            }
                            else{
                                return 300; //numero
                            }
                            i++;
                        break;    

                        case 2: 
                            if(Character.isDigit(a) || Character.isAlphabetic(a)){
                                buffer += a;
                                e=2;
                            }
                            else{
                                return Reservada(buffer);
                            }
                            i++;
                        break;
                    }
                    posicion++;
                }
            }
        }
    }
    
    public int Reservada(String buffer){     
        for(int i=0;i<reservadas.length;i++){
            if(buffer.equals(reservadas[i])){
                return 400 + i;
            }
        }
        return 100;
    }
}