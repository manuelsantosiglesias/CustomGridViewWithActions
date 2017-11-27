package es.santos.manu.gridviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Usuario on 27/11/2017.
 */

public class GridAdapter extends BaseAdapter {
    private int images[];
    private String textos[];
    private Context contexto;
    private LayoutInflater inflater;


    public GridAdapter(int[] images, String[] textos, Context contexto) {
        this.images = images;
        this.textos = textos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return textos.length;
    }

    @Override
    public Object getItem(int i) {
        return textos[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridview = view;

        // Si no existe vista la creamos
        if(view==null){
            inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Cargamos nuestro custom layout
            gridview = inflater.inflate(R.layout.layout_dinamico,null);
        }

        // Le añadimos las imagenes y textos
        ImageView imagen =  gridview.findViewById(R.id.imageView);
        TextView texto =  gridview.findViewById(R.id.textView);

        imagen.setImageResource(images[i]);
        texto.setText(textos[i]);

        return gridview;
    }
}
