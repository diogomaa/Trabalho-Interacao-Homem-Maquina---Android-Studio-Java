package andrecastro.burguerall.app.burgerall;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HamburguerListAdapter extends BaseAdapter{

    //the list values in the List of type hero
    Context context;

    List<Hamburguer> burguerList;

    View v;

    public int pos;



    public HamburguerListAdapter(Context context, List<Hamburguer> burguerList) {
        this.context = context;
        this.burguerList = burguerList;
    }

    @Override
    public int getCount() {
        return burguerList.size();
    }

    @Override
    public Object getItem(int position) {
        return burguerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(R.layout.custom_listview, null, false);
        v = view;

        //getting the view elements of the list from the view
        ImageView imageView = view.findViewById(R.id.HambImage);
        TextView textViewNome = view.findViewById(R.id.HambName);
        TextView textViewDesc = view.findViewById(R.id.HambDesc);
        Button buttonHamb = view.findViewById(R.id.HambSing);
        Button buttonMenu = view.findViewById(R.id.HambMenu);

        //getting the hero of the specified position
        Hamburguer hamburguer = burguerList.get(position);

        //adding values to the list item
        imageView.setImageDrawable(context.getResources().getDrawable(hamburguer.getImagem()));
        textViewNome.setText(hamburguer.getNome());
        textViewDesc.setText(hamburguer.getDesc());

        buttonHamb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                add_sing(position, v);

            }
        });

        buttonMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               add_menu(position, v);
            }
        });

        //finally returning the view
        return view;
    }

    private void add_sing(final int position, View v) {

        Hamburguer p = burguerList.get(position);

        int imagem;
        String nome;
        double preco;

        imagem = p.getImagem();
        nome = p.getNome();
        preco = p.getPhamb();

        itemsingular item = new itemsingular(imagem,nome,preco);

        MainActivity.listaCar.add(item);
        Carrinho.total += preco;

        notifyDataSetChanged();

        Toast.makeText(v.getContext(),p.getNome(),Toast.LENGTH_LONG).show();
    }

    private void add_menu(final int position, View v) {

        Hamburguer p = burguerList.get(position);

        int imagem;
        String nome;
        double preco;

        imagem = p.getImagem();
        nome = "Menu " + p.getNome();
        preco = p.getPmenu();

        itemsingular item = new itemsingular(imagem,nome,preco);

        MainActivity.listaCar.add(item);
        Carrinho.total += preco;

        notifyDataSetChanged();

        Toast.makeText(v.getContext(),p.getNome(),Toast.LENGTH_LONG).show();
    }

}
