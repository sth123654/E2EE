# ReadGoogleURL - Java Program to Read from Google

This program demonstrates how to read content from https://www.google.com using Java's modern HttpClient API.

## Requirements

- Java 11 or higher (HttpClient API was introduced in Java 11)

## Compilation

```bash
javac ReadGoogleURL.java
```

## Execution

```bash
java ReadGoogleURL
```

## Features

- Uses modern Java HttpClient API (available since Java 11)
- Configurable connection and request timeouts (10 seconds)
- Displays response information including:
  - HTTP status code
  - HTTP version
  - Response headers
  - Response body (truncated to 500 characters for readability)
- Comprehensive error handling for:
  - Timeout exceptions
  - IO exceptions
  - Interrupted exceptions
- Bilingual output messages (Chinese and English)

## Example Output

```
正在讀取 https://www.google.com ...
Reading https://www.google.com ...

=== 回應資訊 / Response Information ===
狀態碼 / Status Code: 200
HTTP 版本 / HTTP Version: HTTP_2

=== 回應標頭 / Response Headers ===
content-type: text/html; charset=UTF-8
...

=== 回應內容 / Response Body ===
<!doctype html>...
[Content truncated, total length: XXXX characters]

讀取成功！
Read successfully!
```

## Error Handling

The program includes specific error handling for:
- **Timeout errors**: When the connection or request exceeds the 10-second timeout
- **IO errors**: For network connectivity issues
- **Interruption errors**: When the request is interrupted

All errors are reported with bilingual messages and include stack traces for debugging.
