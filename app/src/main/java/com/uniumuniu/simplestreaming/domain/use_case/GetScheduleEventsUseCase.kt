package com.uniumuniu.simplestreaming.domain.use_case

import android.util.Log
import com.uniumuniu.simplestreaming.common.Resource
import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent
import com.uniumuniu.simplestreaming.domain.repository.IEventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetScheduleEventsUseCase @Inject constructor(
    private val repository: IEventsRepository
) {
    operator fun invoke(): Flow<Resource<List<ScheduleEvent>>> = flow {
        // TODO: uncomment
//        while (currentCoroutineContext().isActive) {
            try {
                val scheduleEvents = repository.getScheduleEvents()
                Log.d("GetScheduleEvents", scheduleEvents.count().toString())
                emit(Resource.Success<List<ScheduleEvent>>(scheduleEvents))
                delay(15000)
            } catch (e: HttpException) {
                emit(Resource.Error<List<ScheduleEvent>>(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error<List<ScheduleEvent>>("Couldn't reach the server. Please check your internet connection."))
            }
//        }
    }.flowOn(Dispatchers.IO)
}