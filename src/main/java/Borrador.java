import static java.util.Objects.requireNonNull;

public class Borrador {

    TipoPrenda tipo;
    Material material;
    Color colorPrimario;
    Color colorSecundario;
    Trama trama = Trama.LISA;
    Estacion estacion = Estacion.CALOR;


    public Borrador(TipoPrenda t) {

        this.tipo = requireNonNull(t, "Por favor, ingrese un tipo");
    }

    public void especificarMaterial(Material m) {

        this.material = requireNonNull(m, "Por favor, ingrese un material");
    }

    public void especificarColorP(Color c) {

        this.colorPrimario = requireNonNull(c, "Por favor, ingrese un color");
    }

    public void especificarColorS(Color c) {

        this.colorSecundario = c;
    }

    public void especificarTrama(Trama t) {

        this.trama = t;
    }

    public void especificarEstacion(Estacion e) {
        this.estacion = requireNonNull(e,"Por favor indique si es para cuando hace calor o frio");
    }


    public Prenda crearPrenda(){

        return new Prenda(this.tipo,this.material,this.colorPrimario,this.colorSecundario,this.trama, this.estacion);
    }
}
