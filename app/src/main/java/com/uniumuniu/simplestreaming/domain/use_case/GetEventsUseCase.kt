package com.uniumuniu.simplestreaming.domain.use_case

import com.uniumuniu.simplestreaming.common.Resource
import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.domain.repository.IEventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val repository: IEventsRepository
) {
    operator fun invoke(): Flow<Resource<List<Event>>> = flow {
        try {
            val events = repository.getEvents().sortedBy { it.date }
            emit(Resource.Success<List<Event>>(events))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Event>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Event>>("Couldn't reach the server. Please check your internet connection."))
        }
    }.flowOn(Dispatchers.IO)
}