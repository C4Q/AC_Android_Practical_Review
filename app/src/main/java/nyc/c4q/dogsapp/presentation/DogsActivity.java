package nyc.c4q.dogsapp.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.List;

import nyc.c4q.dogsapp.R;
import nyc.c4q.dogsapp.data.DogApiResponse;
import nyc.c4q.dogsapp.data.DogApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);

        // setup recycler view
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        // get some dogs
        String breed = "poodle";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DogApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DogApiService dogApiService = retrofit.create(DogApiService.class);

        Call<DogApiResponse> call = dogApiService.getDogImages(breed);

        call.enqueue(new Callback<DogApiResponse>() {
            @Override
            public void onResponse(Call<DogApiResponse> call, Response<DogApiResponse> response) {
                List<String> dogImageUrls = response.body().getMessage();
                DogsRvAdapter adapter = new DogsRvAdapter(dogImageUrls);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DogApiResponse> call, Throwable t) {
                Toast.makeText(DogsActivity.this, R.string.network_err_msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
