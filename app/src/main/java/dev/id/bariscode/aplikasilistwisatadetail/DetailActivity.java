package dev.id.bariscode.aplikasilistwisatadetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView txtNama, txtLokasi, txtDeskripsi;

        txtNama = (TextView)findViewById(R.id.tvGetNamaWisata);
        txtLokasi = (TextView)findViewById(R.id.tvGetLokasiWisata);
        txtDeskripsi = (TextView)findViewById(R.id.tvGetDeskripsiWisata);

        Bundle ambilData = getIntent().getExtras();

        String getNamaWisata = ambilData.getString("NAMA_TEMPATWISATA");
        String getLokasiWisata = ambilData.getString("LOKASI_TEMPATWISATA");
        String getDeskripsiWisata = ambilData.getString("DESKRIPSI_TEMPATWISATA");

        txtNama.setText(getNamaWisata);
        txtLokasi.setText(getLokasiWisata);
        txtDeskripsi.setText(getDeskripsiWisata);
    }
}
