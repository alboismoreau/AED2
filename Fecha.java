package aed;

public class Fecha {

    private int dia;  // arriba de todo definimos atributos privados
    private int mes;


    public Fecha(int dia, int mes) { // fecha es el constructor mismo nombre que la calse, asigna valores a las partes privadas del objeto
        this.dia = dia;  //this hace referencia a los que tengo adentro de mi metodo, a los de arriba
        this.mes = mes;  //se pasan por copia porque son primitivos, si fueran arreglos no conviene hacer esto
        
        
    }

    public Fecha(Fecha fecha) { // esto tmb es constructor, recibe otra instancia de fecha
        // copiamos los atributos
        dia = fecha.dia;
        mes = fecha.mes;

    }

    public Integer dia() {  //metodo
        
        return this.dia;
    }

    public Integer mes() { //metodo
        
        return this.mes;
    }
    

    @Override
    public String toString() {
        return String.valueOf(this.dia)+"/"+String.valueOf(this.mes);
        
    }

    @Override
    // chequeos burocraticos
    public boolean equals(Object otra) {
        boolean otraEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();
        if (otraEsNull || claseDistinta) {
            return false;
        }
        // casting -> cambiar el tipo
        Fecha otraFecha = (Fecha) otra;
        return this.dia == otraFecha.dia() && this.mes == otraFecha.mes();
  
    }

    public void incrementarDia() {
        //buscar el ultimo dia
        if (diasEnMes(this.mes) == this.dia()){

            this.dia = 1;

            // diciembre

            if (this.mes==12){
                this.mes = 1;
            }
            
            else{
                this.mes +=1;
                
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
        return dias[mes - 1];
    }

}
