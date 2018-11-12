package com.example.kirill.bitsandpizzas;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PastaAdapter extends RecyclerView.Adapter<PastaAdapter.ViewHolder> {
    private String[] pastas;
    private String[] prices;
    private int[] imageIds;
    private Listener listener;


    interface Listener {
        void onClick(int position);
    }


    PastaAdapter(String[] pastas, String[] prices, int[] imageIds) {
        this.pastas = pastas;
        this.prices = prices;
        this.imageIds = imageIds;
    }


    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return pastas.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView name, price;
        private ImageView image;

        ViewHolder(CardView view) {
            super(view);
            cardView = view;
            name = (TextView) view.findViewById(R.id.info_text);
            price = (TextView) view.findViewById(R.id.info_price);
            image = (ImageView) view.findViewById(R.id.info_image);
        }
    }


    @NonNull
    @Override
    public PastaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CardView cardView = (CardView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_pasta, viewGroup, false);

        return new ViewHolder(cardView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(pastas[i]);
        viewHolder.price.setText(prices[i]);
        viewHolder.image.setImageResource(imageIds[i]);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(i);
                }
            }
        });
    }
}
