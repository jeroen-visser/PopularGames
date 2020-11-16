package eu.jeroenvisser.populargames.utils

interface EntityMapper<Entity, DomainModel>  {

    fun toDomain(entity: Entity): DomainModel

    fun toEntity(domainModel: DomainModel): Entity

}