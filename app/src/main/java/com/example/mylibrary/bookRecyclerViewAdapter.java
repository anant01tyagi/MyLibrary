package com.example.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class bookRecyclerViewAdapter extends RecyclerView.Adapter<bookRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Book> Books = new ArrayList<>();
    private Context mContext;

    public bookRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }



    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  bookRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(Books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(Books.get(position).getImageUrl())
                .into(holder.imgBook);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, Books.get(position).getName() + " Clicked!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, BookActivity.class);
                mContext.startActivity(intent);
            }
        });

       holder.nameAuthor.setText(Books.get(position).getAuthor());
       holder.shortDesc.setText(Books.get(position).getShortDesc());

        if(Books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.cardView);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);

        }

        else{
            TransitionManager.beginDelayedTransition(holder.cardView);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return Books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        Books = books;
        notifyDataSetChanged();
        }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private ImageView imgBook;
        private TextView txtName;
        private ImageView downArrow,upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView nameAuthor, shortDesc;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName =itemView.findViewById(R.id.txtName);
            downArrow = itemView.findViewById(R.id.downArrow);
            upArrow = itemView.findViewById(R.id.upArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            nameAuthor = itemView.findViewById(R.id.nameAuthor);
            shortDesc = itemView.findViewById(R.id.shortDesc);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = Books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = Books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
