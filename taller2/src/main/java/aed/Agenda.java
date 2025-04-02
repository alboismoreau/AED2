package aed;

public class Agenda {

    // La Agenda mantiene la fecha actual y el conjunto de recordatorios.
    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;


    public Agenda(Fecha fechaActual) {
        this.fecha = fechaActual;
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String res = new String(fecha + "\n=====\n");
        for(int i = 0; i < recordatorios.longitud(); i ++){
            if ( fechaActual().equals(recordatorios.obtener(i).fecha())){
                res = res + recordatorios.obtener(i).toString() + "\n";
            }

        }

        return res;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha fechaActual = fecha;
        return fechaActual;
    }

}
