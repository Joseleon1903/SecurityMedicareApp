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

## Get Nacionalidad

### Request

`GET /api/nacinalidad/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/nacinalidad/0

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "nacionalidadId": 0,
    "descripcion": "SIN CODIFICAR",
    "paisId": "ZZZ",
    "estado": "AC"
    }

## Get all Nacionalidades

### Request

`GET /api/nacinalidad/all`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/nacinalidad/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
    "nacionalidadId": 0,
    "descripcion": "SIN CODIFICAR",
    "paisId": "ZZZ",
    "estado": "AC"
    },
    {
    "nacionalidadId": 1,
    "descripcion": "DOMINICANA",
    "paisId": "DOM",
    "estado": "AC"
    },
    {
    "nacionalidadId": 2,
    "descripcion": "ESTADOUNIDENSE",
    "paisId": "USA",
    "estado": "AC"
    },
    {
    "nacionalidadId": 3,
    "descripcion": "CANADIENSE",
    "paisId": "CAN",
    "estado": "AC"
    }
    ]

## Get paginated Nacionalidades filter by param

### Request

`GET /api/nacinalidad/find`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/nacinalidad/find?paisId=1&page=0&size=3

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "nacionalidades":    [
    {
    "nacionalidadId": 0,
    "descripcion": "SIN CODIFICAR",
    "paisId": "ZZZ",
    "estado": "AC"
    },
    {
    "nacionalidadId": 1,
    "descripcion": "DOMINICANA",
    "paisId": "DOM",
    "estado": "AC"
    },
    {
    "nacionalidadId": 2,
    "descripcion": "ESTADOUNIDENSE",
    "paisId": "USA",
    "estado": "AC"
    }
    ],
    "page":    {
    "pageIndex": 0,
    "rowSize": 3,
    "totalRowCount": 223,
    "totalPages": 75
    }
    }

## Get Motivo Estado

### Request

`GET /api/motivoestado/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/motivoestado/1607

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "motivoId": 1607,
    "descripcion": "ERROR INTERNO DEL SERVICIO, DE PERSISTIR FAVOR CONTACTAR AL ADMINISTRADOR DEL SISTEMA",
    "estado": "AC"
    }

## Get All Motivo Estado

### Request

`GET /api/motivoestado/all`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/motivoestado/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
      "motivoId": 5,
      "descripcion": "EL PRIMER APELLIDO DEL CIUDADANO ES DIFERENTE AL DEL MAESTRO DE CIUDADANOS",
      "estado": "AC"
    },
    {
    "motivoId": 16,
    "descripcion": "CEDULA INVALIDA",
    "estado": "AC"
    },
    {
    "motivoId": 23,
    "descripcion": "REGISTRO YA EXISTE",
    "estado": "AC"
    },
    {
    "motivoId": 24,
    "descripcion": "EL AGENTE PROMOTOR O REPRESENTANTE NO EXISTE",
    "estado": "AC"
    },
    {
    "motivoId": 34,
    "descripcion": "PROCESO ESPECIFICADO NO CATALOGADO O ACTIVO",
    "estado": "AC"
    }
    ]

## Get paginated Motivo Estado filter by param

### Request

`GET /api/motivoestao/find`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/motivoestado/find?motivoId=23&descripcion=REGISTRO YA EXISTE&page=0&size=5

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "motivos":    [
    {
    "motivoId": 5,
    "descripcion": "EL PRIMER APELLIDO DEL CIUDADANO ES DIFERENTE AL DEL MAESTRO DE CIUDADANOS",
    "estado": "AC"
    },
    {
    "motivoId": 16,
    "descripcion": "CEDULA INVALIDA",
    "estado": "AC"
    },
    {
    "motivoId": 23,
    "descripcion": "REGISTRO YA EXISTE",
    "estado": "AC"
    },
    {
    "motivoId": 24,
    "descripcion": "EL AGENTE PROMOTOR O REPRESENTANTE NO EXISTE",
    "estado": "AC"
    },
    {
    "motivoId": 34,
    "descripcion": "PROCESO ESPECIFICADO NO CATALOGADO O ACTIVO",
    "estado": "AC"
    }
    ],
    "page":    {
    "pageIndex": 0,
    "rowSize": 5,
    "totalRowCount": 806,
    "totalPages": 162
    }
    }

## Get Municipio

### Request

`GET /api/municipio/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/municipio/1

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "municipioId": 1,
    "descripcion": "DISTRITO NACIONAL",
    "codigoMunicipio": "001",
    "provinciaId": 1,
    "estado": "AC"
    }

## Get All Municipio

### Request

`GET /api/municipio/all`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/municipio/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
      "municipioId": 1,
      "descripcion": "DISTRITO NACIONAL",
      "codigoMunicipio": "001",
      "provinciaId": 1,
      "estado": "AC"
    },
    {
    "municipioId": 2,
    "descripcion": "HIGUEY",
    "codigoMunicipio": "028",
    "provinciaId": 2,
    "estado": "AC"
    },
    {
    "municipioId": 3,
    "descripcion": "SAN RAFAEL DEL YUMA",
    "codigoMunicipio": "085",
    "provinciaId": 2,
    "estado": "AC"
    },
    {
    "municipioId": 4,
    "descripcion": "LA LAGUNA DE NISIBON (DM)",
    "codigoMunicipio": "141",
    "provinciaId": 2,
    "estado": "AC"
    }
    ]

## Get paginated Municipio filter by param

### Request

`GET /api/municipio/find`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/municipio/find?codigoMunicipio=141&descripcion=LA LAGUNA DE NISIBON (DM)&page=0&size=5

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "municipios": [   
    {
    "municipioId": 4,
    "descripcion": "LA LAGUNA DE NISIBON (DM)",
    "codigoMunicipio": "141",
    "provinciaId": 2,
    "estado": "AC"
    }
    ],
    "page":    {
    "pageIndex": 0,
    "rowSize": 5,
    "totalRowCount": 1,
    "totalPages": 1
    }
    }
