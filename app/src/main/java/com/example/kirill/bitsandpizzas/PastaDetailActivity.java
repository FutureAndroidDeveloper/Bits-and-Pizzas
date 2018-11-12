package com.example.kirill.bitsandpizzas;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class PastaDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PASTA_ID = "pastaId";
    private TextView pastaName;
    private TextView pastaPrice;
    private ImageView pastaImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        //Set toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Display details of the pasta
        Intent intent = getIntent();
        int pastaId = intent.getIntExtra(EXTRA_PASTA_ID, -1);

        pastaName = (TextView) findViewById(R.id.pasta_name);
        pastaName.setText(Pasta.pastas[pastaId].getName());

        pastaPrice = (TextView) findViewById(R.id.pasta_price);
        pastaPrice.setText(Pasta.pastas[pastaId].getPrice());

        pastaImage = (ImageView) findViewById(R.id.pasta_image);
        int image = Pasta.pastas[pastaId].getImageResourceId();
        pastaImage.setImageDrawable(ContextCompat.getDrawable(this, image));

        pastaImage.setContentDescription(pastaName.getText());

    }
}
