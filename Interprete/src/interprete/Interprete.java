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

    public Object obtenerVariable(String valor) {//repetido
        return memoria.obtenerVariable(valor);
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
                    pila.push(memoria.obtenerVariable(token));
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

                    valor = new HashValores("entero", resultadoExpresion);
                    memoria.asignarVariable(tokens[1], valor);
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
                    
                    break;
                case "imprime":
                    if(memoria.existeVariable(tokens[1])){
                        System.out.print(memoria.obtenerVariable(tokens[1]));
                        System.out.println(" de tipo:" + memoria.obtenerTipo(tokens[1]));
                        break;
                    }else{
                        String mensaje = "";
                        for (int i = 1; i < tokens.length; i++) {
                            mensaje = mensaje + " "+tokens[i];
                        }
                        System.out.println(mensaje);
                        break;
                    }
                   
                  
                default:
                    // asignar variable
                    if(tokens[1].equals("=")){ // validar si existe la memoria
                        List<String> expresion2 = Arrays.asList(tokens).subList(2, tokens.length);
                        List<String> postfixExpresion2 = infixToPostfix(expresion2);
                        Object resultadoExpresion2 = evaluarExpresion(postfixExpresion2, memoria.obtenerTipo(tokens[0]);
                        
                        valor = new HashValores(memoria.obtenerTipo(tokens[0]), resultadoExpresion2);
                        memoria.asignarVariable(tokens[0], valor);
                        break;
                    }
                    break;
               
            }
        }
    }
}
