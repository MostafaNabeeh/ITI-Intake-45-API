package Models.ResponseModel_DESerialization;
import com.fasterxml.jackson.annotation.JsonProperty;
/* Pojo Class for DE_Serialization Json to javaObject*/

public class CreateUserSuccessfullyModel {

    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;
    @JsonProperty("id")
    public String id;
    @JsonProperty("createdAt")
    public String createdAt;
}
