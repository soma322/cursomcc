package interprete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Interprete {
      // Tabla Hash para almacenar las memoria
    
    Memoria memoria;
    public Interprete() {
        memoria = new Memoria();
    }

    public Object obtenerVariable(String valor) {
        return memoria.obtenerVariable(valor);
    }

    // Método para evaluar expresiones postfix
    private Object evaluarExpresion(List<String> expresion) {
        Stack<Object> pila = new Stack<>();
        Stack<Object> pilaExpresiones = new Stack<>();

        for (String token : expresion) {
            if (esOperador(token)) {
                // Evaluar operadores
                // Realizar operaciones y apilar resultados
                pilaExpresiones.push(token);
            } else {
                // If it is a variable, obtain its value from the memoria HashMap
                if (memoria.existeVariable(token)) {
                    pila.push(memoria.obtenerVariable(token));
                } else {
                    // If it is a numeric value, parse it to Integer and apil it
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


        while (!pilaExpresiones.isEmpty()) {
            Object op2 = pila.pop();
            Object op1 = pila.pop();
            pila.push(realizarOperacion((String) pilaExpresiones.pop(), op1, op2));
        }
        // The final result will be at the top of the stack
        return pila.pop();
    }

    // Método para realizar operaciones
    private Object realizarOperacion(String operador, Object op1, Object op2) {
        
            int valorOp1 = (int) op1;
            int valorOp2 = (int) op2;
            
            switch (operador) {
                case "+":
                    return valorOp1 + valorOp2;
                case "-":
                    return valorOp1 - valorOp2;

                case "*":
                    return valorOp1 * valorOp2;
                   
                case "/":
                    return valorOp1 / valorOp2;

                default:
                     return null;
            }
          
            // Agregar más operaciones según sea necesario
        
        // Manejar otros tipos de datos o errores
       
    }
    private List<String> infixToPostfix(List<String> expresion) {
    List<String> postfixExpresion = new ArrayList<>();
    Stack<String> operadores = new Stack<>();

    HashMap<String, Integer> precedencia = new HashMap<>();
    precedencia.put("+", 1);
    precedencia.put("-", 1);
    precedencia.put("*", 2);
    precedencia.put("/", 2);

    for (String token : expresion) {
        if (esOperador(token)) {
            while (!operadores.isEmpty() && precedencia.getOrDefault(operadores.peek(), 0) >= precedencia.get(token)) {
                postfixExpresion.add(operadores.pop());
            }
            operadores.push(token);
        } else if (token.equals("(")) {
            operadores.push(token);
        } else if (token.equals(")")) {
            while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                postfixExpresion.add(operadores.pop());
            }
            operadores.pop(); // Eliminar el "("
        } else {
            postfixExpresion.add(token);
        }
    }

    while (!operadores.isEmpty()) {
        postfixExpresion.add(operadores.pop());
    }

    return postfixExpresion;
}

    // Método para verificar si es un operador
    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/");
        // Agregar otros operadores si es necesario
    }

    // Método principal para ejecutar el programa MLP
    public void ejecutarPrograma(List<String> programa) {
        List<String> expresion = null;
        List<String> postfixExpresion = null;
        Object resultadoExpresion = null;
        HashValores valor = null;
        for (String instruccion : programa) {
            // Dividir la instrucción en tokens
            String[] tokens = instruccion.split(" ");
            
            // Identificar el tipo de instrucción y ejecutarla
            switch (tokens[0]) {
                case "entero":
                    String variable = tokens[1];
                    
                    if(tokens.length == 2){
                        valor = new HashValores("entero", 0);
                        memoria.asignarVariable(variable, valor);
                        break;
                    }

                    expresion = Arrays.asList(tokens).subList(2, tokens.length);
                    
                    // Evaluar la expresión
                    postfixExpresion = infixToPostfix(expresion);
                    resultadoExpresion = evaluarExpresion(postfixExpresion);
                    //HashValores valor = new HashValores("entero", resultadoExpresion);
                    // Asignar el resultado a la variable
                    //memoria.asignarVariable(variable, resultadoExpresion);
                    break;
                case "real":
                    // Manejar instrucción de asignación de variable real
                    if(tokens.length == 2){
                        valor = new HashValores("real", 0.0);
                        memoria.asignarVariable(tokens[1], valor);
                        break;
                    }
                    expresion = Arrays.asList(tokens).subList(2, tokens.length);
                    
                    // Evaluar la expresión
                    postfixExpresion = infixToPostfix(expresion);
                    resultadoExpresion = evaluarExpresion(postfixExpresion);
                    
                    // Asignar el resultado a la variable
                    valor = new HashValores("real", resultadoExpresion);
                    memoria.asignarVariable(tokens[1], valor);
                    break;
                case "leer":
                    Leer scan = new Leer();
                    String value = memoria.obtenerTipo(tokens[1]);
                    switch (value) {
                        case "entero":
                            int valorInt = scan.leerInt("Escribe el valor de: "+ tokens[1]);
                            valor = new HashValores("entero", valorInt);
                            memoria.asignarVariable(tokens[1], valor);
                            break;
                        case "real":
                            float valorFloat = scan.leerFloat("Escribe el valor de: "+ tokens[1]);
                            valor = new HashValores("real", valorFloat);
                            memoria.asignarVariable(tokens[1], valor);
                            break;
                        case "string":
                            String valorString = scan.leerString("Escribe el valor de: "+ tokens[1]);
                            valor = new HashValores("string", valorString);
                            memoria.asignarVariable(tokens[1], valor);
                            break;
                        default:

                            break;
                    }
                    
                    
                    // Manejar instrucción de lectura
                    // Implementar la lógica para leer valores
                    break;
                case "imprime":
                    if(memoria.existeVariable(tokens[1])){
                        System.out.println(memoria.obtenerVariable(tokens[1]));
                        break;
                    }else{
                        String mensaje = "";
                        for (int i = 1; i < tokens.length; i++) {
                            mensaje = mensaje + " "+tokens[i];
                        }
                        System.out.println(mensaje);
                        break;
                    }
                   
                    // Manejar instrucción de impresión
                    // Implementar la lógica para imprimir valores
                default:
                    // asignar variable
                    if(tokens[1].equals("=")){
                        List<String> expresion2 = Arrays.asList(tokens).subList(2, tokens.length);
                        List<String> postfixExpresion2 = infixToPostfix(expresion2);
                        Object resultadoExpresion2 = evaluarExpresion(postfixExpresion2);
                        valor = new HashValores("real", resultadoExpresion2);
                        memoria.asignarVariable(tokens[0], valor);
                        break;
                    }
                    break;
                // Agregar más casos para otras instrucciones
            }
        }
    }
}
