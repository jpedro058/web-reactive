# start server
sv:
	@./mvnw spring-boot:run

# start client
cli:
	@./mvnw exec:java -Dexec.mainClass="com.app.web_reactive.client.Client"