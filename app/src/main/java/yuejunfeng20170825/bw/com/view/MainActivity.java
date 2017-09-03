package yuejunfeng20170825.bw.com.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomTextView TopText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopText = (CustomTextView) findViewById(R.id.MyTopbar);

        TopText.setOnTopBarClickListener(new CustomTextView.onTopBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(MainActivity.this, "左点击了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this, "右点击了", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
