package cl.puntogestion.dogapi.model.api;


import cl.puntogestion.dogapi.model.RazasLista;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IDogDataBase {
    @GET("api/breeds/list/all")
    Call<RazasLista> listaRazas();
}
