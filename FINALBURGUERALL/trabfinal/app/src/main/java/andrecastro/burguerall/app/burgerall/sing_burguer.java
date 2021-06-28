package andrecastro.burguerall.app.burgerall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class sing_burguer extends Fragment implements View.OnClickListener {

    ListView listView;
    List<itemsingular> lista;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sing_burguer, container, false);


        lista = new ArrayList<>();

        listView  = (ListView) v.findViewById(R.id.burguerListView);

        lista.add(new itemsingular(R.drawable.chicken, "Chicken", 5));
        lista.add(new itemsingular(R.drawable.cow, "Cow", 4.5));
        lista.add(new itemsingular(R.drawable.pig, "Pig", 4));
        lista.add(new itemsingular(R.drawable.bacon, "Bacon", 7));

        singularListAdapter adapter = new singularListAdapter(this.getActivity(), lista);

        listView.setAdapter(adapter);

        Button btn_v = (Button) v.findViewById(R.id.button8);
        btn_v.setOnClickListener(this);
        Button btn_p = (Button) v.findViewById(R.id.button9);
        btn_p.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.button8:

                singular sing = new singular();
                android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                sing, sing.getTag()
                        ).commit();

                break;

            case R.id.button9:

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
