package com.americanairlines.myfourthapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.americanairlines.myfourthapplication.R;
import com.americanairlines.myfourthapplication.model.Pizza;
import com.bumptech.glide.Glide;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    private Pizza pizza;

    private ImageView pizzaImage;

    private TextView pizzaName;
    private TextView pizzaIngredients;
    private TextView pizzaPrice;
    private TextView pizzaImageUrl;
    private TextView pizzaCalories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        pizzaImage = findViewById(R.id.im_pizza_flavor);
        pizzaName = findViewById(R.id.tv_pizza_flavor);
        pizzaIngredients = findViewById(R.id.tv_ingredients);
        pizzaPrice = findViewById(R.id.tv_pizza_price);
        pizzaImageUrl = findViewById(R.id.tv_image_url);
        pizzaCalories = findViewById(R.id.tv_calories);

        Intent intent = getIntent();

        pizza = (Pizza) intent.getSerializableExtra("pizza_selected");

        Glide.with(this)
                .load(pizza.getImageUrl())
                .into(pizzaImage);

        pizzaName.setText(pizza.getPizzaflavor());
        pizzaIngredients.setText(pizza.getIngredients());
        pizzaPrice.setText("$" + pizza.getPizzaPrice());
        pizzaImageUrl.setText(pizza.getImageUrl());
        pizzaCalories.setText(String.valueOf(pizza.getCalories()));

    }
}