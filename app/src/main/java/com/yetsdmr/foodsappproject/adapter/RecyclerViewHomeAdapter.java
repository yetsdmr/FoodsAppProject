package com.yetsdmr.foodsappproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yetsdmr.foodsappproject.R;
import com.yetsdmr.foodsappproject.model.Categories;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.RecyclerViewHolder>{

    private List<Categories.Category> categories;
    private Context context;
    private static ClickListener clickListener;

    public RecyclerViewHomeAdapter(List<Categories.Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHomeAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHomeAdapter.RecyclerViewHolder holder, int position) {
        String strCategoryThum = categories.get(position).getStrCategoryThumb();
        Picasso.get().load(strCategoryThum).placeholder(R.drawable.ic_circle).into(holder.categoryThumb);

        String strCategoryName = categories.get(position).getStrCategory();
        holder.categoryName.setText(strCategoryName);

    }

        @Override
    public int getItemCount() {
        return categories.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.categoryThumb)
        ImageView categoryThumb;
        @BindView(R.id.categoryName)
        TextView categoryName;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view,getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ClickListener clickListener){
        RecyclerViewHomeAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }
}
