package br.edu.ifpi.database;

import java.sql.SQLException;

import br.edu.ifpi.beans.Categoria;
import br.edu.ifpi.beans.Produto;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import android.content.Context;

public class UnitOfWork {

	private DatabaseHelper helper;
	
	public Dao<Categoria, Integer> catDao;
	public Dao<Produto, Integer> uDao; 
	
	public UnitOfWork(Context ctx) {
		// TODO Auto-generated constructor stub
		helper = new DatabaseHelper(ctx);
		try {
			catDao = DaoManager.createDao(helper.getConnectionSource(), Categoria.class);
			uDao = DaoManager.createDao(helper.getConnectionSource(), Produto.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
