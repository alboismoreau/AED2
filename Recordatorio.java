package aed;

public class Recordatorio {

    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = new String (mensaje);
        this.fecha = new Fecha(fecha);
        this.horario = new Horario (horario);

    }

    public Horario horario() {
        return new Horario (horario);
    }

    public Fecha fecha() {
        return new Fecha (fecha);
    }

    public String mensaje() {
        return new String(mensaje);
    }

    @Override
    public String toString() {
        return this.mensaje +" @ "+ fecha.toString() + " " + horario.toString();
        
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = (otro.getClass() != this.getClass());
        
        if (otroEsNull || claseDistinta)
            return false;
        

        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return (this.mensaje.equals(otroRecordatorio.mensaje()) &&
                 this.fecha.equals(otroRecordatorio.fecha()) 
                && this.horario.equals(otroRecordatorio.horario()));
    }

}
