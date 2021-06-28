package andrecastro.burguerall.app.burgerall;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class Registar extends Fragment {

    private FirebaseAuth mAuth;

    private EditText et_email;
    private EditText et_password;
    private EditText et_password2;
    private EditText et_telemovel;
    private EditText et_nome;
    private EditText et_apelido;
    private EditText et_nif;
    private EditText et_morada;
    private Button bt_registar;

    private ProgressDialog progressDialog;

    public static User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registar, container, false);

        mAuth = FirebaseAuth.getInstance();

        et_email = (EditText) v.findViewById(R.id.editText3);
        et_password = (EditText) v.findViewById(R.id.editText4);
        et_password2 = (EditText) v.findViewById(R.id.editText5);
        et_telemovel = (EditText) v.findViewById(R.id.editText6);
        et_nome = (EditText) v.findViewById(R.id.editText7);
        et_apelido = (EditText) v.findViewById(R.id.editText8);
        et_nif = (EditText) v.findViewById(R.id.editText9);
        et_morada = (EditText) v.findViewById(R.id.editText10);
        bt_registar = (Button) v.findViewById(R.id.button);

        TextView login = (TextView) v.findViewById(R.id.textView12);

        progressDialog = new ProgressDialog(getActivity());


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Login l = new Login();
                android.support.v4.app.FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment, l, l.getTag()).commit();

            }
        });

        bt_registar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (Validar()) {

                    progressDialog.setMessage("Está a ser Registado. Aguarde...");
                    progressDialog.show();


                    User u = new User();

                    final String email = et_email.getText().toString();
                    final String password = et_password.getText().toString();
                    final String telemovel = et_telemovel.getText().toString();
                    final String nome = et_nome.getText().toString();
                    final String apelido = et_apelido.getText().toString();
                    final String nif = et_nif.getText().toString();
                    final String morada = et_morada.getText().toString();

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //checking if success
                                    if (task.isSuccessful()) {
                                        //display some message here
                                        Toast.makeText(getActivity(), "Registado com Sucesso", Toast.LENGTH_LONG).show();
                                    } else {
                                        //display some message here
                                        Toast.makeText(getActivity(), "Erro no Registo", Toast.LENGTH_LONG).show();
                                    }
                                    progressDialog.dismiss();
                                }
                            });


                    u.setEmail(email);
                    u.setPassword(password);
                    u.setTelefone(telemovel);
                    u.setNome(nome);
                    u.setApelido(apelido);
                    u.setNIF(nif);
                    u.setMorada(morada);
                    user = u;
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
            }
        });

        return v;
    }

    public boolean Validar(){

        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String password2 = et_password2.getText().toString();
        String telemovel = et_telemovel.getText().toString();
        String nome = et_nome.getText().toString();
        String apelido = et_apelido.getText().toString();
        String nif = et_nif.getText().toString();
        String morada = et_morada.getText().toString();



        if(TextUtils.isEmpty(email)){
            et_email.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira um email",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_email.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(password)){
            et_password.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira uma Palavra-Passe",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_password.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(password2)){
            et_password2.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira uma Palavra-Passe Correspondente",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_password2.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(telemovel)){
            et_telemovel.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira um número de Telefone",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_telemovel.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(nome)){
            et_nome.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira o seu nome",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_nome.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(apelido)){
            et_apelido.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira o seu apelido",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_apelido.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(nif)){
            et_nif.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira o seu (NIF) Número de Identificação Fiscal",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_apelido.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.isEmpty(morada)){
            et_morada.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"Insira uma morada",Toast.LENGTH_LONG).show();
            return false;
        } else {
            et_morada.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        }

        if(TextUtils.equals(password,password2)) {
            et_password2.setBackgroundColor(this.getResources().getColor(R.color.fundo_et));
        } else {
            et_password2.setBackgroundColor(this.getResources().getColor(R.color.error));
            Toast.makeText(getActivity(),"A palavra passe não corresponde",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
}
