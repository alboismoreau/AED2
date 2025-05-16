package aed;


    /**
     * Iterador.java → otra interfaz, esta vez para recorrer elementos uno por uno.
Define cómo debe funcionar un iterador, sin decir cómo se hace.
     */

interface Iterador<T> {
    
    /**
     * Devuelve true si hay un elemento siguiente en la colección.
     * 
     */
    public boolean haySiguiente();
    
    /**
     * Devuelve true si hay un elemento anterior en la colección.
     * 
     */
    public boolean hayAnterior();

    /**
     * Devuelve el elemento siguiente en la colección y avanza el iterador.
     * 
     */
    public T siguiente();

    /**
     * Devuelve el elemento anterior en la colección y retrocede el iterador.
     * 
     */
    public T anterior();

}
