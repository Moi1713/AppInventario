package sv.edu.ues.eisi.proyecto1;

public class ClasEquipo {

    private String IdClasEquipo;
    private String DescClasEquipo;

    public ClasEquipo(){
    }
    public ClasEquipo(String IdClasEquipo, String DescClasEquipo) {
        this.IdClasEquipo = IdClasEquipo;
        this.DescClasEquipo = DescClasEquipo;
    }
    public String getIdClasEquipo() {
        return IdClasEquipo;
    }
    public void setIdClasEquipo(String IdClasEquipo) {
        this.IdClasEquipo = IdClasEquipo;
    }

    public String getDescClasEquipo() {
        return DescClasEquipo;
    }
    public void setDescClasEquipo(String DescClasEquipo) {
        this.DescClasEquipo = DescClasEquipo;
    }

}
