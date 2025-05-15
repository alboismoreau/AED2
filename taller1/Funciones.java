package aed;

class Funciones {
    int cuadrado(int x) {
        
        return x * x;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x * x + y * y);
    
        return res;
    }

    boolean esPar(int n) {
        
        return (n % 2 == 0);
    }

    boolean divideA(int n, int m) { // aux para esBisiesto
        return m % n == 0;
    }

    boolean esBisiesto(int n) {  
        return ((divideA( 4, n) && !divideA(100,n)) || divideA(400, n));
    }


    int factorialIterativo(int n) {
        int res = 1;
        if (n==0){
            res = 1;
        } else {
            for( int i =1; i <= n; i++){
                res = res * i;
            }
        }


    
        return res;
    }

    int factorialRecursivo(int n) {
        
        int res = 0;
        if (n==0){
            res = 1;
        } else {
            res = n * factorialRecursivo(n - 1);
        }
        return res;
    }
    

    int cantDivisores(int n) { // aux esPirmo
        int res = 0;
        for( int i =1; i <= n; i++){
            if (divideA(i, n)){
                res += 1;
            }
        }

        return res;
        
    }


    boolean esPrimo(int n) {
        boolean res = true;

        if( n == 0 || n == 1){
            res = false;
        }else if(cantDivisores(n) > 2){
            res = false;
        }

        
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for(int i = 0; i < numeros.length ; i++ ){
            res += numeros[i];


        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for(int i = 0; i < numeros.length ; i++ ){
            if(numeros[i]== buscado){
                res = i;
            }
        }

        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for(int numero: numeros){
            if(esPrimo(numero)){
                res = true;
            }
        } 
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for(int numero: numeros){
            if(!esPar(numero)){
                res = false;

            }

        }

        return res;
    }

    boolean esPrefijo(String s1, String s2) {

        boolean res = true;
        if(s1.length() > s2.length()){
            res = false;
        }else{
            for( int i =0; i < s1.length(); i++){

            if(s1.charAt(i) != s2.charAt(i)){
                res = false;
            }
        }
        }
        
        return res;
    }

    String reverso(String s){  // Aux esSufijo

        String res = "";

        for(int i = s.length()-1; i>=0; i--){
            res = res + s.charAt(i);
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {

        return esPrefijo(reverso(s1), reverso(s2));
        
    }
    
}
