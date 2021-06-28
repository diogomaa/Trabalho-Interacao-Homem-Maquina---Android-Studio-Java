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
public class sing_burguer extends Fragment {

    ListView listView;
    List<itemsingular> lista;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sing_burguer, container, false);


        lista = new ArrayList<>();

        listView  = (ListView) v.findViewById(R.id.burguerListView);

        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Chicken", 5));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Cow", 4.5));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Pig", 4));
        lista.add(new itemsingular(R.drawable.ic_launcher_background, "Bacon", 7));

        singularListAdapter adapter = new singularListAdapter(this.getActivity(), lista);

        listView.setAdapter(adapter);

        return v;
    }

}
