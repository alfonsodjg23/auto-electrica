package itsz.rodeza.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
    public static Retrofit getElemnt(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.37/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
