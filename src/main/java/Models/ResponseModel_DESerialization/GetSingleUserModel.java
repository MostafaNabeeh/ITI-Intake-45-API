package Models.ResponseModel_DESerialization;
import com.fasterxml.jackson.annotation.JsonProperty;

/* Pojo Class for DE_Serialization
Json to javaObject*/

public  class GetSingleUserModel
{
    @JsonProperty("data")
    public Data data;
    @JsonProperty("support")
    public Support support;

    public static class Data{
        @JsonProperty("id")
        public Integer id;
        @JsonProperty("email")
        public String email;
        @JsonProperty("first_name")
        public String firstName;
        @JsonProperty("last_name")
        public String lastName;
        @JsonProperty("avatar")
        public String avatar;
    }

    public static class Support{
        @JsonProperty("url")
        public String url;
        @JsonProperty("text")
        public String text;
    }

}
