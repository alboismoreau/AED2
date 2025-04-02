package aed;

public class Horario {

    private int hora; //atributos privados
    private int minutos;

    public Horario(int hora, int minutos) { //Constructor
        this.hora = hora;
        this.minutos = minutos;
    }

    public Horario(Horario horario){
        this.hora = horario.hora;
        this.minutos = horario.minutos;
    }


    public int hora() {  //metodo
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        return String.valueOf(this.hora) + ":" + String.valueOf(this.minutos);
    }

    @Override
    public boolean equals(Object otro) {

       boolean otroEsNull = ( otro == null);
       boolean claseDistinta = (otro.getClass() != this.getClass());

       if (otroEsNull || claseDistinta){
        return false;
       }


        //Casting
       Horario otroHorario = (Horario) otro;
       return this.hora == otroHorario.hora && this.minutos == otroHorario.minutos;
    
     }


    }
        

