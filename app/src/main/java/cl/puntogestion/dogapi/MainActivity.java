package cl.puntogestion.dogapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import cl.puntogestion.dogapi.api.IDogDataBase;
import cl.puntogestion.dogapi.api.RetrofitClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IDogDataBase servicio = RetrofitClient.getRetrofitInstance().create(IDogDataBase.class);

        Log.i("ObjetoApi", ""+servicio);
    }
}
