package utilities;
import java.util.HashMap;
import java.util.Map;

public class Headers
{
    /* for any method require token UserUtils*/
    public static Map<String,String> generalHeaders(String token)
    {
        Map<String,String> headers = new HashMap<>();
        headers.put("x-api-key",Constants.X_api_key);
        headers.put("Content-Type","application/json");
        headers.put("token",token);
        return headers;
    }

    /* Headers for login method with no token LoginUtils*/
    public static Map<String,String> generalHeaders()
    {
        Map<String,String> headers = new HashMap<>();
        headers.put("x-api-key",Constants.X_api_key);
        headers.put("Content-Type","application/json");
        return headers;
    }

}
