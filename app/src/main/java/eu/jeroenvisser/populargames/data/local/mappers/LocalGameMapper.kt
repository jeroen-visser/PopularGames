package eu.jeroenvisser.populargames.data.local.mappers

import eu.jeroenvisser.populargames.data.entities.Cover
import eu.jeroenvisser.populargames.data.entities.Game
import eu.jeroenvisser.populargames.data.local.entities.RoomGameEntity
import eu.jeroenvisser.populargames.utils.EntityMapper
import javax.inject.Inject

class LocalGameMapper @Inject constructor() : EntityMapper<RoomGameEntity, Game> {

    override fun toDomain(entity: RoomGameEntity): Game {
        return Game(
            entity.id,
            entity.title,
            Cover(
                entity.coverUrl,
                entity.coverWidth,
                entity.coverHeight
            ),
            entity.summary,
            entity.rating,
            entity.ratingCount
        )
    }

    override fun toEntity(domainModel: Game): RoomGameEntity {
        return RoomGameEntity(
            domainModel.id,
            domainModel.title,
            domainModel.cover.url,
            domainModel.cover.width,
            domainModel.cover.height,
            domainModel.description,
            domainModel.rating,
            domainModel.ratingCount
        )
    }
}