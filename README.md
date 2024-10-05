Для запуска нужно установить maven на ПК
далее выполнить команды 
```bash
mvn clean install
```
```bash
docker build -t canvas-docker:0.0.1 .
```
Путь взять из результата предыдущей команды в поле 
=> => naming to docker.io/library/spring-boot-docker:0.0.1
```bash
docker run -p 8080:8080 <примерный путь docker.io/library/canvas-docker:0.0.1>
```