package br.edu.ifpi.ui;

import java.sql.SQLException;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import br.edu.ifpi.beans.Categoria;
import br.edu.ifpi.beans.Produto;
import br.edu.ifpi.database.DatabaseHelper;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class Main extends OrmLiteBaseActivity<DatabaseHelper> implements
		OnClickListener {
	/** Called when the activity is first created. */

	EditText txtNome, txtPreco, txtQuantidade;
	Spinner spinnerCategorias;
	Button btnSalvar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.cadastro_produto);

		txtNome = (EditText) findViewById(R.id.editTextProdutoNome);
		txtPreco = (EditText) findViewById(R.id.editPreco);
		txtQuantidade = (EditText) findViewById(R.id.editTextQuantidade);

		spinnerCategorias = (Spinner) findViewById(R.id.spinnerCategoria);

		btnSalvar = (Button) findViewById(R.id.salvar);

		btnSalvar.setOnClickListener(this);

		try {
			Dao<Categoria, Integer> catDao = DaoManager.createDao(getHelper()
					.getConnectionSource(), Categoria.class);

			spinnerCategorias.setAdapter(new ArrayAdapter<Categoria>(
					getApplicationContext(),
					android.R.layout.simple_dropdown_item_1line, catDao
							.queryForAll()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			Toast.makeText(getApplicationContext(), "Exception: "+e, Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "no onClick()", Toast.LENGTH_SHORT).show();
		if (btnSalvar == v) {
			
			try {
				Dao<Produto, Integer> uDao = DaoManager.createDao(getHelper().getConnectionSource(), Produto.class);
				
				Produto p = new Produto();
				p.setNome(txtNome.getText().toString()); 
				p.setQuantidade(Integer.parseInt(txtQuantidade.getText().toString()));
				p.setPreco(Double.parseDouble(txtPreco.getText().toString()));
				p.setCategoria((Categoria)spinnerCategorias.getSelectedItem());
				
				
				if(uDao.create(p) == 1){
					Toast.makeText(getApplicationContext(), "Aee, salvou!", Toast.LENGTH_SHORT).show();
					
					
					Intent i = new Intent(this, ProdutosList.class);
					startActivity(i);
				}else{
					Toast.makeText(getApplicationContext(), "não salvou", Toast.LENGTH_SHORT).show();
				}
				 
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}