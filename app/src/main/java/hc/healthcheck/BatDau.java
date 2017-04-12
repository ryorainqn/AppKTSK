 package hc.healthcheck;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Hp on 4/2/2017.
 */

public class BatDau extends AppCompatActivity implements View.OnClickListener {
    private Button btnTinhBMI, btnReset, btnTV;
    private EditText editChieuCao, editCanNang;
    private TextView txtChiSo, txtDanhGia;
    RelativeLayout manHinh1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batdau);
        getControlView();
        manHinh1 = (RelativeLayout) findViewById(R.id.bat_dau);
        manHinh1.setBackgroundResource(R.drawable.cuahai);
        btnTV.setOnClickListener(this);
        btnTinhBMI.setOnClickListener(this); //gọi nút Tính BMI
        btnReset.setOnClickListener(this); //gọi nút Nhập lại thông tin
      //  init();
    }
    @Override
    public void onClick(View v) {
        try {
            //Lấy giá trị nhập vào và ép kiểu về float
            double chieuCao = Double.parseDouble(editChieuCao.getText().toString()); // cho phép người dùng nhập dữ liệu vào
            double canNang = Double.parseDouble(editCanNang.getText().toString());
            DecimalFormat df = new DecimalFormat("0.00"); //định dạng lấy đến 2 con số
            double BMI = canNang / Math.pow(chieuCao, 2) * 10000; //chiều cao * chiều cao
            switch (v.getId()) //lấy id của các Button
            {
                case R.id.btnKT: //nếu id là Button Tính
                    txtChiSo.setText(df.format(BMI) + "");
                    if (BMI < 18)
                        txtDanhGia.setText("Bạn hơi gầy");
                    else if (18 <= BMI && BMI < 25)
                        txtDanhGia.setText("Bạn bình thường");
                    else if (25 <= BMI && BMI < 30)
                        txtDanhGia.setText("Bạn béo phì độ 1");
                    else if (30 <= BMI && BMI < 35)
                        txtDanhGia.setText("Bạn béo phì độ 2");
                    else if (35 <= BMI)
                        txtDanhGia.setText("Bạn béo phì độ 3");
                    break;
                case R.id.btnReset: //nếu id là Nhập lại thông tin
                    editChieuCao.setText("");
                    editCanNang.setText("");
                    txtChiSo.setText("");
                    txtDanhGia.setText("");
                    break;
                case R.id.btnTV:
                    openTuVan();
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }
    public void openTuVan() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.chontv).setItems(R.array.chonTV1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        startApp(i);
                    }

            private void startApp(int i) {
                Intent intent = new Intent(BatDau.this, Chuoi.class);
                intent.putExtra(Chuoi.KEY_DANHGIA,i);
                startActivity(intent);
            }
        });
        builder.create().show();
    }

    private void getControlView() {
        btnTinhBMI = (Button) findViewById(R.id.btnKT);
        editChieuCao = (EditText) findViewById(R.id.edtCao);
        editCanNang = (EditText) findViewById(R.id.edtNang);
        txtChiSo = (TextView) findViewById(R.id.txtChiso);
        txtDanhGia = (TextView) findViewById(R.id.txtDanhGia);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnTV = (Button) findViewById(R.id.btnTV);
    }

}
