package com.example.usuario.ejemplointentcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int VENGO_DE_LA_CAMARA = 1;
Button captura;
ImageView imageViewFoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        captura = findViewById(R.id.buttonCaptura);
        imageViewFoto = findViewById(R.id.imageViewFoto);

        captura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent haceFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (haceFoto.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(haceFoto,VENGO_DE_LA_CAMARA);
                }else{
                    Toast.makeText(MainActivity.this, "Necesito un programa de hacer fotos.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if ((requestCode == VENGO_DE_LA_CAMARA) && (resultCode == RESULT_OK)){

            Bundle extras = data.getExtras();

            Bitmap foto = (Bitmap) extras.get("data");

            imageViewFoto.setImageBitmap(foto);


        }
    }
}
