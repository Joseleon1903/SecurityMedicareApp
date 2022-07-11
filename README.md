# SecurityMedicareApp
Spring Boot Application with thymeleaf.


### run Maven command
- mvn clean install spring-boot:run -Dspring-boot.run.profiles=dev

- java -jar -Dspring.profiles.active=dev SecurityMedicareApp-0.0.1-SNAPSHOT.jar

# SecurityMedicareApp REST API

The REST API to the example app is described below.

## Get list of Ciudadanos

### Request

`GET /api/ciudadano/all`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
      {
      "ciudadanoId": 1156,
      "cedula": "02100032850",
      "nss": 50307232,
      "nombre": "FREIDMANT",
      "primerApellido": "DOINET",
      "segundoApellido": "GODEK",
      "municipioId": 375,
      "nacionalidadId": 1,
      "estranjero": null,
      "genero": "M",
      "fechaNacimiento": "+0000-01-05T04:00:00.000+00:00",
      "estado": "AC"
    },
    {
    "ciudadanoId": 21013,
    "cedula": "40548573330",
    "nss": 165301437,
    "nombre": "RAFAEL AMERICO",
    "primerApellido": "PERTOIS",
    "segundoApellido": "FILI",
    "municipioId": 279,
    "nacionalidadId": 1,
    "estranjero": null,
    "genero": "M",
    "fechaNacimiento": "+0000-03-05T04:00:00.000+00:00",
    "estado": "AC"
    }]

## Get Ciudadano

### Request

`GET /api/ciudadano/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/1156

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "ciudadanoId": 1156,
    "cedula": "02100032850",
    "nss": 50307232,
    "nombre": "FREIDMANT",
    "primerApellido": "DOINET",
    "segundoApellido": "GODEK",
    "municipioId": 375,
    "nacionalidadId": 1,
    "estranjero": null,
    "genero": "M",
    "fechaNacimiento": "+0000-01-05T04:00:00.000+00:00",
    "estado": "AC"
    }

