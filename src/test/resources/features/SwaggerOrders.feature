@CrearOrdem
  Feature: GET Y POST Ordenes

    Scenario Outline: Crear Orden
      Given la url es "https://petstore.swagger.io/v2"
      When cuando creo la orden "<idOrden>" de la mascota "<idMascota>"
      Then valido que la respuesta sea 200
      Examples:
        | idOrden | idMascota |
        | 4       | 3         |

    Scenario Outline: Crear Orden
      Given la url es "https://petstore.swagger.io/v2"
      When cuando consulta la orden "<idOrden>"
      Then valido que la respuesta sea 200
      Examples:
        | idOrden |  |
        | 4       |  |
