package andrecastro.burguerall.app.burgerall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class EstadoPagamento extends Fragment implements View.OnClickListener {


    public EstadoPagamento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_estado_pagamento, container, false);

        Button btn_v = (Button) v.findViewById(R.id.button6);
        btn_v.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        Novidades nov = new Novidades();
        android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.relative_layout_para_o_fragment, nov, nov.getTag()).commit();
    }
}
