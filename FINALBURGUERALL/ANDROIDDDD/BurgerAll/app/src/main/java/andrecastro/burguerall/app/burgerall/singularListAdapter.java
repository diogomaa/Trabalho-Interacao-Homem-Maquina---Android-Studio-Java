package andrecastro.burguerall.app.burgerall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class singularListAdapter extends BaseAdapter {

    Context context;

    List<itemsingular> lista;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.custom_singulares, null, false);

        ImageView imageView = v.findViewById(R.id.imageView4);
        TextView textViewNome = v.findViewById(R.id.textView5);
        TextView textViewPreco = v.findViewById(R.id.textView6);

        itemsingular singular = lista.get(position);

        imageView.setImageDrawable(context.getResources().getDrawable(singular.getImagem()));
        textViewNome.setText(singular.getNome());
        textViewPreco.setText(singular.getPreco() + "€");

        return v;
    }
}
