import java.util.ArrayList;
import java.util.Scanner;

public class MiParteAL {
    String caracter, buffer, aux = "";
    int posicion=0;

    String[] reservadas = {"numEn","numRe","letra","oracion","logico","proceso", "grupo", "correcto", "incorrecto", "devuelve", "casoContrario", "bucle", "biblioteca", "iniciador", "entrada", "salida", "enter", "entradaOra","permanente"};
    String[] operador_1 = {"(",")",":","[","]","$","#","°","*","+","%",";","}",">","-"};

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

        caracter = caracter + "&";
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
                case 300:
                    aniadir = "300 Num. Entero ";
                    aniadir += buffer;
                    tabla1.add(aniadir);
                    break;
                case 301:
                    aniadir = "301 Num. Decimal ";
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
                case 2000:
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                case 2006:
                case 2007:
                case 2008:
                case 2009:
                case 2010:
                case 2011:
                case 2012:
                case 2013:
                case 2014:
                case 2015:
                case 2016:
                case 2017:
                case 2018:
                case 2019:
                case 2020:
                case 2021:
                case 2022:
                case 2023:
                case 2024:
                case 2025:
                    aniadir = t + " Operador " + buffer;
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
        
        int i = 0, e = 0, u=0;
        char a;
        buffer = "";
        buffer += aux;
        
        aux = "";
        ArrayList<Character> diferentes = new ArrayList<>();
        while(true){
            a = caracter.charAt(posicion);
            
            if(a=='&' && i==0){
                return 0;
            }
            else{
                if (a == '&') {
                    switch(e){
                        case 1:  
                            return 300;
                        case 2: 
                            if(i>=3 && u>=3){ 
                            return Reservada(buffer);
                            }
                            else{
                                return 1000; //habria un identificador con menos de 3 caracteres justo antes de terminar la cadena
                            }
                        case 3:
                            return 2016;
                        case 4:
                            return 2018;
                        case 5:
                            return 2019;
                        case 6:
                            return 1000;
                        case 7:
                            return 1000;
                        case 8:
                            return 1000;
                        case 10:
                            return 301;
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
                                if(Character.isAlphabetic(a) || a == '_'){
                                    e = 2;  

                                    diferentes.add(a);
                                    u++;

                                    i++;
                                }
                                else{
                                    if(Operador(a)>=2000){
                                        posicion++;
                                        return Operador(a);
                                    }
                                    else{
                                        if(a == '{'){
                                            e = 3;
                                            i++;
                                        }
                                        else{
                                            if(a == '<'){
                                                e = 4;
                                                i++;
                                            }
                                            else{
                                                if(a == '='){
                                                    e = 5;
                                                    i++;
                                                }
                                                else{
                                                    if(a == '?'){
                                                        e = 6;
                                                        i++;
                                                    }
                                                    else{
                                                        if(a == '!'){
                                                            e = 7;
                                                            i++;
                                                        }
                                                        else{
                                                            if(a == '/'){
                                                                e = 8;
                                                                i++;
                                                            }
                                                            else{
                                                                if(a != ' '){
                                                                    return 1000; //bota error y acaba el programa, el posicion++ no es necesario
                                                                }
                                                                else{
                                                                    e = 0; //no se para que sirve pero el profe lo tiene en su programa
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        break;

                        case 1: 
                            if(Character.isDigit(a)){
                                if("0.".equals(buffer)){
                                    buffer += a;
                                    e = 10;
                                }
                                else{
                                    buffer += a;
                                    e = 1;
                                }
                            }
                            else{
                                if(a == '.'){
                                    buffer += a;
                                    e = 10;
                                }
                                else{
                                    
                                    return 300; //numero
                                }
                            }
                            i++;
                        break;    

                        case 2: 
                            if(Character.isDigit(a) || Character.isAlphabetic(a) || a == '_'){
                                buffer += a;

                                if(!diferentes.contains(a)){
                                    diferentes.add(a);
                                    u++;
                                }

                                e=2;
                            }
                            else{
                                if(i>=3 && u>=3){
                                    System.out.println(u);
                                    return Reservada(buffer);
                                }
                                else{
                                    return 1000; //habria un identificador con menos de 3 caracteres
                                }
                            }
                            i++;
                        break;

                        case 3:
                            if(a == '='){
                                buffer += a;
                                posicion++;
                                return 2015;
                            }
                            else{
                                return 2016;
                            }
                        
                        case 4:
                            if(a == '-'){
                                buffer += a;
                                i++;
                                e = 9;
                            }
                            else{
                                return 2018;
                            }
                            break;
                        
                        case 5:
                            if(a == '}'){
                                buffer += a;
                                posicion++;
                                return 2019;
                            }
                            else{
                                return 2020;
                            }
                        
                        case 6:
                            if(a == '?'){
                                buffer +=a;
                                posicion++;
                                return 2021;
                            }
                            else{
                                if(a == '!'){
                                    buffer += a;
                                    posicion++;
                                    return 2022;
                                }
                                else{
                                    return 1000;
                                 }
                            }
                        
                        case 7:
                            if(a == '!'){
                                buffer +=a;
                                posicion++;
                                return 2023;
                            }
                            else{
                                return 1000;
                            }
                        
                        case 8:
                            if(a== '/'){
                                buffer += a;
                                posicion++;
                                return 2024;
                            }
                            else{
                                return 2025;
                            }
                        case 9:
                            if(a == '>'){
                                buffer += a;
                                posicion++;
                                return 2017;
                            }
                            else{
                                posicion++;
                                return 1000; //arroja error ya que en el buffer habria "<-" pero no le seguiria un '>'
                            }

                        case 10:
                            if(Character.isDigit(a)){
                                buffer += a;
                                e = 10;
                            }
                            else{
                                if(a == '.'){
                                    aux = "0.";
                                    posicion++;
                                    return 301; //el unico problema es que el siguiente decimal lo imprimirá como entero
                                }
                                return 301;
                            }
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

    public int Operador(char a){
        String caracter = String.valueOf(a);

        for(int i=0;i<operador_1.length;i++){
            if(caracter.equals(operador_1[i])){
                return 2000 + i;
            }
        }
        return 1000; 
    }
}