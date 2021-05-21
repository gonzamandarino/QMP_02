public class SastreSanJuan implements Sastre {

    @Override
    public Prenda fabricarPrendaSup() {
        Borrador b = new Borrador(TipoPrenda.CAMISA);
        b.especificarMaterial(Material.ALGODON);
        b.especificarColorP(new Color());
        return b.crearPrenda();

    }

    @Override
    public Prenda fabricarPrendaInf() {
        Borrador b = new Borrador(TipoPrenda.PANTALON);
        b.especificarMaterial(Material.ALGODON);
        b.especificarColorP(new Color());
        return b.crearPrenda();
    }

    @Override
    public Prenda fabricarCalzado() {
        Borrador b = new Borrador(TipoPrenda.ZAPATO);
        b.especificarMaterial(Material.CUERO);
        b.especificarColorP(new Color());
        return b.crearPrenda();
    }

    @Override
    public String colegio() {
        return "San Juan";
    }

}
