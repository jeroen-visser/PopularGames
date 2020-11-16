package eu.jeroenvisser.populargames.data.remote.igdb

import android.util.Log
import eu.jeroenvisser.populargames.data.entities.Cover
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.utils.EntityMapper
import javax.inject.Inject

class IGDBGameRepositoryMapper @Inject constructor() : EntityMapper<GameDAO, Game> {

    override fun toDomain(entity: GameDAO): Game {
        return Game(
            entity.id,
            entity.title,
            Cover(
                entity.cover.url,
                entity.cover.width,
                entity.cover.height,
            ),
            entity.summary,
            entity.rating,
            entity.ratingCount
        )
    }

    override fun toEntity(domainModel: Game): GameDAO {
        return GameDAO(
            domainModel.id,
            domainModel.title,
            GameDaoCover(
                domainModel.cover.url,
                domainModel.cover.width,
                domainModel.cover.height
            ),
            domainModel.rating,
            domainModel.ratingCount,
            domainModel.description
        )
    }

    fun fromListOfDao(entities: List<GameDAO>): List<Game> {
        return entities.map { toDomain(it) }
    }
}