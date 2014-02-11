package databaseHandler;

import concert.Client;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHandler {
	
	private static final int VERSION_BDD = 1;
	private static final String BDD_NAME = "myparty.db";
 
	private static final String CLIENT_TABLE = "table_livres";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_FIRSTNAME = "firstname";
	private static final int NUM_COL_FIRSTNAME = 1;
	private static final String COL_LASTNAME = "lastname";
	private static final int NUM_COL_LASTNAME = 2;
 
	private SQLiteDatabase bdd;
  
	private DatabaseCreate SQLiteBase ;
	
	
	public DatabaseHandler(Context context){
		//On cr�er la BDD et sa table
		SQLiteBase = new DatabaseCreate(context, BDD_NAME, null, VERSION_BDD);
	}
 
	public void open(){
		//on ouvre la BDD en �criture
		bdd = SQLiteBase.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'acc�s � la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}

	public long insertClient(Client client){
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ� � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_FIRSTNAME, client.getFirstName());
		values.put(COL_LASTNAME, client.getLastName());
		//on ins�re l'objet dans la BDD via le ContentValues
		return bdd.insert(CLIENT_TABLE, null, values);
	}
 
//	public int updateLivre(int id, Livre livre){
//		//La mise � jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
//		//il faut simple pr�ciser quelle livre on doit mettre � jour gr�ce � l'ID
//		ContentValues values = new ContentValues();
//		values.put(COL_FIRSTNAME, livre.getIsbn());
//		values.put(COL_TITRE, livre.getTitre());
//		return bdd.update(CLIENT_TABLE, values, COL_ID + " = " +id, null);
//	}
 
//	public int removeLivreWithID(int id){
//		//Suppression d'un livre de la BDD gr�ce � l'ID
//		return bdd.delete(CLIENT_TABLE, COL_ID + " = " +id, null);
//	}
 
	//public Client getLivreWithTitre(String titre){
		//R�cup�re dans un Cursor les valeur correspondant � un livre contenu dans la BDD (ici on s�lectionne le livre gr�ce � son titre)
		//Cursor c = bdd.query(CLIENT_TABLE, new String[] {COL_ID, COL_FIRSTNAME, COL_LASTNAME}, COL_TITRE + " LIKE \"" + titre +"\"", null, null, null, null);
		//return cursorToLivre(c);
	//}
}
