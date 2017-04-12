package hc.healthcheck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

/**
 * Created by Hp on 4/2/2017.
 */

public class GioiThieu extends AppCompatActivity {
    LinearLayout manHinh2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gioithieu);
        manHinh2 = (LinearLayout) findViewById(R.id.gioi_thieu);
        manHinh2.setBackgroundResource(R.drawable.cuahai);
    }
}
