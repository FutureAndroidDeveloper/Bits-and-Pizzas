package com.example.kirill.bitsandpizzas;

public class Pasta {
    private String name;
    private String price;
    private int imageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Farfalle", "$5", R.drawable.farfalle),
            new Pasta("Fiori", "$7", R.drawable.fiori),
            new Pasta("Linguine", "$10", R.drawable.linguine),
            new Pasta("Rotini", "$15", R.drawable.rotini),
            new Pasta("Tagliatelle", "$20", R.drawable.tagliatelle)
    };


    private Pasta(String name, String price, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }


    public String getName() {
        return name;
    }
    

    public String getPrice() {
        return  price;
    }


    public int getImageResourceId() {
        return imageResourceId;
    }
}
