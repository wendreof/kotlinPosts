package infra

/**
 * Classe não pode ser instanciada
 * Define variáveis estáticas que não podem ser alteradas, somente acessadas
 * */
class EndpointConstants private constructor() {

    object BASE {
        val URL: String = "https://jsonplaceholder.typicode.com/"
    }

    object POST {
        val ALL_POSTS: String = "posts"
        val SINGLE_POST: String = "posts"
    }

}