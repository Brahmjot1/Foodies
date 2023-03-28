//Adapter
package com.brahm.retrofit;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userMeal extends RecyclerView.Adapter<userMeal.userHolder>
{
    MainActivity mainActivity;
    List<Meal> allusersList;
    selectListener listener;

    public userMeal(MainActivity mainActivity , List<Meal> allusersList ,selectListener listener)
    {
        this.mainActivity = mainActivity;
        this.allusersList= allusersList;
        this.listener=listener;
    }
    public  void setfilteredList(List<Meal>filterlist)
    {
        this.allusersList=filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_user,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, @SuppressLint("RecyclerView") int position)
    {
        holder.itemTxt.setText(allusersList.get(position).getStrIngredient());

        holder.itemTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listener.onItemClicked(allusersList.get(position));
            }

        });

    }

    @Override
    public int getItemCount() {
        return allusersList.size();
    }

    class  userHolder extends RecyclerView.ViewHolder
{
     TextView itemTxt;
     CardView cardView;
    public userHolder(@NonNull View itemView) {
        super(itemView);
        itemTxt=itemView.findViewById(R.id.itemTxt);
    }
}
}
