public class EstadoDelTiempo {
    int temperatura;
    Humedad humedad;
    String direccion;


    EstadoDelTiempo(int temperatura, Humedad humedad){
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public void get(String direccion) {
        this.direccion = direccion;
    }


    public void getEstadoDelTiempo() {

    }

}
