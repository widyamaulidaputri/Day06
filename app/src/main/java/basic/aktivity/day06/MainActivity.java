package basic.aktivity.day06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<ItemModel> data;

    private AdapterRecycleView.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i < MyItem.nama.length; i++) {
            data.add(new ItemModel(
                    MyItem.nama[i],
                    MyItem.harga[i],
                    MyItem.merek[i],
                    MyItem.iconlist[i]));
        }
        setOnClickListener();
        recyclerViewAdapter = new AdapterRecycleView(this, data, listener);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void setOnClickListener() {
        listener = new AdapterRecycleView.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), Detail.class);
                intent.putExtra("gambar", data.get(position).getImage());
                intent.putExtra("nama", data.get(position).getName());
                intent.putExtra("harga", data.get(position).getHarga());
                intent.putExtra("merek", data.get(position).getMerek());
                startActivity(intent);
            }

        };
    }
}