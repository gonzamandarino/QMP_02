import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoAccuWeather implements ServicioMeteorologico {
    private AccuWeatherAPI api;
    private Object expiracion = null;
    private String direccion;
    private EstadoDelTiempo ultimasRespuestas;
    private LocalDateTime proximaExpiracion;

    public ServicioMeteorologicoAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez, String direccion) {
        this.api = api;
        this.expiracion = expiracion;
        this.direccion = direccion;
        this.ultimasRespuestas = new EstadoDelTiempo;
    }

    @Override
    public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
        if (this.ultimasRespuestas == null || this.expiro()) {
            this.ultimasRespuestas = consultarApi(direccion);
            this.proximaExpiracion = LocalDateTime.now().plus((TemporalAmount) this.expiracion);
        }
        return this.ultimasRespuestas.get(direccion).getEstadoDelTiempo();
    }

    private boolean expiro() {
        return proximaExpiracion.isAfter(LocalDateTime.now());
    }

    private EstadoDelTiempo consultarApi(String direccion) {
        Map<String, Object> respuesta = this.api.getWeather(direccion).get(0);
        int temperatura = (int) respuesta.get("Temperature");
        Humedad humedad = (double) respuesta.get("Humidity") > 0.8 ? Humedad.LLUVIOSO : Humedad.SECO;
        return new EstadoDelTiempo(temperatura, humedad);
    }

}