package andrecastro.burguerall.app.burgerall;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class comida extends Fragment implements View.OnClickListener {

    ListView listView;
    List<Hamburguer> burguerList;

    //public comida() {
        // Required empty public constructor
    //}

    //private Context context;

    /*@Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }*/



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_comida, container, false);


        burguerList = new ArrayList<>();

        listView  = (ListView) v.findViewById(R.id.comidaListView);

        burguerList.add(new Hamburguer(R.drawable.ic_launcher_background, "BEEF", "100% Carne de Vaca", 5, 8));
        burguerList.add(new Hamburguer(R.drawable.ic_launcher_background, "CHICKEN", "Queijo da Serra", 5.5, 8.5));
        burguerList.add(new Hamburguer(R.drawable.ic_launcher_background, "BACON", "Bacon de Porco", 7,10));


       // listView.setAdapter(new HamburguerListAdapter(getActivity(), burguerList));
        //listView =(ListView)v.findViewById(R.id.comidaListView);


        //creating the adapter
        HamburguerListAdapter adapter = new HamburguerListAdapter(this.getActivity(), burguerList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);

        Button voltar = (Button) v.findViewById(R.id.button8);
        voltar.setOnClickListener(this);


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
