package com.fordroid.gameheroequiz.bd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.fordroid.gameheroequiz.data.Character;

public class DBHelper extends SQLiteOpenHelper {
	private static String DB_PATH = "/data/data/com.fordroid.gameheroequiz/databases/";
	private static String DB_NAME = "characterBD";
	private static int VERSION = 1;
	private SQLiteDatabase myDataBase;
	private final Context myContext;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
		this.myContext = context;
	}

	public void createDataBase() throws IOException {
		boolean dbExist = checkDataBase();
		if (!dbExist) {
			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();

			try {
				copyDataBase();
			} catch (IOException e) {
				throw new Error("Error copying database");
			}
		}

	}

	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);
		} catch (SQLiteException e) {
			// database does't exist yet.
		}
		if (checkDB != null) {
			checkDB.close();
		}

		return checkDB != null ? true : false;
	}

	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void openDataBase() throws SQLException {
		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READWRITE);
	}

	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	public int getCountRespByLevel(int level, int diff) {
		int num = 0;
		Cursor c = myDataBase.rawQuery(
				"SELECT count(*) FROM character WHERE level = " + level
						+ " AND resp > " + (diff - 1), null);

		c.moveToFirst();
		num = c.getInt(0);
		c.close();
		return num;
	}

	public int getCountResp(int diff) {
		int num = 0;
		Cursor c = myDataBase.rawQuery(
				"SELECT count(*) FROM character WHERE resp > " + (diff - 1),
				null);

		c.moveToFirst();
		num = c.getInt(0);
		c.close();
		return num;
	}

	public List<Character> getCharacterByLevel(int level) {
		List<Character> charList = new ArrayList<Character>();
		Cursor c = myDataBase.rawQuery(
				"SELECT id,name,resp FROM character WHERE level = " + level,
				null);
		while (c.moveToNext()) {
			Character character = new Character();
			character.setId(Integer.parseInt((c.getString(0))));
			character.setName(c.getString(1));
			character.setResp((Integer.parseInt((c.getString(2)))));
			character.setLevel(level);
			charList.add(character);
		}

		c.close();

		return charList;
	}

	public Character getCharacterById(int id) {
		String aux = "";
		Character character = new Character();
		Cursor c = myDataBase.rawQuery(
				"SELECT id,name,name_pos1,name_pos2,image,resp FROM character WHERE id = "
						+ id, null);
		while (c.moveToNext()) {
			character.setId(Integer.parseInt((c.getString(0))));
			character.setName(c.getString(1));

			aux = c.getString(2);
			if (aux != null)
				character.setName_pos1(aux.toLowerCase());
			else
				character.setName_pos1(" ");
			
			aux = c.getString(3);
			if (aux != null)
				character.setName_pos2(aux.toLowerCase());
			else
				character.setName_pos2(" ");
			
			aux = c.getString(4);
			if (aux != null)
				character.setImage(aux.toLowerCase());
			else
				character.setImage(" ");
			
			character.setResp((Integer.parseInt((c.getString(5)))));
		}

		c.close();

		return character;
	}

	public void updateRespCharacter(int resp, int id) {
		ContentValues cv = new ContentValues();
		cv.put("resp", resp);
		myDataBase.update("character", cv, "id = " + id, null);
	}
}
