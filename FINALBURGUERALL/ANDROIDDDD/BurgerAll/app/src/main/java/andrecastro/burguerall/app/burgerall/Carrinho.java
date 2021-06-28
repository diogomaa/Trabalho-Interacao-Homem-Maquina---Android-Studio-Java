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
public class Carrinho extends Fragment implements View.OnClickListener {


    public Carrinho() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_carrinho, container, false);

        Button one = (Button) v.findViewById(R.id.button7);
        one.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {

        MtdPagamento pagfragment = new MtdPagamento();
        android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.relative_layout_para_o_fragment,
                        pagfragment, pagfragment.getTag()
                ).commit();

    }
}
