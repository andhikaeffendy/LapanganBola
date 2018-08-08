package bola.wiradipa.org.lapanganbola;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {


    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_beranda, container, false);

        ImageView sewa = (ImageView) view.findViewById(R.id.sewa_lapangan_btn);
        sewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SewaLapanganActivity.class);
                startActivity(intent);
            }
        });

        ImageView ajak_tanding = (ImageView) view.findViewById(R.id.ajak_tanding_btn);
        ajak_tanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AjakTandingActivity.class);
                startActivity(intent);
            }
        });

        CircleImageView profile = (CircleImageView) view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfilActivity.class);
                startActivity(intent);
            }
        });

        ImageView jadwal_tanding = (ImageView) view.findViewById(R.id.jadwal_tanding_btn);
        jadwal_tanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JadwalActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
