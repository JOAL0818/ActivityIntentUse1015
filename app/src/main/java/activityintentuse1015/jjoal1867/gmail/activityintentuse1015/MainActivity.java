package activityintentuse1015.jjoal1867.gmail.activityintentuse1015;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView mainLabel;
    Button toSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLabel = (TextView)findViewById(R.id.mainLabel);
        toSub = (Button)findViewById(R.id.toSub);

        toSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //출력할 Activity의 Intent 만들기
                //하위 Activity 인스턴스를 직접 생성하지 않습니다.***
                //Activity를 이용해서는 데이터를 전달할 수 없습니다. (***제어의 역전 IOC)
                Intent intent = new Intent(MainActivity.this,SubActivity.class);


                //1-기본)Activity가 출력되기 전에 데이터를 설정해줘야한다
                intent.putExtra("data", "메인에서 넘겨준 데이터");
                //2-응용)여러개 주고싶은 경우에는 map이용 (map은 인터페이스라 사용불가능 / 대신 hashmap을 사용)
                HashMap<String,Object> map = new HashMap<>();
                map.put("이름","한글이름");
                map.put("나이", 45);
                intent.putExtra("data",map);

                //Activity출력
                //startActivity(intent);
                //하위 Activity에서 데이터를 리턴받을 수 있는 메소드를 호출해서 하위 Activity 출력
                startActivityForResult(intent,100);
            }
        });

        Log.e("MainActivity","onCreate호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity","onResume호출");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100&&resultCode==100){
            String subdata = data.getStringExtra("subdata");
            mainLabel.setText(subdata);
        }
    }
}
