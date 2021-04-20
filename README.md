# Spring Boot Kafka Streams demo application
# Getting Started
Clone o repositório:
<pre><code> https://github.com/eltonmmoreira/spring-boot-streams-kafka-demo.git</code></pre>

# Description:
APIs e serviços construídos para demo, utilizando spring boot, spring boot streams e kafka.
Os serviços se comunicam entre si através de tópicos kafka, enviado e recebendo mensagens conforme eventos 
e ações realizadas.
No order-api através de chamada rest é incluido um cliente e então uma ordem para esse cliente, 
ao criar a ordem um evento é disparado e o payment-api recebe essa ordem e valida o pagamento.
Após processar o pagamento um evento é disparado, então o mail-api recebe os dados e 
envia um e-mail para o cliente da ordem(processamento do pagamento e envio de e-mail é realizado de 
maneira simbólica, somente para dar sequencia ao fluxo)

Tecnologias:
- Spring Boot,
- JAVA, 
- REST, 
- Kafka, 
- Spring Boot Streams, 
- Docker

# Building and running the application
## Pre-requisites
<pre><code>JAVA 15
Maven
Docker,
Docker Compose</code></pre>

## Package the Spring Boot jar and create the docker image
Para compilar e empacotar o arquivo jar e criar uma imagem docker local, execute os comandos abaixo:
<pre><code>mvn package
mvn jib:dockerBuild</code></pre>

Para criar a imagem docker foi utilizado o jib-maven-plugin, dessa forma não é necessário o uso de Dockerfile nem ter o docker instalado.
Maiores detalhes: https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin

Executando container kafka
Para iniciar o kafka e demais ferramentas é necessário ter instalado Docker e Docker Compose.

Execute o seguinte comando na raiz do projeto:
<pre><code>docker-compose up -d</code></pre>

# Documentation
<pre><code>http://localhost:8080/api-docs
http://localhost:8080/swagger-ui.html
http://localhost:8080/api-docs
http://localhost:8080/swagger-ui.html

Para listar os tópicos e ver as mensagens enviadas ao kafka, foi incluido no docker compose o Kafdrop, 
disponível por padrão na porta 19000, para verificar as informações acesse:
http://localhost:19000/</code></pre>

