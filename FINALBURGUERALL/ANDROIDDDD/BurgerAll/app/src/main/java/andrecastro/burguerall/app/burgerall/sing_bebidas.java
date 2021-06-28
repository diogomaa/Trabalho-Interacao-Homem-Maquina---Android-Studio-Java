package andrecastro.burguerall.app.burgerall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class sing_bebidas extends Fragment {

    ListView listView;
    List<itemsingular> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sing_bebidas, container, false);

        lista = new ArrayList<>();

        listView  = (ListView) v.findViewById(R.id.bebidasListView);

        lista.add(new itemsingular(R.drawable.ic_launcher_background, "CocaCola", 1));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Fanta", 1));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Ice Tea", 1));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Água", 0.5));

        singularListAdapter adapter = new singularListAdapter(this.getActivity(), lista);

        listView.setAdapter(adapter);

        return v;
    }

}
