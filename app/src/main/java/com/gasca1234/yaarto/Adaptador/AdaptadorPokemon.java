package com.gasca1234.yaarto.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gasca1234.yaarto.Pokeomn.pokemonNombre;
import com.gasca1234.yaarto.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.ViewHolder> {
    private List<pokemonNombre> pokemonList;



    private Context context;

    public AdaptadorPokemon(Context context) {
        this.context = context;
        pokemonList = new ArrayList<>();
    }
    public AdaptadorPokemon(List<pokemonNombre>pokemonList){this.pokemonList = pokemonList;}


    @NonNull
    @Override
    public AdaptadorPokemon.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(pokemonList.get(position));
        pokemonNombre p = pokemonList.get(position);
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + p.getNumber() + ".png").into(holder.fotoImageView);

    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView fotoImageView;
        TextView elnombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elnombre=(TextView) itemView.findViewById(R.id.textView);
            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
        }

        public void setData(pokemonNombre pokemon) {
            elnombre.setText(pokemon.getName());
        }
    }
}
