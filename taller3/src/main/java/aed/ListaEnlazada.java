package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {

    private Nodo primero;
    private int size;


    //Nodo es una clase privada dentro de mi clase listaEnlazada 

    private class Nodo {
        T valor;
        Nodo antecesor; 
        Nodo sucesor; 
        //Esto define una lista doblemente enlazada porque cada nodo conoce 
        //quién está antes y después, lo que permite recorrer la lista en ambos sentidos


        Nodo(T _valor){
            this.valor = _valor; // constructor. recibe un valor y lo guarda en al atributo valor del nodo.
        }
    }

    public ListaEnlazada() { //Constructor de la lista
        primero = null;
        size = 0;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        nuevo.antecesor = null; //Como va adelante, su antecesor es null.
        nuevo.sucesor = primero;
        primero = nuevo; //Actualiza primero para que apunte al nuevo nodo.
        size++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null) {
            primero = nuevo;
        }
        else {
            Nodo actual = primero;
            while (actual.sucesor != null) {
                actual = actual.sucesor;
            }
            actual.sucesor = nuevo;
            nuevo.antecesor = actual;
        }  
        size++;
    }

    //como la lista no tiene acceso aleatorio (no es arreglo), 
    //para obtener el elemento en la posición i hay que recorrerla secuencialmente.

    public T obtener(int i) {
        int j = 0;
        Nodo actual = primero;
        while (j < i){
            actual = actual.sucesor;
            j++;
        }
        return actual.valor;       
    }

    public void eliminar(int i) {        
        Nodo actual = primero;
        Nodo prev = primero;

        for (int j = 0; j < i; j++) {
            prev = actual;
            actual = actual.sucesor;
        }

        if (i == 0) {
            primero = actual.sucesor;
        }
        else {
            prev.sucesor = actual.sucesor;
        }
        
        size--;
    }

    public void modificarPosicion(int indice, T elem) {
        int j = 0;
        Nodo actual = primero;
        while (j < indice)
        {
            actual = actual.sucesor; 
            j++;
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() { //Crea una copia profunda de la lista actual.
        // el método copiar() no recibe ninguna lista como parámetro.
        //porque this hace referencia al atributo por fuera de mi método copiar()
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<>(null);
        Nodo actual = this.primero;
        while (actual != null){
            nuevaLista.agregarAtras(actual.valor);
            actual = actual.sucesor;
        }
        return nuevaLista;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) { //Constructor por copia
        //permite crear una nueva lista a partir de otra lista enlazada existente.
        if (lista != null) {            
            ListaEnlazada<T> copiaLista = lista.copiar();
            this.primero = copiaLista.primero;
            this.size = lista.size;
        }
        else {
            this.primero = null;
            this.size = 0;
        }
    }
    
    @Override// indica que estamos sobrescribiendo un método heredado de Object
    public String toString() {
        //genera una representación textual de la lista
        //[valor1, valor2, valor3]
        Nodo actual = primero;
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        while (actual != null){
            buffer.append(actual.valor.toString());
            if (actual.sucesor != null)
               buffer.append(", ");
            actual = actual.sucesor;
        }
        buffer.append("]");
        return buffer.toString();
    }

    private class ListaIterador implements Iterador<T> {

    //Define una clase interna privada que implementa la interfaz Iterador<T>
        int indice;

        ListaIterador() {
            indice = 0;
        }

        public boolean haySiguiente() { 
            return indice < size;
        }
        
        public boolean hayAnterior() {  
            return indice > 0;
        }

        public T siguiente() {
            // En realidad el testing pide que devuelva
            // el elemento actual del indice y luego avance el indice
            // al principio it.siguiente() -> devuelve el primer elemento
            T res = null;
            if (haySiguiente()){
                res = obtener(indice);
                indice++;
            }
            return res;
        }

        public T anterior() {
            T res = null;
            if (hayAnterior()){
                indice--;
                res = obtener(indice);
            }
            return res;
        }
    }


 //**El iterador no manipula directamente los nodos, sino que usa el método obtener(indice)
  //para acceder al elemento en la posición actual.*/   




    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}