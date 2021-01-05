package com.americanairlines.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.americanairlines.myfourthapplication.R;
import com.americanairlines.myfourthapplication.model.Pizza;
import com.americanairlines.myfourthapplication.view.adapter.PizzaItemAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements PizzaItemAdapter.PizzaDelegate {

    //Image this was from a web server
    Pizza extravaganza = new Pizza(
            "Extravaganza",
            24.99,
            1000,
            "Mushroom, Pepperoni, Goat Chesse, Truffles, Spanish Cheese, Gold Flakes, Made with Fiji Water",
            "http://hips.hearstapps.com/toc.h-cdn.co/assets/16/50/1481914051-industry-kitchen-02.jpg" );

    Pizza popper = new Pizza(
            "Popper",
            19.99,
            1342,
            "Mushroom, Tuna, Goat Cheese, Truffles, Potatoes, Gold Flakes, Made with Fiji Water",
            "http://howtothisandthat.com/wp-content/uploads/2018/03/keto-diet-tips-2.png" );

    Pizza naniGa = new Pizza(
            "Nani ga desu ka?",
            34.99,
            7000,
            "Rice, Pepperoni, Goat Cheese, Truffles, Caviar, Gold Flakes, Baked in a pit",
            "http://bp1.blogger.com/_Yp1XV0v85c0/Rfp9ct9_jQI/AAAAAAAAAHw/H-IFBJXXSXY/w1200-h630-p-k-no-nu/ikasumi.jpg" );

    Pizza godzilla = new Pizza(
            "Godzilla",
            45.99,
            4562,
            "Squid Tentacle, Meat Balls, Pepperoni, Extra Premium Cheese, Truffles, Caviar, Gold Flakes, Baked in a pit",
            "https://gurkhason.files.wordpress.com/2014/04/pezzo-godzilla-pizza-close-up.jpg" );

    Pizza tokyo = new Pizza(
            "Tokyo",
            19.99,
            5742,
            "Flat Bread, Tomato, Basil, Chili Sauce, Golden Cheese, Truffles, Caviar, Gold Flakes, Frozen",
            "https://cdn-japantimes.com/wp-content/uploads/2020/05/np_file_13575.jpeg" );

    Pizza omega = new Pizza(
            "Omega",
            99.99,
            100000,
            "Ham, Sausage, Bacon, Pepperoni, Goat Cheese, Truffles, Caviar, Gold Flakes, Five-Cheese, Garlic, Baked in the pits of hell",
            "https://i.imgur.com/0DfHleK.jpg" );



    // With ArrayAdapter
    /*private String[] pizzas = new String[]{extravaganza.getPizzaflavor(), popper.getPizzaflavor(), naniGa.getPizzaflavor()};
    private List<String> availablePizza = Arrays.asList(pizzas);*/
    //private ArrayAdapter<String> pizzaAdapter;
    //End of mock data setup..

    // With BaseAdapter
    private Pizza[] pizzas = new Pizza[]{extravaganza, popper, naniGa, godzilla, tokyo, omega};
    private List<Pizza> availablePizza = Arrays.asList(pizzas);

    private ListView lvPizza;
    private PizzaItemAdapter pizzaAdapter = new PizzaItemAdapter(this, availablePizza);

    private ImageView pizzaImageView;
    private ConstraintLayout clPizzaLayout;
    private TextView pizzaFlavor;
    private TextView pizzaPrice;
    private TextView pizzaHint;

    private Button detailBtn;
    private Button anotherBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvPizza = findViewById(R.id.lv_pizza_list);
        pizzaImageView = findViewById(R.id.im_pizza_image);
        clPizzaLayout = findViewById(R.id.cl_quick_detail);
        pizzaFlavor = findViewById(R.id.tv_pizza_flavor);
        pizzaPrice = findViewById(R.id.tv_pizza_price);
        detailBtn = findViewById(R.id.btn_details);
        anotherBtn = findViewById(R.id.btn_pick_another);
        pizzaHint = findViewById(R.id.tv_hint);


        // Array Adapter
        //pizzaAdapter = new ArrayAdapter<String>(this, R.layout.item_pizza_flavor_layout, R.id.tv_pizza_flavor, availablePizza);

        lvPizza.setAdapter(pizzaAdapter);

        // Array Adapter
        /*lvPizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = availablePizza.get(position);

                Toast.makeText(HomeActivity.this, "Name: " + name, Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    @Override
    public void selectPizza(Pizza selectedPizza) {

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            if(clPizzaLayout.getVisibility() == View.INVISIBLE || clPizzaLayout.getVisibility() == View.GONE){
                clPizzaLayout.setVisibility(View.VISIBLE);
                pizzaHint.setVisibility(View.GONE);
            }
        } else {
            if (clPizzaLayout.getVisibility() == View.INVISIBLE || clPizzaLayout.getVisibility() == View.GONE){
                lvPizza.setVisibility(View.GONE);
                clPizzaLayout.setVisibility(View.VISIBLE);
            }

            anotherBtn.setOnClickListener(v-> {
                lvPizza.setVisibility(View.VISIBLE);
                clPizzaLayout.setVisibility(View.GONE);
            });
        }


        Glide.with(this)
                .load(selectedPizza.getImageUrl())
                .into(pizzaImageView);

        pizzaFlavor.setText(selectedPizza.getPizzaflavor());
        pizzaPrice.setText("$" + String.valueOf(selectedPizza.getPizzaPrice()));

        detailBtn.setOnClickListener(v-> {
            Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
            intent.putExtra("pizza_selected", selectedPizza);
            startActivity(intent);
        });

    }
}