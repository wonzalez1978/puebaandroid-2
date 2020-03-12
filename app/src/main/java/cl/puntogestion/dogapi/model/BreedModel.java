package cl.puntogestion.dogapi.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.puntogestion.dogapi.model.api.IDogDataBase;
import cl.puntogestion.dogapi.model.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BreedModel implements IModel {

private static final String TAG = "breedModel";
    @Override
    public void loadBreeds() {
        IDogDataBase servicio = RetrofitClient.getRetrofitInstance().create(IDogDataBase.class);

        Call<RazasLista> listCall = servicio.listaRazas();
        List<String> listaPerros = new ArrayList<>();

        listCall.enqueue(new Callback<RazasLista>() {
            @Override
            public void onResponse(Call<RazasLista> call, Response<RazasLista> response) {
                RazasLista listaRazas = response.body();
                Map<String, List<String>> mapa = listaRazas.getMessage();

                for (String key : mapa.keySet()) {
                    if (mapa.get(key).isEmpty()) {
                        listaPerros.add(key);
                    } else {
                        for (String subRaza : mapa.get(key)) {
                            listaPerros.add(key + " " + subRaza);
                        }
                    }

                }
                //Log.i("Valor", ""+listaPerros);
         //TODO       IPresenterViewList.notificar(listaPerros);
            }

            @Override
            public void onFailure(Call<RazasLista> call, Throwable t) {

            }
        });


    }

    @Override
    public void loadImages(String raza, String subRaza) {
        Log.d(TAG, "loadImages metodo no implementado");
    }
}
