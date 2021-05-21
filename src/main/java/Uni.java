
public class Uni {

    String colegio;
    Prenda remera;
    Prenda pantalon;
    Prenda zapato;

    Uni(Prenda remera, Prenda pantalon, Prenda zapato, String colegio) {

        this.remera = remera;
        this.pantalon = pantalon;
        this.zapato = zapato;
        this.colegio = colegio;

    validarUni();
    }

//deberia ser un class method pero no me anda con el parametro

    public void fabricar(Sastre s) {

        new Uni(s.fabricarPrendaSup(), s.fabricarPrendaInf(), s.fabricarCalzado(), s.colegio());

    }

    public void validarUni() {

        validarRemera();
        validarPantalon();
        validarCalzado();

    }

    private void validarRemera() {

        if (this.remera.getCategoria() != Categoria.SUPERIOR) {
            throw new PrendaInvalidaException(
                    "La remera tiene que tener categoria Superior"
            );
        }
    }

    private void validarPantalon() {

        if (this.pantalon.getCategoria() != Categoria.INFERIOR) {
            throw new PrendaInvalidaException(
                    "El pantalon tiene que tener categoria Inferior"
            );
        }

    }

    private void validarCalzado() {

        if (this.zapato.getCategoria() != Categoria.CALZADO) {
            throw new PrendaInvalidaException(
                    "El zapato tiene que tener categoria Calzado"
            );
        }
    }

}