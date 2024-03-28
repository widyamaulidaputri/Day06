package basic.aktivity.day06;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView imageView = findViewById(R.id.imageDetail);
        TextView nameTxt = findViewById(R.id.dt_nama);
        TextView hargaTxt = findViewById(R.id.dt_harga);
        TextView merekTxt = findViewById(R.id.dt_merek);


        String nama = "Nama tidak Di set";
        String harga = "blabla";
        String merek = "blabla";
        int image = 0;

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            image = extras.getInt("gambar");
            nama = extras.getString("nama");
            harga = extras.getString("harga");
            merek = extras.getString("merek");
        }

        imageView.setImageResource(image);
        nameTxt.setText(nama);
        hargaTxt.setText(harga);
        merekTxt.setText(merek);
    }
}
