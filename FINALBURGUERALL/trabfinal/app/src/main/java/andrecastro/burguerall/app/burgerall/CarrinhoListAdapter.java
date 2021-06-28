package andrecastro.burguerall.app.burgerall;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarrinhoListAdapter extends BaseAdapter {

    Context context;

    List<itemsingular> lista;

    public CarrinhoListAdapter(Context context, List<itemsingular> lista) {
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
        View v = layoutInflater.inflate(R.layout.custom_carrinho, null, false);

        ImageView imageView = v.findViewById(R.id.imageView4);
        TextView textViewNome = v.findViewById(R.id.textView5);
        TextView textViewPreco = v.findViewById(R.id.textView6);

        itemsingular singular = lista.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(singular.getImagem()));
        textViewNome.setText(singular.getNome());
        textViewPreco.setText(singular.getPreco() + "€");

        Button buttonDelete = v.findViewById(R.id.button4);



        //adding a click listener to the button to remove item from the list
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
                remove(position, view);
            }
        });

        return v;
    }

    private void remove(final int position, final View v) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Tens a certeza que queres remover?");

        //if the response is positive in the alert
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                lista.remove(position);
                //reloading the list
                notifyDataSetChanged();
            }
        });

        //if response is negative nothing is being done
        builder.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //creating and displaying the alert dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
