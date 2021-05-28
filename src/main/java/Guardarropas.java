import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Guardarropas {
    List<Prenda> ropa = new ArrayList<>();
    //criterio de el tipo de ropa que tiene el armario
    String criterio = "General";
    //si es compartido o no el guardarropas
    boolean compartido = false;
    //lista de cambios propuestos
    List<Cambios> cambiosPropuestos;


    public Guardarropas(List<Prenda> ropa, String criterio) {

        this.ropa = ropa;
        this.criterio = criterio;
    }


    public List<Atuendo> todasLasPosiblesCombinaciones() { return null; }


    public void compartirCon(Usuarie usuario) {
        this.compartido = true;
        usuario.agregarArmario(this);

    }


    public void aceptarCambioPrenda() {
        Cambios cambio = this.getListaCambiosPropuestos().first();


        if (cambio.criterioAgregarSacar){
            agregarPrenda(cambio.prenda);
        }else{
            borrarPrenda(cambio.prenda);
        }
        cambio.criterioCambioHecho = true;
    }


    public void deshacerCambioPrenda() {
        Cambios cambio = this.getListaCambiosPropuestos().first();

        if (cambio.criterioAgregarSacar) {
            this.borrarPrenda(cambio.prenda);
        }else{
            this.agregarPrenda(cambio.prenda);
        }
    }

    public void agregarPrenda(Prenda prenda) { this.ropa.add(prenda); }

    public void borrarPrenda(Prenda prenda) { this.ropa.remove(prenda); }


    public Stream<Cambios> getListaCambiosPropuestos() {return cambiosPropuestos.stream().filter(cambio -> !cambio.criterioCambioHecho);    }

    public Stream<Cambios> getListaCambiosHechos() {return cambiosPropuestos.stream().filter(cambio -> cambio.criterioCambioHecho);    }


    private boolean esCompartido() { return compartido;  }

}
