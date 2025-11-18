import java.util.Map;

public class Request {
    private String userId;
    private String userType;
    private String requestId;
    private String requestType;
    private Map<String, String> body;

    public Request(String userId, String userType, String requestId, String requestType, Map<String, String> body) {
        this.userId = userId;
        this.userType = userType;
        this.requestId = requestId;
        this.requestType = requestType;
        this.body = body;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public Map<String, String> getBody() {
        return body;
    }

}
