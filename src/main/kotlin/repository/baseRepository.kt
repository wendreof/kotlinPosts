package repository

import entity.FullParameters
import entity.HttpResponse
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.lang.*

abstract class BaseRepository()
{
    fun execute( fullParameters: FullParameters ): HttpResponse
    {
        val conn: HttpURLConnection
        val response: HttpResponse

        val url: URL = URL( fullParameters.url + getQuery(fullParameters.parameters) )

        conn = url.openConnection() as HttpURLConnection
        conn.readTimeout =  100000
        conn.connectTimeout = 120000
        conn.requestMethod = fullParameters.method.toString()

        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded" )
        conn.setRequestProperty( "charset", "utf-8" )

        conn.useCaches = false

        conn.connect()

        if ( conn.responseCode == 404 )
        {
            response = HttpResponse( conn.responseCode, "")
        }
        else
        {
            val inputStrem: InputStream = conn.inputStream
            response = HttpResponse( conn.responseCode, getStringFromInputString(inputStrem) )
        }

        return response

    }

    fun getStringFromInputString(inputStrem: InputStream): String
    {
        try
        {
            val strBuilder: StringBuilder = StringBuilder()
            var br: BufferedReader = BufferedReader( InputStreamReader(inputStrem) )

            for ( line in br.readLines())
            {
                strBuilder.append( line )
            }

            return strBuilder.toString()
        }
        catch (e: Exception)
        {
            return ""
        }
    }

    fun getQuery( parameters: Map<String, String> ): String
    {
        if ( parameters.isEmpty())

            return ""

            val result: StringBuilder = StringBuilder()
            var first: Boolean = true

            for ( param in parameters )
            {
                if ( first )
                {
                    result.append( "?" )
                    first = false
                }
                else
                {
                    result.append( "&" )
                }

                result.append( URLEncoder.encode( param.key), "UTF-8" )
                result.append( "=" )
                result.append( URLEncoder.encode( param.value), "UTF-8" )
            }

            return result.toString()

    }
}
