package SQLite_Adapter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.github.barteksc.sample.Entry_Activity;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper implements IDatabaseHandler {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "zdManager";
    private static final String TABLE_ZD = "zd";
    private static final String KEY_ID = "id";
    private static final String KEY_ZD_NAME = "zd_name";
    private static final String KEY_LOCATION = "zd_location";
    private static final String KEY_BLOK_NUMBER = "zd_blok_number";
    private static final String KEY_SA_NAME = "sa_name";
    private static final String KEY_USO_NAME = "uso_name";
    private static final String KEY_CI_NUMBER = "CI_number";
    private static final String KEY_ZD_HOD = "zd_hod";
    private static final String KEY_ZD_MODBUS_SPEED = "zd_modbus_speed";
    private static final String KEY_ZD_MODBUS_NUMBER = "zd_modbus_number";
    private static final String KEY_ZD_MODBUS_SETTING = "zd_modbus_setting";
    private static final String KEY_ZD_TORQUE_MAX = "zd_max_torque";
    private static final String KEY_ZD_TORQUE_FOR_CLOSE = "zd_torque_for_close";
    private static final String KEY_ZD_TORQUE_FOR_START_OPEN = "zd_torque_for_start_open";
    private static final String KEY_ZD_TORQUE_FOR_OPEN = "zd_torque_for_open";
    private static final String KEY_ZD_TORQUE_FOR_START_CLOSE = "zd_torque_for_start_close";
    private static final String KEY_ZD_TYPE = "zd_type";
    private static final String KEY_ZD_TIME_TO_SLEEP = "zd_time_to_sleep";
    private static final String KEY_ZD_DISCRETE_COMMAND = "zd_discrete_command";
    private static final String KEY_ZD_OPEN_POSITION = "zd_open_position";
    private static final String KEY_ZD_CLOSE_POSITION = "zd_close_position";
    private static final String KEY_ZD_DIMENS_X = "zd_dimens_x";
    private static final String KEY_ZD_DIMENS_Y = "zd_dimens_y";
    private static final String KEY_ZD_PDF_MAIN = "zd_pdf_main";
    private static final String KEY_ZD_PDF_USO = "zd_pdf_uso";
    private static final String KEY_ZD_PDF_MAIN_PAGE = "zd_pdf_main_page";
    private static final String KEY_ZD_PDF_USO_PAGE = "zd_pdf_uso_page";
    private static final String KEY_REDUNDANT = "zd_redundant";
    private static final String KEY_REDUNDANT_2 = "zd_redundant_2";

    public DatabaseHandler(Entry_Activity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ZD + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ZD_NAME + " TEXT,"
                + KEY_LOCATION + " TEXT," + KEY_BLOK_NUMBER + " TEXT,"
                + KEY_SA_NAME + " TEXT," + KEY_USO_NAME + " TEXT,"
                + KEY_CI_NUMBER + " TEXT," + KEY_ZD_HOD + " TEXT,"
                + KEY_ZD_MODBUS_SPEED + " TEXT," + KEY_ZD_MODBUS_NUMBER + " TEXT,"
                + KEY_ZD_MODBUS_SETTING + " TEXT," + KEY_ZD_TORQUE_MAX + " TEXT,"
                + KEY_ZD_TORQUE_FOR_CLOSE + " TEXT," + KEY_ZD_TORQUE_FOR_START_OPEN + " TEXT,"
                + KEY_ZD_TORQUE_FOR_OPEN + " TEXT," + KEY_ZD_TORQUE_FOR_START_CLOSE + " TEXT,"
                + KEY_ZD_TYPE + " TEXT," + KEY_ZD_TIME_TO_SLEEP + " TEXT,"
                + KEY_ZD_DISCRETE_COMMAND + " TEXT," + KEY_ZD_OPEN_POSITION + " TEXT,"
                + KEY_ZD_CLOSE_POSITION + " TEXT," + KEY_ZD_DIMENS_X + " TEXT,"
                + KEY_ZD_DIMENS_Y + " TEXT," + KEY_ZD_PDF_MAIN + " TEXT,"
                + KEY_ZD_PDF_USO + " TEXT," + KEY_ZD_PDF_MAIN_PAGE + " TEXT,"
                + KEY_ZD_PDF_USO_PAGE + " TEXT," + KEY_REDUNDANT + " TEXT,"
                + KEY_REDUNDANT_2 + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ZD);

        onCreate(db);
    }

    @Override
    public void addZd(Zd zd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ZD_NAME, zd.get_zd_name());
        values.put(KEY_LOCATION , zd.get_zd_location());
        values.put(KEY_BLOK_NUMBER , zd.get_zd_blok_number());
        values.put(KEY_SA_NAME , zd.get_sa_name());
        values.put(KEY_USO_NAME , zd.get_uso_name());
        values.put(KEY_CI_NUMBER , zd.get_CI_number());
        values.put(KEY_ZD_HOD , zd.get_zd_hod());
        values.put(KEY_ZD_MODBUS_SPEED , zd.get_zd_modbus_speed());
        values.put(KEY_ZD_MODBUS_NUMBER , zd.get_zd_modbus_number());
        values.put(KEY_ZD_MODBUS_SETTING , zd.get_zd_modbus_setting());
        values.put(KEY_ZD_TORQUE_MAX , zd.get_zd_max_torque());
        values.put(KEY_ZD_TORQUE_FOR_CLOSE , zd.get_zd_torque_for_close());
        values.put(KEY_ZD_TORQUE_FOR_START_OPEN , zd.get_zd_torque_for_start_open());
        values.put(KEY_ZD_TORQUE_FOR_OPEN , zd.get_zd_torque_for_open());
        values.put(KEY_ZD_TORQUE_FOR_START_CLOSE , zd.get_zd_torque_for_start_close());
        values.put(KEY_ZD_TYPE , zd.get_zd_type());
        values.put(KEY_ZD_TIME_TO_SLEEP , zd.get_zd_time_to_sleep());
        values.put(KEY_ZD_DISCRETE_COMMAND , zd.get_zd_discrete_command());
        values.put(KEY_ZD_OPEN_POSITION , zd.get_zd_open_position());
        values.put(KEY_ZD_CLOSE_POSITION , zd.get_zd_close_position());
        values.put(KEY_ZD_DIMENS_X , zd.get_zd_dimens_x());
        values.put(KEY_ZD_DIMENS_Y , zd.get_zd_dimens_y());
        values.put(KEY_ZD_PDF_MAIN , zd.get_zd_pdf_main());
        values.put(KEY_ZD_PDF_USO , zd.get_zd_pdf_uso());
        values.put(KEY_ZD_PDF_MAIN_PAGE , zd.get_zd_pdf_main_page());
        values.put(KEY_ZD_PDF_USO_PAGE , zd.get_zd_pdf_uso_page());
        values.put(KEY_REDUNDANT , zd.get_zd_redundant());
        values.put(KEY_REDUNDANT_2 , zd.get_zd_redundant_2());

        db.insert(TABLE_ZD, null, values);
        db.close();
    }

    @Override
    public Zd getZd(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ZD, new String[] { KEY_ID,
                        KEY_ZD_NAME,KEY_LOCATION ,KEY_BLOK_NUMBER , KEY_SA_NAME ,
                        KEY_USO_NAME , KEY_CI_NUMBER ,KEY_ZD_HOD , KEY_ZD_MODBUS_SPEED ,
                        KEY_ZD_MODBUS_NUMBER , KEY_ZD_MODBUS_SETTING ,KEY_ZD_TORQUE_MAX , KEY_ZD_TORQUE_FOR_CLOSE ,
                        KEY_ZD_TORQUE_FOR_START_OPEN , KEY_ZD_TORQUE_FOR_OPEN , KEY_ZD_TORQUE_FOR_START_CLOSE ,
                        KEY_ZD_TYPE , KEY_ZD_TIME_TO_SLEEP , KEY_ZD_DISCRETE_COMMAND ,
                        KEY_ZD_OPEN_POSITION , KEY_ZD_CLOSE_POSITION ,KEY_ZD_DIMENS_X , KEY_ZD_DIMENS_Y ,
                        KEY_ZD_PDF_MAIN , KEY_ZD_PDF_USO , KEY_ZD_PDF_MAIN_PAGE , KEY_ZD_PDF_USO_PAGE ,
                        KEY_REDUNDANT , KEY_REDUNDANT_2}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Zd zd = new Zd(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19), cursor.getString(20), cursor.getString(21), cursor.getString(22), cursor.getString(23), cursor.getString(24), cursor.getString(25), cursor.getString(26), cursor.getString(27), cursor.getString(28));

        return zd;
    }

    @Override
    public Zd getZd(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ZD, new String[] { KEY_ID,
                        KEY_ZD_NAME , KEY_LOCATION , KEY_BLOK_NUMBER , KEY_SA_NAME ,
                        KEY_USO_NAME , KEY_CI_NUMBER , KEY_ZD_HOD , KEY_ZD_MODBUS_SPEED ,
                        KEY_ZD_MODBUS_NUMBER , KEY_ZD_MODBUS_SETTING ,KEY_ZD_TORQUE_MAX , KEY_ZD_TORQUE_FOR_CLOSE ,
                        KEY_ZD_TORQUE_FOR_START_OPEN , KEY_ZD_TORQUE_FOR_OPEN , KEY_ZD_TORQUE_FOR_START_CLOSE ,
                        KEY_ZD_TYPE , KEY_ZD_TIME_TO_SLEEP , KEY_ZD_DISCRETE_COMMAND ,
                        KEY_ZD_OPEN_POSITION , KEY_ZD_CLOSE_POSITION , KEY_ZD_DIMENS_X , KEY_ZD_DIMENS_Y ,
                        KEY_ZD_PDF_MAIN , KEY_ZD_PDF_USO , KEY_ZD_PDF_MAIN_PAGE , KEY_ZD_PDF_USO_PAGE ,
                        KEY_REDUNDANT , KEY_REDUNDANT_2}, KEY_ZD_NAME + "=?",
                new String[] { name }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Zd zd = new Zd(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17), cursor.getString(18), cursor.getString(19), cursor.getString(20), cursor.getString(21), cursor.getString(22), cursor.getString(23), cursor.getString(24), cursor.getString(25), cursor.getString(26), cursor.getString(27), cursor.getString(28));

        return zd;
    }

    @Override
    public ArrayList<String> getZdNotClear(String name) {
        ArrayList<String> queryLIKE = new ArrayList<String>();

        String selectQuery = "SELECT  * FROM " + TABLE_ZD + " WHERE " + KEY_ZD_NAME + " LIKE '%" + name + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor != null){
            if (cursor.moveToFirst()) {
                do {
                    queryLIKE.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return queryLIKE;
    }


    @Override
    public List<Zd> getAllZd() {
        List<Zd> zdList = new ArrayList<Zd>();
        String selectQuery = "SELECT  * FROM " + TABLE_ZD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Zd zd = new Zd();
                zd.set_id(Integer.parseInt(cursor.getString(0)));
                zd.set_zd_name(cursor.getString(1));
                zd.set_zd_location(cursor.getString(2));
                zd.set_zd_blok_number(cursor.getString(3));
                zd.set_sa_name(cursor.getString(4));
                zd.set_uso_name(cursor.getString(5));
                zd.set_CI_number(cursor.getString(6));
                zd.set_zd_hod(cursor.getString(7));
                zd.set_zd_modbus_speed(cursor.getString(8));
                zd.set_zd_modbus_number(cursor.getString(9));
                zd.set_zd_modbus_setting(cursor.getString(10));
                zd.set_zd_max_torque(cursor.getString(11));
                zd.set_zd_torque_for_close(cursor.getString(12));
                zd.set_zd_torque_for_start_open(cursor.getString(13));
                zd.set_zd_torque_for_open(cursor.getString(14));
                zd.set_zd_torque_for_start_close(cursor.getString(15));
                zd.set_zd_type(cursor.getString(16));
                zd.set_zd_time_to_sleep(cursor.getString(17));
                zd.set_zd_discrete_command(cursor.getString(18));
                zd.set_zd_open_position(cursor.getString(19));
                zd.set_zd_close_position(cursor.getString(20));
                zd.set_zd_dimens_x(cursor.getString(21));
                zd.set_zd_dimens_y(cursor.getString(22));
                zd.set_zd_pdf_main(cursor.getString(23));
                zd.set_zd_pdf_uso(cursor.getString(24));
                zd.set_zd_pdf_main_page(cursor.getString(25));
                zd.set_zd_pdf_uso_page(cursor.getString(26));
                zd.set_zd_redundant(cursor.getString(27));
                zd.set_zd_redundant_2(cursor.getString(28));

                zdList.add(zd);
            } while (cursor.moveToNext());
        }

        return zdList;
    }

    @Override
    public int updateZd(Zd zd) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ZD_NAME, zd.get_zd_name());
        values.put(KEY_LOCATION, zd.get_zd_location());
        values.put(KEY_BLOK_NUMBER, zd.get_zd_blok_number());
        values.put(KEY_SA_NAME, zd.get_sa_name());
        values.put(KEY_USO_NAME, zd.get_uso_name());
        values.put(KEY_CI_NUMBER, zd.get_CI_number());
        values.put(KEY_ZD_HOD, zd.get_zd_hod());
        values.put(KEY_ZD_MODBUS_SPEED, zd.get_zd_modbus_speed());
        values.put(KEY_ZD_MODBUS_NUMBER, zd.get_zd_modbus_number());
        values.put(KEY_ZD_MODBUS_SETTING, zd.get_zd_modbus_setting());
        values.put(KEY_ZD_TORQUE_MAX, zd.get_zd_max_torque());
        values.put(KEY_ZD_TORQUE_FOR_CLOSE, zd.get_zd_torque_for_close());
        values.put(KEY_ZD_TORQUE_FOR_START_OPEN, zd.get_zd_torque_for_start_open());
        values.put(KEY_ZD_TORQUE_FOR_OPEN, zd.get_zd_torque_for_open());
        values.put(KEY_ZD_TORQUE_FOR_START_CLOSE, zd.get_zd_torque_for_start_close());
        values.put(KEY_ZD_TYPE, zd.get_zd_type());
        values.put(KEY_ZD_TIME_TO_SLEEP, zd.get_zd_time_to_sleep());
        values.put(KEY_ZD_DISCRETE_COMMAND, zd.get_zd_discrete_command());
        values.put(KEY_ZD_OPEN_POSITION, zd.get_zd_open_position());
        values.put(KEY_ZD_CLOSE_POSITION, zd.get_zd_close_position());
        values.put(KEY_ZD_DIMENS_X, zd.get_zd_dimens_x());
        values.put(KEY_ZD_DIMENS_Y, zd.get_zd_dimens_y());
        values.put(KEY_ZD_PDF_MAIN, zd.get_zd_pdf_main());
        values.put(KEY_ZD_PDF_USO, zd.get_zd_pdf_uso());
        values.put(KEY_ZD_PDF_MAIN_PAGE, zd.get_zd_pdf_main_page());
        values.put(KEY_ZD_PDF_USO_PAGE, zd.get_zd_pdf_uso_page());
        values.put(KEY_REDUNDANT, zd.get_zd_redundant());
        values.put(KEY_REDUNDANT_2, zd.get_zd_redundant_2());

        return db.update(TABLE_ZD, values, KEY_ID + " = ?",
                new String[] { String.valueOf(zd.get_id()) });
    }

    @Override
    public void deleteZd(Zd zd) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ZD, KEY_ID + " = ?", new String[] { String.valueOf(zd.get_id()) });
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ZD, null, null);
        db.close();
    }

    @Override
    public int getZdCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ZD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}