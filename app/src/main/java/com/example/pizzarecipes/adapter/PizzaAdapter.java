package com.example.pizzarecipes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzarecipes.R;
import com.example.pizzarecipes.classes.Produit;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private final Context context;
    private final List<Produit> pizzas;

    public PizzaAdapter(Context context, List<Produit> pizzas) {
        this.context = context;
        this.pizzas = pizzas;
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.row_pizza, parent, false);
        }

        // composants
        ImageView img = convertView.findViewById(R.id.imgPizza);
        ImageView share = convertView.findViewById(R.id.imgShare);
        TextView tvNom = convertView.findViewById(R.id.tvNom);
        TextView tvMeta = convertView.findViewById(R.id.tvMeta);

        // data
        Produit p = pizzas.get(position);

        img.setImageResource(p.getImageRes());
        tvNom.setText(p.getNom());
        tvMeta.setText(p.getDuree() + " • " + p.getPrix() + " €");

        // 🔥 SHARE BUTTON
        share.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String message = p.getNom() + "\n" +
                    "Prix: " + p.getPrix() + " €\n\n" +
                    p.getDescription();

            intent.putExtra(Intent.EXTRA_TEXT, message);

            context.startActivity(Intent.createChooser(intent, "Partager via"));
        });

        return convertView;
    }
}