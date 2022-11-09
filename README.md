# SecurityMedicareApp
The Thymeleaf is an open-source Java library that is licensed under the Apache License 2.0. It is a HTML5/XHTML/XML template engine. 
It is a server-side Java template engine for both web (servlet-based) and non-web (offline) environments. It is perfect for modern-day HTML5 JVM web development. 
It provides full integration with Spring Framework.


### run Maven command
- mvn clean install spring-boot:run -Dspring-boot.run.profiles=dev

- java -jar -Dspring.profiles.active=dev SecurityMedicareApp-0.0.1-SNAPSHOT.jar

# SecurityMedicareApp REST API

The REST API to the example app is described below.

## Get list of Ciudadanos

### Request

`GET /api/ciudadano`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
    {
        "ciudadanoId": 21,
        "cedula": "58963632",
        "nss": "45454545",
        "nombre": "johanna",
        "primerApellido": "carnal",
        "segundoApellido": "savandija",
        "municipioId": 17,
        "nacionalidadId": 8,
        "genero": "F",
        "fechaNacimiento": "1997-01-30",
        "estado": "AC"
    },
    {
        "ciudadanoId": 23,
        "cedula": "963289653",
        "nss": "632541",
        "nombre": "fred",
        "primerApellido": "carnal",
        "segundoApellido": "savandija",
        "municipioId": 2,
        "nacionalidadId": 14,
        "genero": "M",
        "fechaNacimiento": "2022-09-20",
        "estado": "AC"
    }
    ]

## Get Ciudadano

### Request

`GET /api/ciudadano/{id}`
    
    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/28305

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "ciudadanoId": 28305,
    "cedula": "40553366369",
    "nss": "158827236",
    "nombre": "ROSA DOMINGA",
    "primerApellido": "ROBART",
    "segundoApellido": "ROBART",
    "municipioId": 371,
    "nacionalidadId": 1,
    "genero": "M",
    "fechaNacimiento": "2022-07-17",
    "estado": "AC"
    }

## Get Find Ciudadano 

### Request

`GET /api/ciudadano/find`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/find
    RequestParam = "cedula", required = false
    RequestParam = "nss", required = false

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "ciudadanoId": 28305,
    "cedula": "40553366369",
    "nss": "158827236",
    "nombre": "ROSA DOMINGA",
    "primerApellido": "ROBART",
    "segundoApellido": "ROBART",
    "municipioId": 371,
    "nacionalidadId": 1,
    "genero": "M",
    "fechaNacimiento": "2022-07-17",
    "estado": "AC"
    }

## Get Find Ciudadano by parameters

### Request

`GET /api/ciudadano/find/parameters`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/find/parameters
    @RequestParam = "tipoIdentificacion", required = false
    @RequestParam = "texto", required = false
    @RequestParam = "estado",required = false

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "ciudadanoId": 28305,
    "cedula": "40553366369",
    "nss": "158827236",
    "nombre": "ROSA DOMINGA",
    "primerApellido": "ROBART",
    "segundoApellido": "ROBART",
    "municipioId": 371,
    "nacionalidadId": 1,
    "genero": "M",
    "fechaNacimiento": "2022-07-17",
    "estado": "AC"
    }

## Post Ciudadano

### Request

`POST /api/ciudadano`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano
### Request Body
    {
    "cedula": "40553366369",
    "nss": "158827236",
    "nombre": "ROSA DOMINGA",
    "primerApellido": "ROBART",
    "segundoApellido": "ROBART",
    "municipioId": 371,
    "nacionalidadId": 1,
    "genero": "M",
    "fechaNacimiento": "2022-07-17",
    "estado": "AC"
    }
### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "ciudadanoId": 28305,
    "cedula": "40553366369",
    "nss": "158827236",
    "nombre": "ROSA DOMINGA",
    "primerApellido": "ROBART",
    "segundoApellido": "ROBART",
    "municipioId": 371,
    "nacionalidadId": 1,
    "genero": "M",
    "fechaNacimiento": "2022-07-17",
    "estado": "AC"
    }

