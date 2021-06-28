package andrecastro.burguerall.app.burgerall;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment implements View.OnClickListener{

    private TextView tv_nome;
    private TextView tv_morada;
    private TextView tv_telefone;
    private TextView tv_nif;
    private TextView tv_email;

    private Button bt_voltar;
    private Button bt_editar;

    public static User utilizador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        tv_nome = (TextView) v.findViewById(R.id.textView18);
        tv_morada = (TextView) v.findViewById(R.id.textView17);
        tv_telefone = (TextView) v.findViewById(R.id.textView16);
        tv_nif = (TextView) v.findViewById(R.id.textView15);
        tv_email = (TextView) v.findViewById(R.id.textView14);

        Intent intent = getActivity().getIntent();
        User user = (User) intent.getSerializableExtra("user");
        utilizador = user;

        final String nome = utilizador.getNome();
        final String apelido = utilizador.getApelido();
        final String email = utilizador.getEmail();
        final String morada = utilizador.getMorada();
        final String telefone = utilizador.getTelefone();
        final String nif = utilizador.getNIF();

        if (VerificarErros(nome, apelido, email, morada, telefone, nif)){

            tv_nome.setText(nome + " " + apelido);
            tv_nif.setText(nif);
            tv_morada.setText(morada);
            tv_telefone.setText(telefone);
            tv_email.setText(email);

        } else {

            MtdPagamento pagfragment = new MtdPagamento();
            android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            pagfragment, pagfragment.getTag()
                    ).commit();

        }

        bt_voltar = (Button) v.findViewById(R.id.button8);
        bt_voltar.setOnClickListener(this);
        bt_editar = (Button) v.findViewById(R.id.button9);
        bt_editar.setOnClickListener(this);

        return v;
    }

    private boolean VerificarErros(String nome, String apelido, String email, String morada, String telefone, String nif) {

        if(TextUtils.isEmpty(nome)){
            Toast.makeText(getActivity(),"Erro no email",Toast.LENGTH_LONG).show();
            return false;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(),"Erro no email",Toast.LENGTH_LONG).show();
            return false;
        }
        if(TextUtils.isEmpty(apelido)){
            Toast.makeText(getActivity(),"Erro no email",Toast.LENGTH_LONG).show();
            return false;
        }
        if(TextUtils.isEmpty(morada)){
            Toast.makeText(getActivity(),"Erro no email",Toast.LENGTH_LONG).show();
            return false;
        }
        if(TextUtils.isEmpty(telefone)){
            Toast.makeText(getActivity(),"Erro no email",Toast.LENGTH_LONG).show();
            return false;
        }
        if(TextUtils.isEmpty(nif)){
            Toast.makeText(getActivity(),"Erro no email",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button8:

                Novidades nov = new Novidades();
                android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment, nov, nov.getTag()).commit();

                break;

            case R.id.button9:

                break;

                default:
                    break;

        }

    }
}
