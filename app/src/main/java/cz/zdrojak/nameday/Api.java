package cz.zdrojak.nameday;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;

/**
 * API layer for API http://svatky.adresa.info/
 *
 * @author David 'Destil' Vavra (david@vavra.me)
 */
public class Api {
    public interface NameDays {
        @GET("/json")
        void today(Callback<List<NameDay>> callback);
    }

    public class NameDay {
        public String date;
        public String name;
    }

    public static NameDays getNameDays() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("http://svatky.adresa.info").build();
        return restAdapter.create(NameDays.class);
    }
}


