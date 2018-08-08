package bola.wiradipa.org.lapanganbola;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CariLapanganActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<Lapangan> lapangan;
    private static LapanganAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_lapangan);

        listView = (ListView) findViewById(R.id.list_cari);
        lapangan = new ArrayList<>();

        lapangan.add(new Lapangan("Bhineka Tunggal", "Jalan Buah Batu no. 115, Bandung",
                "Futsal, cafe, wi-fi, mushola","Rp.200.000 / jam",R.drawable.lapangbola_logo,R.drawable.bintang));
        lapangan.add(new Lapangan("Lenovo", "Jalan Antapani no. 115, Bandung",
                "Futsal, cafe, wi-fi, mushola","Rp.150.000 / jam",R.drawable.lapangbola_logo,R.drawable.bintang));
        lapangan.add(new Lapangan("Asus", "Jalan PBB no. 115, Bandung",
                "Futsal, cafe, wi-fi, mushola","Rp.200.000 / jam",R.drawable.lapangbola_logo,R.drawable.bintang));
        lapangan.add(new Lapangan("Sewa indah", "Jalan Apa Aja no. 115, Bandung",
                "Futsal, cafe, wi-fi, mushola","Rp.250.000 / jam",R.drawable.lapangbola_logo,R.drawable.bintang));
        lapangan.add(new Lapangan("Asrama Futsal", "Jalan Aduhh pusing no. 115, Bandung",
                "Futsal, cafe, wi-fi, mushola","Rp.300.000 / jam",R.drawable.lapangbola_logo,R.drawable.bintang));
        lapangan.add(new Lapangan("Futsal King", "Jalan Cari tau dong no. 115, Bandung",
                "Futsal, cafe, wi-fi, mushola","Rp.500.000 / jam",R.drawable.lapangbola_logo,R.drawable.bintang));

        adapter = new LapanganAdapter(this,lapangan);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lapangan lapangans = lapangan.get(position);
                Intent intent = new Intent(CariLapanganActivity.this, DetailLapanganActivity.class);
                startActivity(intent);
                // Snackbar.make(view, "Nama: "+lapangans.getNama_lapangan() + "\nLokasi: " + lapangans.getLokasi_lapangan(),
                        //Snackbar.LENGTH_SHORT).setAction("No Action",null).show();
            }
        });
    }

}
