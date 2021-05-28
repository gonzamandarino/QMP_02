import java.util.Map;

public interface ServicioMeteorologico {

    EstadoDelTiempo obtenerCondicionesClimaticas(String direccion);
}