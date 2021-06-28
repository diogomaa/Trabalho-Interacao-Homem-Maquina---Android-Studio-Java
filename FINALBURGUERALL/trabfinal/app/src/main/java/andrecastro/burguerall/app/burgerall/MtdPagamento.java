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
public class MtdPagamento extends Fragment implements View.OnClickListener {


    public MtdPagamento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mtd_pagamento, container, false);

        Button btn_v = (Button) v.findViewById(R.id.button8);
        btn_v.setOnClickListener(this);
        Button btn_p = (Button) v.findViewById(R.id.button9);
        btn_p.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button9:

                EstadoPagamento sing = new EstadoPagamento();
                android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                sing, sing.getTag()
                        ).commit();

                break;

            case R.id.button8:

                Carrinho car = new Carrinho();
                android.support.v4.app.FragmentManager manager2 = getActivity().getSupportFragmentManager();
                manager2.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                car, car.getTag()
                        ).commit();

                break;
        }
    }
}
