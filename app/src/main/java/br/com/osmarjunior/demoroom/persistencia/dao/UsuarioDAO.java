package br.com.osmarjunior.demoroom.persistencia.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.osmarjunior.demoroom.persistencia.entidades.Usuario;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM Usuario")
    List<Usuario> buscarTodos();

    @Query("SELECT * FROM Usuario WHERE id = :id")
    List<Usuario> buscarPor(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionarUsuario(Usuario... usuario);

    @Update
    public void editarUsuario(Usuario... usuario);

    @Delete
    public  void deleteUsers(Usuario... usuario);
}
