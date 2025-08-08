package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;
    private int _cardinal;


    private class Nodo {

        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        // Crear Constructor del nodo

        Nodo (T valor){
            this.valor = valor;
            izq = null;
            der = null;
            padre = null;

        }
 
    }

        public ABB(){ //constructor
        _raiz = null;
        _cardinal = 0;


    }


    public int cardinal() {
        return this._cardinal;
    }

    public T minimo(){
        Nodo nodo = this._raiz;
        while (nodo.izq != null){
        nodo = nodo.izq;
        }
        return nodo.valor;
    }

    public T maximo(){
        Nodo nodo = this._raiz;
        while(nodo.der !=null){
            nodo = nodo.der;
        }
        return nodo.valor;
    }

    public boolean pertenece(T elem){
        if (elem == null) return false;
        Nodo nodo = this._raiz;
        while (nodo != null) {
            int cmp = elem.compareTo(nodo.valor);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                nodo = nodo.izq;
            } else {
                nodo = nodo.der;
            }
        }
        return false;
    }
    
    

    public void insertar(T elem){
        if (elem == null) return;

        if (this._raiz == null){
            this._raiz = new Nodo(elem);
            this._cardinal++;
            return;
        }
    
        if (pertenece(elem)) return;
    
        Nodo nuevoNodo = new Nodo(elem);
        Nodo padre = buscarPadre(this._raiz, elem);
        nuevoNodo.padre = padre;
    
        if (elem.compareTo(padre.valor) < 0) {
            padre.izq = nuevoNodo;
        } else {
            padre.der = nuevoNodo;
        }
    
        this._cardinal++;
    }
    
    //usamos metodo compareTo y no simplemente la comparación porque al 
    //tratarse de objetos estamos comparando la referencia y no el valor.

    public Nodo buscarPadre(Nodo raiz, T elem){
        Nodo actual = raiz;
        Nodo padre = null;

        while(actual != null){
            padre = actual;
            int cmp = elem.compareTo(actual.valor);
            if(cmp > 0){
                actual = actual.der;
            }
            else{
                actual = actual.izq;
        }
        
    }
        return padre;

}

    public Nodo buscarNodo(Nodo actual, T elem){
        while(actual != null){
            int cmp = elem.compareTo(actual.valor);
            if (cmp == 0) return actual;
            else if(cmp < 0) actual = actual.izq;
            else actual = actual.der;
        }
        return null;

    }

    public void eliminar(T elem){
        if (elem == null) return;
    
        Nodo n = buscarNodo(this._raiz, elem);
        if (n == null) return;
    
        // Caso 1: n es una hoja
        if (n.izq == null && n.der == null) {
            if (n.padre == null) {
                _raiz = null;
            } else if (n.padre.izq == n) {
                n.padre.izq = null;
            } else {
                n.padre.der = null;
            }
            this._cardinal--;
            return;
        }
    
        // Caso 2: n tiene un solo hijo
        if (n.izq == null || n.der == null) {
            eliminarConUnHijo(n);
            this._cardinal--;
            return;
        }
    
        // Caso 3: n tiene dos hijos
        Nodo sucesor = menor(n.der); // el menor de los mayores
        n.valor = sucesor.valor;
    
        // eliminar el sucesor directamente (siempre tiene a lo sumo un hijo derecho)
        if (sucesor.der != null) {
            eliminarConUnHijo(sucesor);
        } else {
            if (sucesor.padre.izq == sucesor) {
                sucesor.padre.izq = null;
            } else {
                sucesor.padre.der = null;
            }
        }
    
        this._cardinal--;
    }
    
        private Nodo menor(Nodo n){
            Nodo actual = n;
            while (actual.izq != null){
                actual = actual.izq;
            }
        return actual;
        }

        
        private void eliminarConUnHijo(Nodo n){
        Nodo hijo = null;

        //primero me fijo quien es el hijo
        if(n.der == null){
            hijo = n.izq;
        }
        else{ 
            hijo = n.der; 
        }

        if(n.padre == null){
            //qué pasa si el nodo a eliminar es la raiz
            this._raiz = hijo;
            hijo.padre = null;
        }else{
            if(n.padre.izq == n){ 
                n.padre.izq = hijo;
            }else{
                n.padre.der = hijo;
            }
            hijo.padre = n.padre;
        }
        }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        Iterador<T> dedo = this.iterador();
        boolean noLoAgregue = true;

        while(dedo.haySiguiente()){
            if(!noLoAgregue){ //si ya lo agregué, separo con coma
                sb.append(",");
            }else {  // si no lo agregé
                noLoAgregue = false; //aviso que lo voy a agregar
            }
            sb.append(dedo.siguiente());
        }

        sb.append("}");
        return sb.toString();

    }


    private class ABB_Iterador implements Iterador<T> {
        private Stack<Nodo> pila;

        public ABB_Iterador(){
            this.pila = new Stack<>();
            apilarIzquierdos(_raiz);
        }

        private void apilarIzquierdos(Nodo n){
            while(n != null){
                this.pila.push(n);
                n = n.izq;
            }
        }

        public boolean haySiguiente() {            
            return !pila.isEmpty();
        }
    
        public T siguiente() {
            Nodo actual = pila.pop();
            if (actual.der != null){
                apilarIzquierdos(actual.der);
            }
            return actual.valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
