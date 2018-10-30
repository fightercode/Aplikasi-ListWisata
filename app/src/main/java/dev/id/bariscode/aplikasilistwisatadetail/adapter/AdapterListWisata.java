package dev.id.bariscode.aplikasilistwisatadetail.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import dev.id.bariscode.aplikasilistwisatadetail.R;

public class AdapterListWisata extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] namaTempatWisata;
    private final String[] lokasiTempatWisata;
    private final Integer[] deskripsiTempatWisata;
    private final Integer[] gambarTempatWisata;

    public AdapterListWisata(
            Activity context,
            String[] namaTempatWisata,
            String[] lokasiTempatWisata,
            Integer[] deskripsiTempatWisata,
            Integer[] gambarTempatWisata) {
        super(context, R.layout.item_wisata, namaTempatWisata);

        this.context = context;
        this.namaTempatWisata = namaTempatWisata;
        this.lokasiTempatWisata = lokasiTempatWisata;
        this.deskripsiTempatWisata = deskripsiTempatWisata;
        this.gambarTempatWisata = gambarTempatWisata;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_wisata, null, true);

        TextView txtNamaWisata, txtLokasiWisata, txtDeskripsiWisata;
        ImageView imvTempatWisata;

        txtNamaWisata = (TextView)rowView.findViewById(R.id.namaWisata);
        txtLokasiWisata = (TextView)rowView.findViewById(R.id.lokasiWisata);
        txtDeskripsiWisata = (TextView)rowView.findViewById(R.id.deskripsiWisata);

        imvTempatWisata = (ImageView)rowView.findViewById(R.id.gmbrWisata);

        txtNamaWisata.setText(namaTempatWisata[position]);
        txtLokasiWisata.setText(lokasiTempatWisata[position]);
        txtDeskripsiWisata.setText(deskripsiTempatWisata[position]);
        Picasso.get().load(gambarTempatWisata[position]).into(imvTempatWisata);

        return rowView;
    }
}
