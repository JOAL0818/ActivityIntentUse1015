package activityintentuse1015.jjoal1867.gmail.activityintentuse1015;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        //첫번째 매개변수 : context, 두번째 매개변수 : 파일명
        //세번째 매개변수 : Cursor를 직접 만든 경우 지정, 네번째 매개변수 : 버전
        super(context,"database.sqlite3",null,1);
    }

    //데이터베이스를 처음 사용할 때, 한번 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tb_data("+"_id integer primary key autoincrement, "+"category text,"+"location text)";
        db.execSQL(sql);

        db.execSQL("insert into tb_data(category,location)"+"values('서울특별시','강남구')");
        db.execSQL("insert into tb_data(category,location)"+"values('서울특별시','종로구')");
        db.execSQL("insert into tb_data(category,location)"+"values('서울특별시','중랑구')");
        db.execSQL("insert into tb_data(category,location)"+"values('서울특별시','중구')");
        db.execSQL("insert into tb_data(category,location)"+"values('전라북도','순창군')");
        db.execSQL("insert into tb_data(category,location)"+"values('전라북도','전주시')");
        db.execSQL("insert into tb_data(category,location)"+"values('경기도','분당시')");
        db.execSQL("insert into tb_data(category,location)"+"values('경기도','일산시')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //테이블을 삭제하고 다시 생성
        db.execSQL("drop table tb_data");
        onCreate(db);
    }
}

