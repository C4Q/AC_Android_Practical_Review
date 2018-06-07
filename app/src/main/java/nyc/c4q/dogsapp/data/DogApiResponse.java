package nyc.c4q.dogsapp.data;

import java.util.List;

public class DogApiResponse {
    private String status;
    private List<String> message;

    public DogApiResponse(String status, List<String> message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public DogApiResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<String> getMessage() {
        return message;
    }

    public DogApiResponse setMessage(List<String> message) {
        this.message = message;
        return this;
    }
}
