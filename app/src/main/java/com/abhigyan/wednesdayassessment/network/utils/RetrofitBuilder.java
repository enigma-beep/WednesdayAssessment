package com.abhigyan.wednesdayassessment.network.utils;

//import com.abhigyan.wednesdayassessment.BuildConfig;

//import com.abhigyan.wednesdayassessment.
import com.abhigyan.wednesdayassessment.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.abhigyan.wednesdayassessment.network.utils.APIContant.BASE_URL;




public class RetrofitBuilder {

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogInterceptorClient())
                .build();
    }

    public static OkHttpClient getLogInterceptorClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {    //Enable API logs in debug mode
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            clientBuilder.addInterceptor(interceptor);
        }

        return clientBuilder.build();
    }
}
