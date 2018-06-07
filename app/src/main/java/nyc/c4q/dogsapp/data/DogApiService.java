package nyc.c4q.dogsapp.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DogApiService {

    public static final String BASE_URL = "https://dog.ceo/api/";

    @GET("breed/{breed_name}/images")
    Call<DogApiResponse> getDogImages(@Path("breed_name") String breed);

    /*
    If it had a query parameter, it would be like this... breed/{breed_name}/images?count=10

    @GET("breed/{breed_name}/images")
    Call<DogApiResponse> getDogImages(@Path("breed_name") String breed, @Query("count") int count);
    */
}
