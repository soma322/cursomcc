package interprete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Interprete {
      // Tabla Hash para almacenar las memoria
    
    Memoria memoria;
    public Interprete() {
        memoria = new Memoria();
    }

    // Método para evaluar expresiones postfix
    private Object evaluarExpresion(List<String> expresion, String tipoVariableFinal) {
        Stack<Object> pila = new Stack<>();
        Stack<Object> pilaExpresiones = new Stack<>();

        for (String token : expresion) {
            if (esOperador(token)) {
                
                Object op2 = pila.pop();
                Object op1 = pila.pop();
                pila.push(realizarOperacion(token, op1, op2,tipoVariableFinal));
               
            } else {
               
                if (memoria.existeVariable(token)) {
                    pila.push(memoria.obtenerValor(token));
                } else {
                  
                    try {
                        int value = Integer.parseInt(token);
                        pila.push(value);
                    } catch (NumberFormatException e) {

                        // Handle other types of data or errors
                        return null;
                    }
                }
            }
        }


   
        return pila.pop();
    }

    // Método para realizar operaciones
    private Object realizarOperacion(String operador, Object op1, Object op2, String tipoVariableFinal) {
        
        if (op1 instanceof Number && op2 instanceof Number) {
            Number valorOp1 = (Number) op1;
            Number valorOp2 = (Number) op2;
    
            if (op1 instanceof Integer && op2 instanceof Integer && tipoVariableFinal.equals("entero")) {// agregar el real
                int intOp1 = valorOp1.intValue();
                int intOp2 = valorOp2.intValue();
    
                switch (operador) {
                    case "+":
                        return intOp1 + intOp2;
                    case "-":
                        return intOp1 - intOp2;
                    case "*":
                        return intOp1 * intOp2;
                    case "/":
                        return intOp1 / intOp2; // Integer division
                    default:
                        return null;
                }
            } else {
                float floatOp1 = valorOp1.floatValue();
                float floatOp2 = valorOp2.floatValue();
    
                switch (operador) {
                    case "+":
                        return floatOp1 + floatOp2;
                    case "-":
                        return floatOp1 - floatOp2;
                    case "*":
                        return floatOp1 * floatOp2;
                    case "/":
                        return floatOp1 / floatOp2;
                    default:
                        return null;
                }
            }
        } else {
           
            return null;
        }
       
    }
    private List<String> infixToPostfix(List<String> expression) {
        List<String> postfixExpression = new ArrayList<>();
        Stack<String> operators = new Stack<>();
    
        HashMap<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
    
        for (String token : expression) {
            if (esOperador(token)) {
                while (!operators.isEmpty() && precedence.getOrDefault(operators.peek(), 0) >= precedence.get(token)) {
                    postfixExpression.add(operators.pop());
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    postfixExpression.add(operators.pop());
                }
                operators.pop(); // Discard the "("
            } else {
                postfixExpression.add(token);
            }
        }
    
        while (!operators.isEmpty()) {
            postfixExpression.add(operators.pop());
        }
    
        return postfixExpression;
    }

    // Método para verificar si es un operador
    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/");
    }

  

    // Método principal para ejecutar el programa MLP
    public void ejecutarPrograma(List<String> programa) {
        List<String> expresion = null;
        List<String> postfixExpresion = null;
        Object resultadoExpresion = null;
        HashValores valor = null;
        String nomVariable = "";
        String tipoVariable = "";
        String[] partes = new String[programa.size()];


        for (String instruccion : programa) {
            // Dividir la instrucción en commando
            String[] commando = instruccion.split(" ");
            
            if(commando.length > 2 && commando[0].equals("imprime")){
                partes = instruccion.replace("imprime ", "").split("\\s*\\+\\s*");
            }

            // Identificar el tipo de instrucción y ejecutarla
            switch (commando[0]) {
                case "entero":
                    tipoVariable = commando[0];
                    nomVariable = commando[1];
                    
                    if(memoria.existeVariable(nomVariable)){
                        System.out.println("ERROR: Variable "+nomVariable+" ya fue declarada. Favor de verificar lista de commandos");
                        throw new EmptyStackException();
                    }

                    if(commando.length == 2){
                        valor = new HashValores("entero", 0);
                        memoria.asignarVariable(nomVariable, valor);
                        break;
                    }

                    expresion = Arrays.asList(commando).subList(3, commando.length);
                    
                    // Evaluar la expresión
                    postfixExpresion = infixToPostfix(expresion);
                    resultadoExpresion = evaluarExpresion(postfixExpresion, tipoVariable);

                    valor = new HashValores("entero", resultadoExpresion);
                    memoria.asignarVariable(commando[1], valor);
                    break;

                case "real":
                    tipoVariable = commando[0];
                    nomVariable = commando[1];
                    if(memoria.existeVariable(nomVariable)){
                        System.out.println("ERROR: Variable "+nomVariable+" ya fue declarada. Favor de verificar lista de commandos");
                        throw new EmptyStackException();
                    }
                    // Manejar instrucción de asignación de variable real
                    if(commando.length == 2){
                        valor = new HashValores("real", 0.0);
                        memoria.asignarVariable(commando[1], valor);
                        break;
                    }
                    expresion = Arrays.asList(commando).subList(3, commando.length);
                    
                    // Evaluar la expresión
                    postfixExpresion = infixToPostfix(expresion);
                    resultadoExpresion = evaluarExpresion(postfixExpresion, tipoVariable);
                    
                    // Asignar el resultado a la variable
                    valor = new HashValores("real", resultadoExpresion);
                    memoria.asignarVariable(commando[1], valor);
                    break;

                case "cadena":
                    tipoVariable = commando[0];
                    nomVariable = commando[1];
                     // Manejar instrucción de asignación de variable real
                    String mensajeCadena = "";

                    if(memoria.existeVariable(nomVariable)){
                        System.out.println("ERROR: Variable "+nomVariable+" ya fue declarada. Favor de verificar lista de commandos");
                        throw new EmptyStackException();
                    }

                    if(commando.length == 2){
                        valor = new HashValores(tipoVariable, "");
                        memoria.asignarVariable(nomVariable, valor);
                        break;
                    }
                    expresion = Arrays.asList(commando).subList(3, commando.length);
                    
                    for (String cadena : expresion) {
                        mensajeCadena = mensajeCadena + cadena + " ";
                    }
                    
                    // Asignar el resultado a la variable
                    valor = new HashValores(tipoVariable, mensajeCadena);
                    memoria.asignarVariable(nomVariable, valor);
                    break;
                case "leer":
                    Leer scan = new Leer();
                    if( memoria.existeVariable(commando[1])){
                        String value = memoria.obtenerTipo(commando[1]);
                        switch (value) {
                            case "entero":
                                int valorInt = scan.leerInt("Escribe el valor entero de "+ commando[1]+" :");
                                memoria.actualizarVariable(commando[1], valorInt);
                                break;
                            case "real":
                                float valorFloat = scan.leerFloat("Escribe el valor real de: "+ commando[1]+" :");
                                memoria.actualizarVariable(commando[1], valorFloat);
                                break;
                            case "string":
                                String valorString = scan.leerString("Escribe el valor string de: "+ commando[1]+" :");
                                memoria.actualizarVariable(commando[1], valorString);
                                break;
                            default:

                                break;
                        }
                    }
                    
                    
                    break;
                case "imprime":
                    String mensaje = "";
                    
                    if (commando.length == 2 ){ // imprime una variable
                         if(memoria.existeVariable(commando[1])){
                            System.out.println(memoria.obtenerValor(commando[1]));

                         }else{
                            System.out.println("ERROR: Variable "+commando[1]+" no existe en memoria. Favor de verificar lista de commandos");
                            throw new EmptyStackException();
                         }
                    }else{
                        for(int i = 0; i < partes.length; i++){
                            if(partes[i].charAt(0) != '"'){ // es una variable
                                if(memoria.existeVariable(partes[i])){
                                mensaje = mensaje + " " + memoria.obtenerValor(partes[i]);

                                }else{
                                    System.out.println("Commando " + partes[i] + "contiene commandos invalidos");
                                }
                            }else if(partes[i].charAt(0) == '"'){ // es una cadena
                                mensaje = mensaje + " " + partes[i].replace("\"", "");
                            }
                            

                        }
                        
                    }
                    break;
                    /*
                    if(memoria.existeVariable(commando[1])){
                        System.out.print(memoria.obtenerValor(commando[1]));

                        if(commando.length > 2){
                            for (int i = 2; i < commando.length; i++){
                                if(commando[i].equals("+") && commando[i+1].equals("\\\"")){

                                    i = i + 2;
                                    mensaje = mensaje + " "+commando[i];
                                }else{

                                }
                            }
                        }
                        break;
                    }else{
                       
                        for (int i = 1; i < commando.length; i++) {
                            if(commando[i].equals("+")){
                                if(!memoria.existeVariable(commando[i+1])){
                                    mensaje = mensaje + " " +memoria.obtenerValor(commando[i+1]);
                                    i++;
                                    continue;
                                }else{
                                     System.out.println("ERROR: Variable "+commando[i+1]+" no existe en memoria. Favor de verificar lista de commandos");
                                    throw new EmptyStackException();
                                }
                            }

                            mensaje = mensaje + " "+commando[i];
                        }
                        System.out.println(mensaje);
                        break;
                    }
                    */
                   
                  
                default:
                    // asignar variable
                    if(memoria.existeVariable(commando[0])){
                        if(commando[1].equals("=")){ // validar si existe la memoria
                            List<String> expresion2 = Arrays.asList(commando).subList(2, commando.length);
                            List<String> postfixExpresion2 = infixToPostfix(expresion2);
                            Object resultadoExpresion2 = evaluarExpresion(postfixExpresion2, memoria.obtenerTipo(commando[0]));
                            
                            valor = new HashValores(memoria.obtenerTipo(commando[0]), resultadoExpresion2);
                            memoria.asignarVariable(commando[0], valor);
                            break;
                        }
                    }else{
                        System.out.println("ERROR: Variable "+commando[0]+" no declarada, favor de verificar commandos");
                        throw new EmptyStackException();
                    }
                    
                    break;
               
            }
        }
    }
}
