package cl.puntogestion.dogapi.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.puntogestion.dogapi.model.api.IDogDataBase;
import cl.puntogestion.dogapi.model.api.RetrofitClient;
import cl.puntogestion.dogapi.model.RazasLista;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements IPresenter{

    Notificador notificador;

    public Presenter(Notificador notificador) {
        this.notificador = notificador;
    }

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
                notificador.notificar(listaPerros);
            }

            @Override
            public void onFailure(Call<RazasLista> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBreedImages(String raza) {

    }

    @Override
    public void loadSubBreedImages(String raza, String subraza) {

    }

    public interface Notificador {
        void notificar(List<String> lista);
    }
}
