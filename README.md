# Sobre o projeto
O projeto consiste em uma API Rest para o cadastro de veículos e simular o consumo de combustível em uma determinada distância.

# Tecnologias

- Java 8
- Spring Boot
- JPA / Hibernate
- Maven

# Servidores embutidos
- Tomcat server (porta 8080)
- Banco de dados H2

# Como executar
```bash
# clonar repositório
git clone https://github.com/ViegasPedro/vehicle-service.git

# entra na pasta do projeto
cd vehicle-service

# executa o projeto
./mvnw spring-boot:run
```
# Endpoints

## Adicionar veículo
- Método: POST
- URL: localhost:8080/vehicles/
- Body: 
```json
{
    "nome":"Carro 1",
    "dataFabricacao":"21/17/2021",
    "marca":"Ford",
    "modelo":"Focus",
    "consumoMedioCidade":10,
    "consumoMedioRodovia":13
}
```
## Consultar todos veículos
- Método: GET
- URL: localhost:8080/vehicles

## Atualizar veículo
- Método: PUT
- URL: localhost:8080/vehicles/{id}
- Body: 
```json
{
    "nome":"Carro 1",
    "dataFabricacao":"21/17/2021",
    "marca":"Ford",
    "modelo":"Focus",
    "consumoMedioCidade":10,
    "consumoMedioRodovia":13
}
```
## Deletar veículo
- Método: DELETE
- URL: localhost:8080/vehicles/{id}

## Consultar veículo
- Método: GET
- URL: localhost:8080/vehicles/{id}

## Simular custo e quantidade de combustível gasto
- Método: POST
- URL: localhost:8080/cost-simulation
- Body: 
```json
{
    "precoGasolina":2,
    "totalKmRodovia":10,
    "totalKmCidade":10
}
```

