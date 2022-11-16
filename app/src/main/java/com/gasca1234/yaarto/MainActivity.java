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
import com.google.gson.reflect.TypeToken;

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
        nombre = new ArrayList<>();

        jsparse();
        // Iniciar RecyclerView


    }

    public void jsparse() {
        String urlApi = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=1154";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlApi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RecyclerView recyclerView = findViewById(R.id.recyclerview);

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Gson gson = new Gson();
                Respuesta pk = gson.fromJson(response.toString(), Respuesta.class);
                adapter = new AdaptadorPokemon(pk.getResults());

                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}