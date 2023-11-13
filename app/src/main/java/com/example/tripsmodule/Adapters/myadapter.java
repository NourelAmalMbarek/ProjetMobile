package com.example.tripsmodule.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.tripsmodule.Activities.updatedata;
import com.example.tripsmodule.DAO.EventDao;
import com.example.tripsmodule.Database.AppDatabase;
import com.example.tripsmodule.Domains.EventsDomain;
import com.example.tripsmodule.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    List<EventsDomain> eventsDomain;

    public myadapter(List<EventsDomain> eventsDomain) {
        this.eventsDomain = eventsDomain;
    }

    @NotNull
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NotNull @NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull @NonNull myadapter.myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(eventsDomain.get(position).getTitle());
        holder.location.setText(eventsDomain.get(position).getLocation());
        holder.description.setText(eventsDomain.get(position).getDescription());
        holder.score.setText(String.valueOf(eventsDomain.get(position).getScore()));
        holder.pic.setText(eventsDomain.get(position).getPic());
        holder.price.setText(String.valueOf(eventsDomain.get(position).getPrice()));

        holder.deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = Room.databaseBuilder(holder.itemView.getContext(),
                        AppDatabase.class, "room_db").allowMainThreadQueries().build();
                EventDao eventDao = db.eventDao();
                eventDao.deleteById(eventsDomain.get(position).getId());
                eventsDomain.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.editbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(holder.editbtn.getContext(), updatedata.class));

                // Passer l'ID de l'élément à mettre à jour en tant qu'extra
                intent.putExtra("id", eventsDomain.get(position).getId());

                // Passer les autres attributs
                intent.putExtra("utitle", eventsDomain.get(position).getTitle());
                intent.putExtra("ulocation", eventsDomain.get(position).getLocation());
                intent.putExtra("udescription", eventsDomain.get(position).getDescription());
                intent.putExtra("uscore", eventsDomain.get(position).getScore());
                intent.putExtra("upic", eventsDomain.get(position).getPic());
                intent.putExtra("uprice", eventsDomain.get(position).getPrice());
                holder.editbtn.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {

        return eventsDomain.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {

        TextView title, location, description, score, pic, price;

        ImageButton deletebtn, editbtn;

        public myviewholder(@NotNull @NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            location = itemView.findViewById(R.id.location);
            description = itemView.findViewById(R.id.description);
            score = itemView.findViewById(R.id.score);
            pic = itemView.findViewById(R.id.pic);
            price = itemView.findViewById(R.id.price);
            deletebtn = itemView.findViewById(R.id.deleteBtn);
            editbtn = itemView.findViewById(R.id.editbtn);

        }
    }
}
