package com.gasca1234.yaarto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gasca1234.yaarto.Adaptador.AdaptadorPokemon;
import com.gasca1234.yaarto.MYsiglethon.SingletonRequest;
import com.gasca1234.yaarto.Pokeomn.pokemonNombre;
import com.gasca1234.yaarto.Respuesta.Respuesta;


import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AdaptadorPokemon adapter;
    List<Respuesta> Pokemon;
    List<pokemonNombre> nombre;

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mQueue = SingletonRequest.getInstance(MainActivity.this).getRequestQueue();
        Pokemon = new ArrayList<>();
        nombre= new ArrayList<>();

        jsparse();
        // Iniciar RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdaptadorPokemon(nombre);
        recyclerView.setAdapter(adapter);

    }

    public  void jsparse(){
        String urlApi ="https://pokeapi.co/api/v2/pokemon";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlApi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    Gson gson = new Gson();
                    AdaptadorPokemon adapter =new AdaptadorPokemon(nombre);
                    Respuesta pk = gson.fromJson(String.valueOf(response), (Type) Respuesta.class);
                    Pokemon.add(new Respuesta(pk.getCount(), pk.getPrevious(), pk.getNext(), pk.getResults()));
                    List<pokemonNombre> a = pk.getResults();
                    for (int i = 0; i < a.size(); i++) {
                        nombre.add(new pokemonNombre(a.get(i).getName(), a.get(i).getUrl()));
                    }


            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}