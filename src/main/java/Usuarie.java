import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Usuarie {
    List<Prenda> prendas;
    List<Uni> uniformes;

    public void agregarPrenda(TipoPrenda tipoP, Material mat, Trama trama, Color colorP, Color colorS, Estacion e) {

        Borrador b = new Borrador(tipoP);
        b.especificarMaterial(mat);
        b.especificarColorP(colorP);
        b.especificarColorS(colorS);
        b.especificarTrama(trama);
        b.especificarEstacion(e);

        this.prendas.add(b.crearPrenda());
    }
    public Uni sugerirUni() {
       return random->uniformes;
    }

    public Atuendo sugerirAtuendoSegunClima() {
        List<Map<String, Object>> c = getClima();

        if c.get(0).get("Tempreature") < 20 {

            Stream<Prenda> prendasFrio = this.prendas.stream().filter(p -> p.estacion == Estacion.FRIO);
            return elegirAtuendoRandomSegunEstacion(prendasFrio);

        }else {
            Stream<Prenda> prendasCalor= this.prendas.stream().filter(p -> p.estacion == Estacion.FRIO);
            return elegirAtuendoRandomSegunEstacion(prendasCalor);
        }

    }

    private Atuendo elegirAtuendoRandomSegunEstacion(Stream<Prenda> p) {

        return new Atuendo(elegirPrendaRandomSegunCategoria(p,Categoria.ACCESORIOS),
                elegirPrendaRandomSegunCategoria(p,Categoria.SUPERIOR),
                elegirPrendaRandomSegunCategoria(p,Categoria.INFERIOR),
                elegirPrendaRandomSegunCategoria(p,Categoria.CALZADO));

    }


    private List<Prenda> elegirPrendaRandomSegunCategoria(Stream<Prenda> p, Categoria c) {
        List<Prenda> lista = new arrayList;
        lista.add(random-> p.filter(x -> x.getCategoria() == c));
        return lista;
    }

    public List<Map<String, Object>> getClima() {
        AccuWeatherAPI apiClima = new AccuWeatherAPI();
        return apiClima.getWeather("Buenos Aires, Argentina");

    }
}
