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
public class singular extends Fragment implements View.OnClickListener{


    public singular() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_singular, container, false);

        Button one = (Button) v.findViewById(R.id.buttonBurguers);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) v.findViewById(R.id.buttonBatatas);
        two.setOnClickListener(this);
        Button three = (Button) v.findViewById(R.id.buttonBebidas);
        three.setOnClickListener(this);
        Button four = (Button) v.findViewById(R.id.buttonSobremesas);
        four.setOnClickListener(this);
        Button five = (Button) v.findViewById(R.id.buttonCafes);
        five.setOnClickListener(this);

        return v;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public void onClick(View v) {
        // default method for handling onClick Events..

        switch (v.getId()) {

            case R.id.buttonBurguers:
                // do your code

                sing_burguer burguerfragment = new sing_burguer();
                android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                burguerfragment, burguerfragment.getTag()
                        ).commit();

                break;

            case R.id.buttonBatatas:
                // do your code

                sing_batatas batatasfragment = new sing_batatas();
                android.support.v4.app.FragmentManager manager2 = getActivity().getSupportFragmentManager();
                manager2.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                batatasfragment, batatasfragment.getTag()
                        ).commit();

                break;

            case R.id.buttonBebidas:
                // do your code

                sing_bebidas bebidasfragment = new sing_bebidas();
                android.support.v4.app.FragmentManager manager3 = getActivity().getSupportFragmentManager();
                manager3.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                bebidasfragment, bebidasfragment.getTag()
                        ).commit();
                break;

            case R.id.buttonSobremesas:
                // do your code

                sing_sobremesas sobrefragment = new sing_sobremesas();
                android.support.v4.app.FragmentManager manager4 = getActivity().getSupportFragmentManager();
                manager4.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                sobrefragment, sobrefragment.getTag()
                        ).commit();
                break;

            case R.id.buttonCafes:
                // do your code

                sing_cafes cafesfragment = new sing_cafes();
                android.support.v4.app.FragmentManager manager5 = getActivity().getSupportFragmentManager();
                manager5.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                cafesfragment, cafesfragment.getTag()
                        ).commit();
                break;

            default:
                break;
        }
    }
}
