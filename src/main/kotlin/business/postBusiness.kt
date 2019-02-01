package business

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import entity.FullParameters
import entity.HttpResponse
import entity.PostEntity
import infra.EndpointConstants
import infra.OperationMethod
import repository.PostRepository

/**
 * Camada de negócio para carregar postagens
 * Tratamento de lógica de negócio deve ficar centralizada nessa camada
 * */
class PostBusiness {

    /**
     * Carrega lista de postagens
     * */
    fun getAllPosts(): List<PostEntity> {

        // Configura EndPoint - URL a ser chamada
        val url: String = EndpointConstants.BASE.URL + EndpointConstants.POST.ALL_POSTS

        // Monta a classe com as configurações necessárias
        val fullParameters: FullParameters = FullParameters(url, OperationMethod.GET)

        // Obtém a resposta
        val response: HttpResponse = PostRepository.getAllPosts(fullParameters)

        // Faz a conversão e o retorno
        return Gson().fromJson<List<PostEntity>>(response.jsonResponse, object : TypeToken<List<PostEntity>>() {}.type)

    }

    /**
     * Carrega postagem específica de acordo com o Id
     * */
    fun getSinglePost(id: Int): PostEntity {

        // Configura EndPoint - URL a ser chamada
        val url: String = EndpointConstants.BASE.URL + EndpointConstants.POST.SINGLE_POST

        // Monta a classe com as configurações necessárias - Dessa vez com parâmetros
        val fullParameters: FullParameters = FullParameters(url, OperationMethod.GET, mapOf(Pair("id", id.toString())))

        // Obtém a resposta
        val response: HttpResponse = PostRepository.getSinglePost(fullParameters)

        // Faz a conversão e o retorno
        return Gson().fromJson<List<PostEntity>>(response.jsonResponse, object : TypeToken<List<PostEntity>>() {}.type)[0]

    }

}