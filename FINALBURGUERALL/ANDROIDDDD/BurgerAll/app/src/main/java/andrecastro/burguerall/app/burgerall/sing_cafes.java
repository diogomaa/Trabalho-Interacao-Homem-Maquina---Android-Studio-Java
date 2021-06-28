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
public class sing_cafes extends Fragment {

    ListView listView;
    List<itemsingular> lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sing_cafes, container, false);

        lista = new ArrayList<>();

        listView  = (ListView) v.findViewById(R.id.cafesListView);

        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Cafe Curto", 1));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Cafe Longo", 1.5));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Descafenado", 1));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Chocolate Quente", 1));

        singularListAdapter adapter = new singularListAdapter(this.getActivity(), lista);

        listView.setAdapter(adapter);

        return v;
    }

}
