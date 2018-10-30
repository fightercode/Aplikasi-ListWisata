package dev.id.bariscode.aplikasilistwisatadetail;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import dev.id.bariscode.aplikasilistwisatadetail.adapter.AdapterListWisata;

public class MainActivity extends AppCompatActivity {

    String[] namaTempatWisata = {
            "Pulau Komodo",
            "Trio Gili",
            "Raja Ampat",
            "Danau Sentani",
            "Bali",
            "Taman Laut Bunaken",
            "Puncak Jayawijaya",
            "Tana Toraja",
            "Candi Borobudur",
            "Taman Mini Indonesia Indah"
    };

    String[] lokasiTempatWisata = {
            "Kepulauan Nusa Tenggara",
            "Lombok",
            "Papua",
            "Papua",
            "Denpasar",
            "Sulawesi Utara",
            "Papua",
            "Sulawesi Selatan",
            "Jogjakarta",
            "Jakarta"
    };

    Integer[] deskripsiTempatWisata = {
            R.string.pulau_komodo,
            R.string.trio_gili,
            R.string.raja_ampat,
            R.string.danau_sentani,
            R.string.pulau_bali,
            R.string.bunaken,
            R.string.jayawijaya,
            R.string.tana_toraja,
            R.string.borobudur,
            R.string.tmii

    };

    Integer[] gambarTempatWisata = {
            R.drawable.pulau_komodo,
            R.drawable.gili_lombok,
            R.drawable.raja_ampat,
            R.drawable.danau_sentani,
            R.drawable.pulau_bali,
            R.drawable.bunaken,
            R.drawable.puncak_jayawijaya,
            R.drawable.tana_toraja,
            R.drawable.borobudur,
            R.drawable.tmii
    };

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("List Tempat Wisata");

        AdapterListWisata listWisataAdapter = new AdapterListWisata(
                this,
                namaTempatWisata,
                lokasiTempatWisata,
                deskripsiTempatWisata,
                gambarTempatWisata);

        ListView listdaftarTempatWisata = (ListView)findViewById(R.id.listDaftarWisata);
        listdaftarTempatWisata.setAdapter(listWisataAdapter);

        listdaftarTempatWisata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long l) {
                AlertDialogData(namaTempatWisata[posisi], lokasiTempatWisata[posisi], deskripsiTempatWisata[posisi], gambarTempatWisata[posisi]);
            }
        });
    }

    public void AlertDialogData(
            final String namatempatWisata,
            final String lokasitempatWisata,
            final Integer desktempatWisata,
            final Integer gambartempatWisata) {

        builder = new AlertDialog.Builder(MainActivity.this);
        builder
                .setTitle("Info Tempat Wisata")
                .setMessage("Nama Pemain : " + namatempatWisata + "\n" +
                        "Tim Besutan : " + lokasitempatWisata + "\n" +
                        "Deskripsi Pemain : " + desktempatWisata + "\n" +
                        "Gambar Resource : " + gambartempatWisata)
                .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        KirimtoDetailActivity(namatempatWisata, lokasitempatWisata, desktempatWisata, gambartempatWisata);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.create().show();
    }

    public void KirimtoDetailActivity(String namawisata, String lokasiwisata, Integer deksripsiwisata, Integer picTempatWisata) {
        Bundle paketData = new Bundle();
        paketData.putString("NAMA_TEMPATWISATA", namawisata);
        paketData.putString("LOKASI_TEMPATWISATA", lokasiwisata);
        paketData.putInt("DESKRIPSI_TEMPATWISATA", deksripsiwisata);
        paketData.putInt("GMBR_WISATA", picTempatWisata);

        Intent prosesKirim = new Intent(MainActivity.this, DetailWisataActivity.class);
        prosesKirim.putExtras(paketData);
        startActivity(prosesKirim);
        finish();
        return;
    }
}
