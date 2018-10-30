package dev.id.bariscode.aplikasilistwisatadetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailWisataActivity extends AppCompatActivity {

    ImageView imgGambarTempatWisata;
    TextView tvNameofWisata, tvLocationofWisata, tvDescriptionofWisata, tvInfoWiki, tvInfoMAPS;

    WebView loadWebwithURL;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        getSupportActionBar().setTitle("Detail Tempat Wisata");

        Bundle getData = getIntent().getExtras();

        imgGambarTempatWisata = (ImageView)findViewById(R.id.imgSetTempatWisata);
        tvNameofWisata = (TextView)findViewById(R.id.txtSetNamaTempatWisata);
        tvLocationofWisata = (TextView)findViewById(R.id.txtSetLokasiTempatWisata);
        tvDescriptionofWisata = (TextView)findViewById(R.id.txtSetDescTempatWisata);
        tvInfoWiki = (TextView)findViewById(R.id.tvInfoWikipedia);
        tvInfoMAPS = (TextView)findViewById(R.id.tvInfoMapLokasi);

        Integer getGambar = getData.getInt("GMBR_WISATA");
        String getNamaWisata = getData.getString("NAMA_TEMPATWISATA");
        String getLokasiWisata = getData.getString("LOKASI_TEMPATWISATA");
        Integer getDeskripsiWisata = getData.getInt("DESKRIPSI_TEMPATWISATA");

        tvNameofWisata.setText(getNamaWisata);
        tvLocationofWisata.setText(getLokasiWisata);
        tvDescriptionofWisata.setText(getDeskripsiWisata);

        Picasso.get().load(getGambar).into(imgGambarTempatWisata);

        tvInfoWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailWisataActivity.this, "Info Wiki", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailWisataActivity.this, MainActivity.class));
        finish();
    }

    public void showinWiki(String URL_WIKI) {

    }
}
