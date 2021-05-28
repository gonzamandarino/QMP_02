public class Cambios {

    Prenda prenda;
    boolean criterioCambioHecho= false;
    boolean criterioAgregarSacar;

    public Cambios(Prenda prenda, Guardarropas armario, boolean agregarOSacar) {
        this.prenda = prenda;
        this.criterioAgregarSacar = agregarOSacar;

        armario.cambiosPropuestos.add(this);
    }


}
