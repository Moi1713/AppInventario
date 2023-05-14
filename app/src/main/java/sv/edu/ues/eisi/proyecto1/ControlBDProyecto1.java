package sv.edu.ues.eisi.proyecto1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ControlBDProyecto1 {

    //Declaracion de campos de tablas
    private static final String[]camposClasEquipo = new String []
            {"IdClasEquipo","DescClasEquipo"};


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    public ControlBDProyecto1(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "Proyecto1.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try{

                //Creacion de tablas de la base de datos
                db.execSQL("CREATE TABLE ClasificacionEquipo(IdClasEquipo VARCHAR(10) NOT NULL PRIMARY KEY,DescClasEquipo VARCHAR(50));");

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    //INSERTAR REGISTROS DE TABLAS
    public String insertar(ClasEquipo clasEquipo){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues claseq = new ContentValues();
        claseq.put("IdClasEquipo", clasEquipo.getIdClasEquipo());
        claseq.put("DescClasEquipo", clasEquipo.getDescClasEquipo());
        contador=db.insert("ClasificacionEquipo", null, claseq);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    //ELIMINAR REGISTROS DE TABLA

    public String eliminar(ClasEquipo clasEquipo){
        String regAfectados="filas afectadas= ";
        int contador=0;

        /*if (verificarIntegridad(materia,4)) {
            contador+=db.delete("nota", "materia='"+materia.getCodmateria()+"'", null);
        }*/

        contador+=db.delete("ClasificacionEquipo", "IdClasEquipo='"+clasEquipo.getIdClasEquipo()+"'", null);
        regAfectados+=contador;
        return regAfectados;

    }


    //CONSULTAR REGISTRO DE TABLA

    public ClasEquipo consultarClasEquipo(String IdClasEquipo){
        String[] id = {IdClasEquipo};
        Cursor cursor = db.query("ClasificacionEquipo", camposClasEquipo, "IdClasEquipo = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            ClasEquipo clasEquipo = new ClasEquipo();
            clasEquipo.setIdClasEquipo(cursor.getString(0));
            clasEquipo.setDescClasEquipo(cursor.getString(1));
            return clasEquipo;
        }else{
            return null;
        }
    }


    //ACTUALIZAR REGISTROS DE TABLAS

    public String actualizar(ClasEquipo clasEquipo){
        //if(verificarIntegridad(alumno, 5)){
        String[] id = {clasEquipo.getIdClasEquipo()};
        ContentValues cv = new ContentValues();
        cv.put("IdClasEquipo", clasEquipo.getIdClasEquipo());
        cv.put("DescClasEquipo", clasEquipo.getDescClasEquipo());
        db.update("ClasificacionEquipo", cv, "IdClasEquipo = ?", id);
        return "Registro Actualizado Correctamente";

        //}else{
        // return "Registro con carnet " + alumno.getCarnet() + " no existe";
        //}
    }



    //LLENAR BASE DE DATOS

    public String llenarBDGpo06() {

        //Datos de tablas
        //ClasificacionEquipo
        final String[] VAIdClasEquipo = {"1", "2", "3", "4"};
        final String[] VADescClasEquipo = {"Computadora", "Switch", "Proyector", "Otro"};

        abrir();

        //Limpia BD
        db.execSQL("DELETE FROM ClasificacionEquipo");

        //Inserta registros por tabla
        ClasEquipo clasEquipo = new ClasEquipo();
        for (int i = 0; i < 4; i++) {
            clasEquipo.setIdClasEquipo(VAIdClasEquipo[i]);
            clasEquipo.setDescClasEquipo(VADescClasEquipo[i]);
            insertar(clasEquipo);
        }

        //Cierra y mensaje de exito
        cerrar();
        return "La base de datos fue llenada Exitosamente";

    }

}
