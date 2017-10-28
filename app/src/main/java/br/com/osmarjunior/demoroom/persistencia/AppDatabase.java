package br.com.osmarjunior.demoroom.persistencia;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.osmarjunior.demoroom.persistencia.dao.TrofeuDAO;
import br.com.osmarjunior.demoroom.persistencia.dao.UsuarioDAO;
import br.com.osmarjunior.demoroom.persistencia.entidades.Trofeu;
import br.com.osmarjunior.demoroom.persistencia.entidades.Usuario;

@Database(entities = {Usuario.class, Trofeu.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static  AppDatabase INSTANCE;

    public abstract UsuarioDAO usuarioDAO();
    public abstract TrofeuDAO trofeuDAO();

    public static AppDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "gamedatabase")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return  INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
