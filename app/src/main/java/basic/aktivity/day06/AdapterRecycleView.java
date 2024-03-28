package basic.aktivity.day06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {
    private RecyclerViewClickListener listener;
    private ArrayList<ItemModel> dataItem;
    private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtNama;
        TextView txtHarga;
        TextView txtMerek;
        ImageView imageIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.li_nama);
            txtHarga = itemView.findViewById(R.id.li_harga);
            txtMerek = itemView.findViewById(R.id.li_merek);
            imageIcon = itemView.findViewById(R.id.imageList);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

    AdapterRecycleView(Context context, ArrayList<ItemModel> dataItem, RecyclerViewClickListener listener){
        this.context = context;
        this.dataItem = dataItem;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView txtNama = holder.txtNama;
        TextView txtHarga = holder.txtHarga;
        TextView txtMerek = holder.txtMerek;
        ImageView imageIcon = holder.imageIcon;



        txtNama.setText(dataItem.get(position).getName());
        txtHarga.setText(dataItem.get(position).getHarga());
        txtMerek.setText(dataItem.get(position).getMerek());
        imageIcon.setImageResource(dataItem.get(position).getImage());



    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
