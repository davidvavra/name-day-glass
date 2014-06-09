package cz.zdrojak.nameday;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.glass.app.Card;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Activity which shows who celebrates name day today on a simple card.
 *
 * @author David 'Destil' Vavra (david@vavra.me)
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Api.getNameDays().today(new Callback<List<Api.NameDay>>() {
            @Override
            public void success(List<Api.NameDay> nameDays, Response response) {
                show(nameDays.get(0).name);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                show(retrofitError.getMessage());
            }
        });
    }

    private void show(String text) {
        Card card = new Card(this);
        card.setText(text);
        card.setFootnote("celebrates name day today");
        setContentView(card.getView());
    }
}
