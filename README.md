**MySQL User Storage (Keycloak User Federation)**
* Hỗ trợ kết nối user storage của app Laravel/PHP 
* Sử dụng MySQL Database

Lệnh build file jar: `./gradlew bundleJar`

Sau khi file `jar` được build (trong thư mục`build/libs`),
hãy copy file jar vào thư mục `$KEYCLOAK_HOME/standalone/deployments` trên máy chủ Keycloak.
