package br.edu.ifpi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import br.edu.ifpi.beans.Categoria;
import br.edu.ifpi.beans.Produto;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

	private static final String DB_NAME = "db_demo.db";
	private static final int DB_VERSION = 1;
	
	private static final String TAG_LOG= "apresentacao orm";
	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		// TODO Auto-generated method stub
		
		try{
			TableUtils.createTable(connectionSource, Produto.class);
			TableUtils.createTable(connectionSource, Categoria.class);

			Log.i(TAG_LOG, "criou as tabelas de produtos e categorias");
			
			Dao<Categoria, Integer> categoriaDao = getDao(Categoria.class);
			
			if(categoriaDao != null){
				Categoria c = new Categoria();
				c.setNome("categoria 1");
				
				Categoria c2 = new Categoria();
				c2.setNome("categoria TR00");
				
				categoriaDao.create(c);
				
				categoriaDao.create(c2);
			
				Log.i(TAG_LOG, "salvou duas instancias ");
			}
			
		}catch(Exception e){
			Log.e(TAG_LOG, "exception: "+e);
		}
				
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource connectionSource, int arg2,
			int arg3) {
		// TODO Auto-generated method stub
		
//		try{
//			
//			TableUtils.dropTable(connectionSource, Produto.class, arg2);
//			TableUtils.dropTable(connectionSource, Categoria.class, arg2);
//		}catch(Exception e){
//			Log.e(TAG_LOG, "exception: "+e);
//		}
//		

	}
	
	
	
}
