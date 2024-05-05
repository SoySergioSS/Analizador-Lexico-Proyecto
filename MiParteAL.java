import java.util.ArrayList;
import java.util.Scanner;

public class MiParteAL {
    String caracter, buffer;
    int posicion=0;

    String[] reservadas = {"numEn","numRe","letra","oracion","logico","proceso", "grupo", "correcto", "incorrecto", "devuelve", "casoContrario", "bucle", "biblioteca", "iniciador", "entrada", "salida", "enter", "entradaOra","permanente"};
    String[] operador_1 = {"(",")",":","[","]","$","#","°","*","+","*",";","}",">","-"};

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
        
        int i = 0, e = 0;
        char a;
        buffer = "";
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
                            return Reservada(buffer);
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
                                    if(VerificarOperador(a)){
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
                                                                    posicion++;
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
                                return 1000;
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
        return 1000; //en teoria nunca deberia entrar aca xd
    }

    public boolean VerificarOperador(char a){
        String caracter = String.valueOf(a);

        for(int i=0;i<operador_1.length;i++){
            if(caracter.equals(operador_1[i])){
                return true;
            }
        }
        return false;
    }
}