package com.besolutions.rosto.Scenarios.ScenarioPersonalInfo.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.besolutions.rosto.R;
import com.besolutions.rosto.Scenarios.ScenarioMain.Controller.MainActivity;
import com.besolutions.rosto.Scenarios.ScenarioMain.Pattrens.IFOnBackPressed;
import com.besolutions.rosto.Scenarios.ScenarioAuthentication.Controller.SignIn;
import com.besolutions.rosto.Scenarios.SenarioBranches.Controller.Branches_Fragment;
import com.besolutions.rosto.local_data.send_data;

public class Me_Fragment extends Fragment implements IFOnBackPressed {

    private View view;
    TextView txtprofile,txtpass;
    Button btnlogout;
    LinearLayout linearfaq;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.me_fragment, container, false);


        txtpass = view.findViewById(R.id.txt_EditPass);
        txtprofile = view.findViewById(R.id.txt_EditProfile);
        btnlogout = view.findViewById(R.id.btnLogOut);
        linearfaq = view.findViewById(R.id.linearFaq);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                send_data send_data = new send_data();
                send_data.userId_check(getContext(),false);

                startActivity(new Intent(getContext(), SignIn.class));
                getActivity().finish();
            }
        });


        txtprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(getContext(),Edit_Profile.class);
                startActivity(intent);

            }
        });

        txtpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(),Change_Pass.class));
            }
        });

        linearfaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new FAQ());
                fr.addToBackStack(null);
                fr.commit();

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public boolean onBackPressed() {
        MainActivity.navigation.setSelectedItemId(R.id.branches);
        FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container, new Branches_Fragment());
        fr.commit();
        return true;
    }
}
