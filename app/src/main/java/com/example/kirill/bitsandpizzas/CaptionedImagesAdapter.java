package com.example.kirill.bitsandpizzas;

import android.support.v7.widget.RecyclerView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder> {
    private String[] names;
    private int[] imageIds;


    public static class ViewHolder extends RecyclerView.ViewHolder {

    }


    public CaptionedImagesAdapter(String[] names, int[] imageIds) {
        this.names = names;
        this.imageIds = imageIds;
    }


    @Override
    public int getItemCount() {
        return names.length;
    }
}
