package Modelo;

public class Insumos {
    
    private int idInsumo;
    private String nomInsumo;

    public Insumos() {
    }

    public Insumos(int idInsumo, String nomInsumo) {
        this.idInsumo = idInsumo;
        this.nomInsumo = nomInsumo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNomInsumo() {
        return nomInsumo;
    }

    public void setNomInsumo(String nomInsumo) {
        this.nomInsumo = nomInsumo;
    }
    
    
    
}
