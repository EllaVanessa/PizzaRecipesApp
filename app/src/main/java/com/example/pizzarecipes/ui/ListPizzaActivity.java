package com.example.pizzarecipes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.adapter.PizzaAdapter;
import com.example.pizzarecipes.classes.Produit;
import com.example.pizzarecipes.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    private ListView lvPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        // Initialiser la ListView
        lvPizzas = findViewById(R.id.lvPizzas);

        // Récupérer les données
        List<Produit> pizzas = ProduitService.getInstance().findAll();

        // Lier avec l'adapter
        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        lvPizzas.setAdapter(adapter);

        // Gestion du clic
        lvPizzas.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
            intent.putExtra("pizza_id", id);
            startActivity(intent);
        });
    }
}