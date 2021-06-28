package andrecastro.burguerall.app.burgerall;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class singularListAdapter extends BaseAdapter {

    Context context;

    List<itemsingular> lista;

    View view;

    public int pos;

    public singularListAdapter(Context context, List<itemsingular> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.custom_singulares, null, false);
        view = v;

        ImageView imageView = v.findViewById(R.id.imageView4);
        TextView textViewNome = v.findViewById(R.id.textView5);
        TextView textViewPreco = v.findViewById(R.id.textView6);

        itemsingular singular = lista.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(singular.getImagem()));
        textViewNome.setText(singular.getNome());
        textViewPreco.setText(singular.getPreco() + "€");

        Button btn_add = (Button) v.findViewById(R.id.button4);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                add_car(position,view);
            }
        });

        return v;
    }


    private void add_car(final int position, View v) {

        itemsingular p = lista.get(position);


        MainActivity.listaCar.add(p);
        Carrinho.total += p.getPreco();

        notifyDataSetChanged();

        Toast.makeText(v.getContext(),p.getNome(),Toast.LENGTH_LONG).show();
    }
}