## Delete Ciudadano

### Request

`Delete /api/ciudadano/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/ciudadano/12563

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
       
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

## Get Seguro by Id

### Request

`GET /api/seguro/{id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/seguro/1

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
    "seguroId": 1,
    "descripcion": "SEGURO DE VEJEZ, DISCAPACIDAD Y SOBREVIVENCIA",
    "estado": "AC"
    }

## Get All Seguros

### Request

`GET /api/seguro/all`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/seguro/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
      {
      "seguroId": 1,
      "descripcion": "SEGURO DE VEJEZ, DISCAPACIDAD Y SOBREVIVENCIA",
      "estado": "AC"
    },
    {
    "seguroId": 2,
    "descripcion": "SEGURO FAMILIAR DE SALUD",
    "estado": "AC"
    },
    {
    "seguroId": 3,
    "descripcion": "SEGURO DE RIESGOS LABORALES",
    "estado": "AC"
    }
    ]

## Get All Entidad

### Request

`GET /api/entidad/all`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/entidad/all

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    [
      {
      "entidadId": 1001,
      "tipoEntidadId": 1,
      "claveEntidad": 1,
      "sigla": "SIPE",
      "descripcion": "SUPERINTENDENCIA DE PENSIONES (SIPEN)",
      "regimenId": null,
      "participaAfiliacionAutomatica": null,
      "rnc": null,
      "entidadSupervisoraId": null,
      "estado": "AC",
      "municipioId": null
    },
    {
    "entidadId": 1002,
    "tipoEntidadId": 1,
    "claveEntidad": 2,
    "sigla": "TSS",
    "descripcion": "TESORERIA DE LA SEGURIDAD SOCIAL (TSS)",
    "regimenId": null,
    "participaAfiliacionAutomatica": null,
    "rnc": null,
    "entidadSupervisoraId": null,
    "estado": "AC",
    "municipioId": null
    },
    {
    "entidadId": 1003,
    "tipoEntidadId": 1,
    "claveEntidad": 3,
    "sigla": "SISALRIL",
    "descripcion": "SUPERINTENDENCIA DE SALUD Y RIESGOS LABORALES (SISALRIL)",
    "regimenId": null,
    "participaAfiliacionAutomatica": null,
    "rnc": null,
    "entidadSupervisoraId": null,
    "estado": "AC",
    "municipioId": null
    },
    {
    "entidadId": 1004,
    "tipoEntidadId": 1,
    "claveEntidad": 4,
    "sigla": "DIDA",
    "descripcion": "DIRECCION GENERAL DE INFORMACIÃ“N Y DEFENSA DE LOS AFILIADOS (DIDA)",
    "regimenId": null,
    "participaAfiliacionAutomatica": null,
    "rnc": null,
    "entidadSupervisoraId": null,
    "estado": "AC",
    "municipioId": null
    },
    {
    "entidadId": 1005,
    "tipoEntidadId": 1,
    "claveEntidad": 5,
    "sigla": "CNSS",
    "descripcion": "CONSEJO NACIONAL DE SEGURIDAD SOCIAL (CNSS)",
    "regimenId": null,
    "participaAfiliacionAutomatica": null,
    "rnc": null,
    "entidadSupervisoraId": null,
    "estado": "AC",
    "municipioId": null
    }
    ]

## Get Entidad by Id

### Request

`GET /api/entidad/{Id}`

    curl -i -H 'Accept: application/json' http://localhost:8080/SecurityMedicareApp/api/entidad/1001

### Response

    HTTP/1.1 200 OK
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 200 OK
    Connection: close
    Content-Type: application/json
    {
      "entidadId": 1001,
      "tipoEntidadId": 1,
      "claveEntidad": 1,
      "sigla": "SIPE",
      "descripcion": "SUPERINTENDENCIA DE PENSIONES (SIPEN)",
      "regimenId": null,
      "participaAfiliacionAutomatica": null,
      "rnc": null,
      "entidadSupervisoraId": null,
      "estado": "AC",
      "municipioId": null
    }
