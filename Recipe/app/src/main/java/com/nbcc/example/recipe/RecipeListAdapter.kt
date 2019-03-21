//David Cormier
//2019-03-21
package com.nbcc.example.recipe

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*


class WordListAdapter(context: Context, private val mRecipeList: LinkedList<Recipe>) :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private val mInflater: LayoutInflater
    var EXTRA_NAME: String = ""
    var context: Context

    init {
        mInflater = LayoutInflater.from(context)
        this.context = context
    }

    override fun onBindViewHolder(
        holder: WordListAdapter.WordViewHolder,
        position: Int
    ) {
        // Retrieve the data for that position.
        val mCurrent = mRecipeList[position]
        // Add the data to the view holder.
        holder.recipeDescView.text = mCurrent.description
        holder.recipeTitleView.text = mCurrent.name
    }


        override fun getItemCount(): Int {
            return mRecipeList.size
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordViewHolder {
        // Inflate an item view.
        val mItemView = mInflater.inflate(
            R.layout.recipe_item, parent, false
        )
        return WordViewHolder(mItemView, this)
    }


    inner class WordViewHolder
            (itemView: View, val mAdapter: WordListAdapter) : RecyclerView.ViewHolder(itemView), View.OnClickListener
        {
            override fun onClick(v: View?) {
                // Get the position of the item that was clicked.
                val mPosition = layoutPosition
                EXTRA_NAME = mRecipeList[mPosition].name
                // Use that to access the affected item in mWordList.
                val element = mRecipeList[mPosition]
                // Change the word in the mWordList.

                // Notify the adapter, that the data has changed so it can
                // update the RecycslerView to display the data.
                mAdapter.notifyDataSetChanged()

                val intent = Intent(context, RecipeActivity::class.java)
                //Adds fields to intent
                intent.putExtra("name",mRecipeList[mPosition].name)
                intent.putExtra("ingredients",mRecipeList[mPosition].ingredients)
                intent.putExtra("directions",mRecipeList[mPosition].directions)
                intent.putExtra("image",mRecipeList[mPosition].image)

                context.startActivity(intent)

            }

            val recipeDescView: TextView
            val recipeTitleView: TextView

            init {
                recipeDescView = itemView.findViewById(R.id.recipe_desc)
                recipeTitleView = itemView.findViewById(R.id.recipe_name)
                itemView.setOnClickListener(this)
            }
        }
    }
