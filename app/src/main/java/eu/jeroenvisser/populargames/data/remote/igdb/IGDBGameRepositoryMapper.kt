package eu.jeroenvisser.populargames.data.remote.igdb

import eu.jeroenvisser.populargames.data.entities.Cover
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.utils.EntityMapper
import javax.inject.Inject

class IGDBGameRepositoryMapper @Inject constructor() : EntityMapper<GameDAO, Game> {

    override fun toDomain(entity: GameDAO): Game {
        return Game(
            entity.id,
            entity.title,
            entity.summary,
            entity.storyLine,
            Cover(
                entity.cover.imageId,
                entity.cover.url,
                entity.cover.width,
                entity.cover.height,
            ),
            entity.rating,
            entity.ratingCount
        )
    }

    override fun toEntity(domainModel: Game): GameDAO {
        return GameDAO(
            domainModel.id,
            domainModel.title,
            domainModel.summary,
            domainModel.storyLine,
            GameDaoCover(
                domainModel.cover.id,
                domainModel.cover.url,
                domainModel.cover.width,
                domainModel.cover.height
            ),
            domainModel.rating,
            domainModel.ratingCount
        )
    }

    fun fromListOfDao(entities: List<GameDAO>): List<Game> {
        return entities.map { toDomain(it) }
    }
}