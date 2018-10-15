package activityintentuse1015.jjoal1867.gmail.activityintentuse1015;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class SubActivity extends AppCompatActivity {

    TextView subLabel;
    Button toMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        subLabel = (TextView)findViewById(R.id.subLabel);
        toMain = (Button)findViewById(R.id.toMain);

        //1-기본)메인에서 전달해 준 데이터 읽기
        final Intent intent = getIntent();
        String data= intent.getStringExtra("data");
        subLabel.setText(data);
        //2-응용)여러 데이터를 읽을 때 - map
        HashMap<String, Object> map = (HashMap<String, Object>)intent.getSerializableExtra("data");
        subLabel.setText(map.toString());

        toMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //상위 Activity에서 전달할 데이터 생성
                Intent intent = new Intent();
                intent.putExtra("subdata","하위 Activity에서 넘겨주는 데이터");
                //응답코드를 생성 한 후, 데이터 전달
                setResult(100,intent);

                finish();
            }
        });
        Log.e("SubActivity","Sub의 onCreate");
    }

    public void onResume(){
        super.onResume();
        Log.e("SubActivity","Sub의 onResume");
    }
}
