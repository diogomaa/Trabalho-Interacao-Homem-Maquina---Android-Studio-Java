package andrecastro.burguerall.app.burgerall;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment implements View.OnClickListener{


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        Button login = (Button) v.findViewById(R.id.loginbutton);
        login.setOnClickListener(this);



        return v;
    }

    @Override
    public void onClick(View v) {

        EditText email = (EditText) v.findViewById(R.id.editText);
        EditText pass = (EditText) v.findViewById(R.id.editText2);

                /*if (email.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Preencha o email", Toast.LENGTH_LONG);
                } else if (pass.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Preencha a password", Toast.LENGTH_LONG);
                }

                else if (email.getText().toString().matches("andre98castroo@gmail.com") && pass.getText().toString().matches("1234")) {*/

            Novidades nov = new Novidades();
            android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment, nov, nov.getTag()).commit();

                /*} else {
                    Toast.makeText(getActivity(), "Dados Errados", Toast.LENGTH_LONG);
                }*/


    }

}
