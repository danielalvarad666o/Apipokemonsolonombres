package com.gasca1234.yaarto.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.yaarto.Pokeomn.pokemonNombre;
import com.gasca1234.yaarto.R;



import java.util.List;

public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.ViewHolder> {
    private List<pokemonNombre> pokemonList;

    public AdaptadorPokemon(List<pokemonNombre>pokemonList){this.pokemonList = pokemonList;}


    @NonNull
    @Override
    public AdaptadorPokemon.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPokemon.ViewHolder holder, int position) {
        holder.setData(pokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView elnombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elnombre=(TextView) itemView.findViewById(R.id.textView);
        }

        public void setData(pokemonNombre pokemon) {
            elnombre.setText(pokemon.getName());
        }
    }
}
