package br.edu.ifpi.beans;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Categoria {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField
	private String nome;

	@ForeignCollectionField
	private ForeignCollection<Produto> produtos;

	public ForeignCollection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ForeignCollection<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}

}
