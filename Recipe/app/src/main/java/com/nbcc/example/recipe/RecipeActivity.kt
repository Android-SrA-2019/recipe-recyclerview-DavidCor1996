package com.nbcc.example.recipe

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_recipe.*
import kotlinx.android.synthetic.main.recipe_item.*

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val intent = intent
        txtRecipeName.text = intent.getStringExtra("name")
        txtIngredients.text = intent.getStringExtra("ingredients")
        txtDirections.text = intent.getStringExtra("directions")

            Picasso.get()
            .load(intent.getStringExtra("image"))
            .fit()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(imgRecipe)


    }


    }

