package cl.puntogestion.dogapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import cl.puntogestion.dogapi.api.IDogDataBase;
import cl.puntogestion.dogapi.api.RetrofitClient;
import cl.puntogestion.dogapi.dummy.DummyContent;
import cl.puntogestion.dogapi.model.RazasLista;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements DogFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
