import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ReadGoogleURL {
    public static void main(String[] args) {
        try {
            // Create HttpClient with timeout settings
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();
            
            // Create HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.google.com"))
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();
            
            // Send request and get response
            System.out.println("正在讀取 https://www.google.com ...");
            System.out.println("Reading https://www.google.com ...");
            
            HttpResponse<String> response = client.send(request, 
                    HttpResponse.BodyHandlers.ofString());
            
            // Display response information
            System.out.println("\n=== 回應資訊 / Response Information ===");
            System.out.println("狀態碼 / Status Code: " + response.statusCode());
            System.out.println("HTTP 版本 / HTTP Version: " + response.version());
            
            System.out.println("\n=== 回應標頭 / Response Headers ===");
            response.headers().map().forEach((key, values) -> {
                System.out.println(key + ": " + String.join(", ", values));
            });
            
            System.out.println("\n=== 回應內容 / Response Body ===");
            String body = response.body();
            
            // Display first 500 characters of the response
            if (body.length() > 500) {
                System.out.println(body.substring(0, 500) + "...");
                System.out.println("\n[內容已截斷，總長度: " + body.length() + " 字元]");
                System.out.println("[Content truncated, total length: " + body.length() + " characters]");
            } else {
                System.out.println(body);
            }
            
            System.out.println("\n讀取成功！");
            System.out.println("Read successfully!");
            
        } catch (java.net.http.HttpTimeoutException e) {
            System.err.println("錯誤: 請求逾時");
            System.err.println("Error: Request timeout");
            e.printStackTrace();
        } catch (java.io.IOException e) {
            System.err.println("錯誤: IO 例外");
            System.err.println("Error: IO Exception");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("錯誤: 請求被中斷");
            System.err.println("Error: Request interrupted");
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("錯誤: " + e.getMessage());
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
