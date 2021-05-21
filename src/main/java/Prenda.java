class Prenda {
    TipoPrenda tipo;
    Material material;
    Color colorPrimario;
    Color colorSecundario;
    Trama trama;
    Estacion estacion;

    public Prenda (TipoPrenda tipo, Material material, Color colorPrimario, Color colorSecundario, Trama trama, Estacion e) {
        this.tipo = tipo;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
        this.estacion = e;
    }

    public Categoria getCategoria() {

        return tipo.getCategoria();
    }
}

