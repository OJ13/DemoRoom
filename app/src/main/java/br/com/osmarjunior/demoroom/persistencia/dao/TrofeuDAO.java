package br.com.osmarjunior.demoroom.persistencia.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.osmarjunior.demoroom.persistencia.entidades.Trofeu;

@Dao
public interface TrofeuDAO {

    @Query("Select * From Trofeu")
    List<Trofeu> buscarTodos();

    @Query("Select * FROM Trofeu Where userId = :userId")
    Trofeu buscarPor(int userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void adicionarTrofeu(Trofeu trofeu);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void editarTrofeu(Trofeu... trofeu);

    @Delete
    void excluirTrofeu(Trofeu... trofeu);

    @Query("Delete From Trofeu Where id = :id")
    void excluirPor(long id);
}
