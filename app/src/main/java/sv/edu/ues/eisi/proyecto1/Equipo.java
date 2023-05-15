package sv.edu.ues.eisi.proyecto1;

public class Equipo {

    private String NumSerie;
    private String IdUnidad;
    private String IdClasEquipo;
    private String NombreEquipo;
    private String DescEquipo;
    private String MarcaEquipo;

    public Equipo(){
    }
    public Equipo(String NumSerie, String IdUnidad, String IdClasEquipo, String NombreEquipo, String DescEquipo, String MarcaEquipo) {
        this.NumSerie = NumSerie;
        this.IdUnidad = IdUnidad;
        this.IdClasEquipo = IdClasEquipo;
        this.NombreEquipo = NombreEquipo;
        this.DescEquipo = DescEquipo;
        this.MarcaEquipo = MarcaEquipo;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String numSerie) {
        NumSerie = numSerie;
    }

    public String getIdUnidad() {
        return IdUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        IdUnidad = idUnidad;
    }

    public String getIdClasEquipo() {
        return IdClasEquipo;
    }

    public void setIdClasEquipo(String idClasEquipo) {
        IdClasEquipo = idClasEquipo;
    }

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        NombreEquipo = nombreEquipo;
    }

    public String getDescEquipo() {
        return DescEquipo;
    }

    public void setDescEquipo(String descEquipo) {
        DescEquipo = descEquipo;
    }

    public String getMarcaEquipo() {
        return MarcaEquipo;
    }

    public void setMarcaEquipo(String marcaEquipo) {
        MarcaEquipo = marcaEquipo;
    }
}
