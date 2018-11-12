package com.example.kirill.bitsandpizzas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastaFragment extends Fragment {


    public PastaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_pasta, container, false);

        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }


        String[] pastaPrices = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaPrices.length; i++) {
            pastaPrices[i] = Pasta.pastas[i].getPrice();
        }


        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }


        PastaAdapter adapter = new PastaAdapter(pastaNames, pastaPrices, pastaImages);
        recyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new PastaAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return recyclerView;
    }

}
