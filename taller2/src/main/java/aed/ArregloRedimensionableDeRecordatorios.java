package aed;

//vamos a trabajar con un arreglos del tipo Recordatorio
// la implementación se basa en guardar los elementos en un arreglo
//cuando el espacio del arreglo se llena, crear uno nuevo y reemplezarlo

class ArregloRedimensionableDeRecordatorios {

    private Recordatorio[] recordatorios; // secuencia de recordatorios
    private int espacioOcupado; //espacio de la seuencia


    public ArregloRedimensionableDeRecordatorios() { 
        //en este construcor les asigno un valor a mis atributos

        this.espacioOcupado = 0;
        this.recordatorios = new Recordatorio[0];
        
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        // El constructor por copia de una clase es el que toma como unico parametro 
        //otra instancia de la misma clase y lo usa para construir una copia.

        this.espacioOcupado = vector.espacioOcupado;
        this.recordatorios = new Recordatorio[vector.espacioOcupado];

        // Una vez que hice una nueva secuencia con el lenght del vector
        //cargo los recordatorios del vector en la nueva secuencia

        for (int i=0 ; i < vector.espacioOcupado ; i++){
            this.recordatorios[i] = vector.obtener(i);  
        }

        this.espacioOcupado = vector.espacioOcupado;

    }



    public int longitud() {
    return this.espacioOcupado;
    }


    public void agregarAtras(Recordatorio i) {

        this.espacioOcupado ++; //le suma 1

        Recordatorio[] nuevoArrayRecordatorios = new Recordatorio[this.espacioOcupado];

        for (int j = 0 ; j < this.espacioOcupado - 1 ; j++){
            nuevoArrayRecordatorios[j] = this.recordatorios[j];
        }

        nuevoArrayRecordatorios[this.espacioOcupado - 1] = i;
        this.recordatorios = nuevoArrayRecordatorios;

    }

    public Recordatorio obtener(int i) {
        return this.recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevoArrayRecordatorios = new Recordatorio[espacioOcupado - 1];

        for (int i = 0 ; i < espacioOcupado - 1; i++){
            nuevoArrayRecordatorios[i] = recordatorios[i];
        }

        recordatorios = nuevoArrayRecordatorios;
        espacioOcupado --;

    }

    public void modificarPosicion(int indice, Recordatorio valor) {

         Recordatorio[] nuevoArrayRecordatorios = new Recordatorio[espacioOcupado];
         for (int i=0 ; i < espacioOcupado ; i++){
            nuevoArrayRecordatorios[i] = recordatorios[i]; 
         }

         nuevoArrayRecordatorios[indice] = valor;
         recordatorios = nuevoArrayRecordatorios;

    
    }

    public ArregloRedimensionableDeRecordatorios copiar() {

        ArregloRedimensionableDeRecordatorios nuevoArreglo = new ArregloRedimensionableDeRecordatorios();
        // nuevoArreglo puede usar los métodos que definimos antes pues es un arreglo redimensionable

        for(int i = 0; i < espacioOcupado; i++){
            nuevoArreglo.agregarAtras(recordatorios[i]);

        }

        return nuevoArreglo;
    }
}
