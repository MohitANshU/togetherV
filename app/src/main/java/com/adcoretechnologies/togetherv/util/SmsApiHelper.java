package com.adcoretechnologies.togetherv.util;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Irfan on 22/09/15.
 */
public class SmsApiHelper {

    public static ISmsApiService getAppServiceMethod() {
        String url = "http://www.smsalert.co.in/api/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ISmsApiService.class);
    }


    @Parcel
    public class BoSms {

        public boolean isError() {
            if (status.equals("error"))
                return true;
            else return false;
        }

        public String getStatus() {
            return status;
        }

        @SerializedName("status")
        public String status;

    }

    public interface ISmsApiService {

        @GET("push.json")
        Call<BoSms> pushSms(@Query("apikey") String apiKey, @Query("route") String route, @Query("sender") String sender, @Query("mobileno") String toMobileNumber, @Query("text") String body);
    }
}
