enum TipoPrenda {


    ZAPATO(Categoria.CALZADO),
    CAMISA(Categoria.SUPERIOR),
    PANTALON(Categoria.INFERIOR);

    TipoPrenda(Categoria superior) {

    }

    Categoria getCategoria () {
        return categoria;
    }

}

