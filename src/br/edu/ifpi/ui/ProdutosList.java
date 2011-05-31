package br.edu.ifpi.ui;

import java.sql.SQLException;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import br.edu.ifpi.beans.Produto;
import br.edu.ifpi.database.DatabaseHelper;

import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class ProdutosList extends OrmLiteBaseListActivity<DatabaseHelper>{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		Dao<Produto, Integer> uDao;
		try {
			uDao = DaoManager.createDao(getHelper().getConnectionSource(), Produto.class);
			setListAdapter(new ArrayAdapter<Produto>(getApplicationContext(), android.R.layout.simple_list_item_1, uDao.queryForAll()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
