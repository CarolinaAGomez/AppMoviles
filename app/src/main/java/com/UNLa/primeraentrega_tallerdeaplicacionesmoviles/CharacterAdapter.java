package com.UNLa.primeraentrega_tallerdeaplicacionesmoviles;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    List<Character> characters = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    public CharacterAdapter(List<Character> characters, OnItemClickListener onItemClickListener) {
        this.characters = characters;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCharacter = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(itemCharacter);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.name.setText("Nombre:" + characters.get(position).getName());  //ACa segun la posicion trae el elemento.
        holder.gender.setText("Genero:" + characters.get(position).getGender());
        holder.culture.setText("Cultura:" + characters.get(position).getCulture());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(characters.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView gender;
        TextView culture;
        TextView espacio;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.tvName);
            this.gender = itemView.findViewById(R.id.tvGender);
            this.culture = itemView.findViewById(R.id.tvCulture);
            this.espacio = itemView.findViewById(R.id.tvEspacio);
        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(Character character);
    }
}
