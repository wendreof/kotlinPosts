package repository

import entity.HttpResponse
import entity.FullParameters

class PostRepository private constructor()
{

    companion object: BaseRepository()
    {
        fun getAllPosts(fullParameters: FullParameters) : HttpResponse
        {
            return super.execute( fullParameters )
        }

        fun getSinglePost( fullParameters: FullParameters ) : HttpResponse
        {
            return super.execute( fullParameters )
        }
    }

}