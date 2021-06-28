package andrecastro.burguerall.app.burgerall;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contatos extends Fragment implements View.OnClickListener {


    public Contatos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contatos, container, false);

        Button voltar = (Button) v.findViewById(R.id.button8);
        voltar.setOnClickListener(this);
        Button email = (Button) v.findViewById(R.id.button2);
        email.setOnClickListener(this);

        return v;
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


            case R.id.button2:

                sendMail();
                break;

                case R.id.button3:


                    break;
            default:
                break;

        }


    }

    private void sendMail() {
        // Define o destinatário (meu email)
        String listaDestinos = "burgerall@gmail.com";
        String[] destinatarios = listaDestinos.split(",");

        // Getter do texto das caixas de texto
        String assunto = "";
        String mensagem = "";

        // Envia os dados para outro processo
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, destinatarios);
        intent.putExtra(Intent.EXTRA_SUBJECT, assunto);
        intent.putExtra(Intent.EXTRA_TEXT, mensagem);

        // Pergunta para escolher o serviço e depois envia os dados do Intent
        // para a aplicação preenchendo assim o formulario do email.
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Escolhe um cliente de Email"));
    }
}
