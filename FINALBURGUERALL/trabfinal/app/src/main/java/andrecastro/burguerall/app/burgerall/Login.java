package andrecastro.burguerall.app.burgerall;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment implements View.OnClickListener{

    private EditText et_email;
    private EditText et_pass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        et_email = (EditText) v.findViewById(R.id.editText);
        et_pass = (EditText) v.findViewById(R.id.editText2);

        Button login = (Button) v.findViewById(R.id.loginbutton);
        login.setOnClickListener(this);
        TextView reg = (TextView) v.findViewById(R.id.textView2);
        reg.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.loginbutton:

                if (Verificar()) {

                    MainActivity.isLogin = true;

                    Novidades nov = new Novidades();
                    android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.relative_layout_para_o_fragment, nov, nov.getTag()).commit();
                }
                break;

            case R.id.textView2:

                Registar r = new Registar();
                android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment, r, r.getTag()).commit();

                break;
            default:
                break;
        }
    }

    public boolean Verificar() {

        String email = et_email.getText().toString();
        String password = et_pass.getText().toString();

        if(TextUtils.isEmpty(email)){
            et_email.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira um email",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_email.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(password)){
            et_pass.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira uma Palavra-Passe",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_pass.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        return true;
    }

}
