package es.santos.manu.gridviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    int imagenes[]={
            R.drawable.bombillabg,R.drawable.cambg,R.drawable.cocinabg,
            R.drawable.estufabg,R.drawable.garagebg,R.drawable.grifobg,
            R.drawable.lavadorabg,R.drawable.persianabg
    };

    String textos[] = {
            "iluminación","cámaras","cocina",
            "estufa","garage","grifo",
            "lavadora","persiana"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos el objeto gridview de la ventana principal
        gridView = (GridView) findViewById(R.id.gridView);
        // Creamos nuestro adaptanor que nos devolverá la vista dinámica
        GridAdapter gridAdapter = new GridAdapter(imagenes,textos,MainActivity.this);
        gridView.setAdapter(gridAdapter);
        // Añadimos acciones a los elementos de nuestra vista un toast en este caso
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Clickeado:"+textos[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
