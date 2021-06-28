package andrecastro.burguerall.app.burgerall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Carrinho extends Fragment implements View.OnClickListener {

    public static double total=0;

    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_carrinho, container, false);

        listView = (ListView) v.findViewById(R.id.CarrinhoListView);


        CarrinhoListAdapter adapter = new CarrinhoListAdapter(this.getActivity(), MainActivity.listaCar);

        listView.setAdapter(adapter);


        Button one = (Button) v.findViewById(R.id.button7);
        one.setOnClickListener(this);

        TextView t = (TextView) v.findViewById(R.id.textView8);
        t.setText("Total: " + Double.toString(total) + "€");

        return v;
    }


    @Override
    public void onClick(View v) {

        if (MainActivity.isLogin) {

            MtdPagamento pagfragment = new MtdPagamento();
            android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            pagfragment, pagfragment.getTag()
                    ).commit();

        } else {

            Login loginfragment = new Login();
            android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            loginfragment, loginfragment.getTag()
                    ).commit();
        }
    }

}
