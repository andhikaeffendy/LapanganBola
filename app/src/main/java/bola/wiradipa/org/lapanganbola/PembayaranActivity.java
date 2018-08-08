package bola.wiradipa.org.lapanganbola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PembayaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        Spinner spinnerPembayaran = (Spinner) findViewById(R.id.spinner_pembayaran);
        List<String> listPembayaran = new ArrayList<>();
        listPembayaran.add("Transfer manual");
        listPembayaran.add("Transfer ATM");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_pembayaran, listPembayaran);
        adapter.setDropDownViewResource(R.layout.spinner_pembayaran);
        spinnerPembayaran.setAdapter(adapter);

        Spinner spinnerBank = (Spinner) findViewById(R.id.spinner_bank);
        List<String> listBank = new ArrayList<>();
        listBank.add("Bank Central Asia Tbk (BCA)");
        listBank.add("BNI");
        listBank.add("Mandiri");
        listBank.add("BJB");
        ArrayAdapter<String> adapterBank = new ArrayAdapter<String>(this, R.layout.spinner_pembayaran, listBank);
        adapterBank.setDropDownViewResource(R.layout.spinner_pembayaran);
        spinnerBank.setAdapter(adapterBank);

        TextView salin = (TextView) findViewById(R.id.salin);
        SpannableString content = new SpannableString("Salin nomor rekening");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        salin.setText(content);

    }
}
