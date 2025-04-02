package aed;

public class Fecha {    
    
    private int dia;
    private int mes; // Estos son atributos privados, me dan un estado de la clase
           
    public Fecha(int dia, int mes) {  //Fecha recibe mis atributos dde afuera
        //Fecha es un constructor, lleva el mismo nombre que la clase
        //Un constructor permite inicializar una instancia de clase (objeto)
        this.dia = dia; //this hace referencia al dia que está dentreo de mi métdo
        this.mes = mes;  //Se pueden pasar por copia porque son primitivos
    }

    public Fecha(Fecha fecha) {
        // Esto también es un constructor, recibe otra instancia de fecha
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    
     //ahora vamos con otros métodos no constructores.
     


    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    public String toString() {
        return String.valueOf(this.dia) + "/" + String.valueOf(this.mes);
    }


    //Si el tipo es un objeto, a.equals(b) dice si “a” y “b” son iguales o equivalentes.
    //Como  creamos una clase propia, tenemos que definir nosotros cómo se comparan dos 
    //instancias de esa clase


    @Override   //Equals ya tiene una implementación por defecto ---> hay que hacer sobrecarga (override)
    public boolean equals(Object otra) {


        //primero hacemos estos chequeos
        boolean otraEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();

        if (otraEsNull || claseDistinta){
            return false;
        }


        //Casting (cambiar el tipo)
        Fecha otraFecha = (Fecha) otra; // asigno otra fecha

        return this.dia == otraFecha.dia() && this.mes == otraFecha.mes();
    }



    public void incrementarDia() {
        
        //buscar el ultimo dia

        if (diasEnMes(this.mes) == this.dia()){

            this.dia = 1;

            //En caso de que seal ultimo dia del año

            if (this.mes == 12){

                this.mes = 1;
            }

            else{

                this.mes += 1;
            }
        }

        else{

            this.dia += 1;
        }
            
    }
        
    

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];  // devuelve la cantidad de días del mes que van
    }
    //también podemos pensarla como que devuelve el último dia del mes

}
