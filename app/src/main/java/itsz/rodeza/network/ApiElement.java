package itsz.rodeza.network;

import java.util.List;

import itsz.rodeza.model.ListElement;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiElement {
    @GET("rodeza2/list.php")
    Call<List<ListElement>> getElements();
}
