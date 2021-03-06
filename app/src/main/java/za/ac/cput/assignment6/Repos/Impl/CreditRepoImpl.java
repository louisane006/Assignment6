package za.ac.cput.assignment6.Repos.Impl;

/**
 * Created by louisane Malu on 4/20/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.assignment6.Domain.Customer;
import za.ac.cput.assignment6.Repos.CustomerRepo;
import za.ac.cput.assignment6.conf.databases.DBConstants;

/**
 * Created by louisane Malu on 4/20/2016.
 */
public class CustomerRepoImpl extends SQLiteOpenHelper implements CustomerRepo {

    public static final String TABLE_NAME = "customerDetails";
    private SQLiteDatabase db;


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CUSTNUM = "custNum";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CUSTNUM + " TEXT NOT NULL , "
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_SURNAME + " TEXT  NOT NULL ), ";

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
    public Customer findById(String id) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CUSTNUM,
                        COLUMN_NAME,
                        COLUMN_SURNAME,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Customer personalAddress = new Customer.Builder()
                    .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .custNum(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTNUM)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                    .build();
            return personalAddress;
        } else {
            return null;
        }
    }

    @Override
    public Customer save(Customer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_CUSTNUM, entity.getCustNum());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Customer insertedEntity = new Customer.Builder()
                .copy(entity)
                .identification(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Customer update (Customer entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_CUSTNUM, entity.getCustNum());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())}
        );
        return entity;
    }
    @Override
    public Customer delete(Customer entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())});
        return entity;
    }

    @Override
    public Set<Customer> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Customer> c = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Customer cust = new Customer.Builder()
                        .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .custNum(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTNUM)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .build();
                c.add(cust);
            } while (cursor.moveToNext());
        }
        return c;
    }
    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}