package hc.healthcheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private Button btnBD;
    private Button btnGT;
    private Button btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnBD = (Button) findViewById(R.id.btnBD);
        btnBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BatDau.class);
                startActivity(intent);
            }
        });

        Button btnGT = (Button) findViewById(R.id.btnGT);
        btnGT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GioiThieu.class);
                startActivity(intent);
            }
        });

        Button btnTH = (Button) findViewById(R.id.btnThoat);
        btnTH.setOnClickListener(new View.OnClickListener() {
              @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
