package za.ac.cput.assignment6.Repos.Impl;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Set;

import za.ac.cput.assignment6.Domain.Brochure;
import za.ac.cput.assignment6.Repos.CustomerRepo;
import za.ac.cput.assignment6.conf.databases.DBConstants;

/**
 * Created by louisane Malu on 4/20/2016.
 */
public class CustomerRepoImpl extends SQLiteOpenHelper implements CustomerRepo {

    public static final String TABLE_NAME = "paddress";
    private SQLiteDatabase db;


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_POSTALCODE = "postalCode";
    public static final String COLUMN_ADDRESSTYPE = "addressTypeId";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STATE = "state";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DESCRIPTION + " TEXT NOT NULL , "
            + COLUMN_POSTALCODE + " TEXT NOT NULL , "
            + COLUMN_ADDRESSTYPE + " TEXT  NOT NULL , "
            + COLUMN_STATUS + " TEXT  NOT NULL , "
            + COLUMN_DATE + " TEXT  NOT NULL , "
            + COLUMN_STATE + " TEXT NOT NULL );";


    public CustomerRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }
    @Override
    public Brochure findById(String s) {
        return null;
    }

    @Override
    public Brochure save(Brochure entity) {
        return null;
    }

    @Override
    public Brochure update(Brochure entity) {
        return null;
    }

    @Override
    public Brochure delete(Brochure entity) {
        return null;
    }

    @Override
    public Set<Brochure> findAll() {
        return null;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
