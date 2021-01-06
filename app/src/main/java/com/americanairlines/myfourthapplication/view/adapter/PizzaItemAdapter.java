package com.americanairlines.myfourthapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.americanairlines.myfourthapplication.R;
import com.americanairlines.myfourthapplication.model.Pizza;

import java.util.List;
import java.util.zip.Inflater;

public class PizzaItemAdapter extends BaseAdapter {

    private PizzaDelegate pizzaDelegate;
    private List<Pizza> availablePizzas;


    public interface PizzaDelegate{
        void selectPizza(Pizza selectedPizza);
    }

    public PizzaItemAdapter(PizzaDelegate pizzaDelegate, List<Pizza> availablePizzas) {
        this.pizzaDelegate = pizzaDelegate;
        this.availablePizzas = availablePizzas;
    }

    @Override
    public int getCount() {
        return availablePizzas.size();
    }

    @Override
    public Pizza getItem(int position) {
        return availablePizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //This is where we inflate our view
        Pizza item = availablePizzas.get(position);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza_flavor_layout, parent, false);

        v.setOnClickListener(v1 -> {
            pizzaDelegate.selectPizza(item);
        });
        TextView pizzaFlavor = v.findViewById(R.id.tv_pizza_flavor);
        TextView pizzaPrice = v.findViewById(R.id.tv_pizza_price);

        pizzaFlavor.setText(item.getPizzaflavor());
        pizzaPrice.setText("$" + item.getPizzaPrice());

        return v;
    }
}
