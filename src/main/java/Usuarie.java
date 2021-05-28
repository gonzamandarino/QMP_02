import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usuarie {
    List<Guardarropas> armarios = new ArrayList<>();
    AsesorDeImagen asesor;

    public Usuarie(AsesorDeImagen asesor, Guardarropas armario) {
        this.armarios.add(armario);
        this.asesor= asesor;
    }

    public void agregarPrenda(TipoPrenda tipoP, Material mat, Trama trama, Color colorP, Color colorS, Estacion e,Guardarropas armario) {

        Borrador b = new Borrador(tipoP);
        b.especificarMaterial(mat);
        b.especificarColorP(colorP);
        b.especificarColorS(colorS);
        b.especificarTrama(trama);
        b.especificarEstacion(e);

        getArmario(armario).agregarPrenda(b.crearPrenda());

    }

    public void cambiarAsesor(AsesorDeImagen asesor) {
        this.asesor = asesor;
    }

    public void agregarArmario(Guardarropas armario) {
        armarios.add(armario);
    }

   public Atuendo sugerirAtuendoSegunClimaEnLugarYdeQueArmario(String direccion, Guardarropas armario)  {
        if (!this.armarios.contains(armario)) {
            throw new ArmarioException;
       }
        return asesor.sugerirAtuendo(direccion,armario);
   }

   public Guardarropas getArmario(Guardarropas armario) {
       try {
           int i = this.armarios.indexOf(armario);
           return this.armarios.get(i);
       } catch (ArmarioException e){
           throw new ArmarioException;
       }

   }

    public List<Map<String, Object>> getClima(String direccion) {
        AccuWeatherAPI apiClima = new AccuWeatherAPI();
        return apiClima.getWeather(direccion);

    }
}
