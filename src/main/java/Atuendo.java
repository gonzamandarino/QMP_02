import java.util.List;

public class Atuendo {
    List<Prenda> accesorios;
    List<Prenda> superior;
    List<Prenda> inferior;
    List<Prenda> calzado;


    public Atuendo(List<Prenda> a, List<Prenda> s, List<Prenda> i, List<Prenda> c) {
        this.accesorios = a;
        this.superior = s;
        this.inferior = i;
        this.calzado = c;
    }
}
