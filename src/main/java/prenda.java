class Uni{

    string colegio;
    Prenda remera;
    Prenda pantalon;
    Prenda zapato;

    public Uni(string colegio, Prenda remera, Prenda pantalon, Prenda zapato) {
        this.remera = remera;
        this.pantalon = pantalon;
        this.zapato = zapato;
        this.colegio = colegio;

        validarUni();
    }

    public void validarUni(){
        if (this.remera.getCategoria() != Categoria.SUPERIOR) {
            throw new PrendaInvalidaException(
                    "La remera tiene que tener categoria Superior"
            );
        }
        if (this.pantalon.getCategoria() != Categoria.INFERIOR) {
            throw new PrendaInvalidaException(
                    "El pantalon tiene que tener categoria Inferior"
            );
        }
        if (this.zapato.getCategoria() != Categoria.CALZADO) {
            throw new PrendaInvalidaException(
                    "El zapato tiene que tener categoria Calzado"
            );
        }
    }
}

class Admin{

    public void crearUniXcole(string colegio, Prenda remera, Prenda pant, Prenda zapato){
        Uni uniforme = new Uni((colegio, remera,pant,zapato));
    }
}

public class Usuarie{
    list<Prenda> prendas;
    list<Uni> uniformes;

    Prenda borrador;

    public void crearPrenda(TipoPrenda tipoP, Material mat, Trama trama, Color colorP, Color colorS){
        Prenda prenda = new Prenda(tipoP,mat,colorP,colorS,trama);
        borrador = prenda;
        prendas.add(prenda);
    }

    public void sugerirUni(){
        random->uniformes
    }


}


class Prenda {
    TipoPrenda tipo;
    Material material;
    Color colorPrimario;
    Color colorSecundario;
    Trama trama = Trama.LISA;
    public Prenda(TipoPrenda tipo, Material material, Color colorPrimario, Color colorSecundario,Trama trama){
        if(tipo == null) {
            throw new PrendaInvalidaException(
                    "Falta el tipo de prenda"
            );
        }
        if(material == null) {
            throw new PrendaInvalidaException(
                    "Falta el material"
            );
        }
        this.tipo = tipo;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }
    public Categoria getCategoria(){
        return tipo.getCategoria();
    }
}


enum Categoria{
    CALZADO,SUPERIOR,INFERIOR,ACCESORIOS
}

enum TipoPrenda(Categoria categoria){

    ZAPATO(Categoria.CALZADO),
    CAMISA(Categoria.SUPERIOR)

    }
class Color{
    int red;
    int green;
    int blue;
}

enum Material{
    CUERO, JEAN,ALGODON
}


enum Trama{
LISA,RAYADA,CUADROS,ESTAMPADO
}
