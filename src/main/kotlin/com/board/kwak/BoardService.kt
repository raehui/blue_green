package com.board.kwak

import org.springframework.stereotype.Service

@Service
class BoardService (
    private val boardRepository: BoardRepository

){
    fun create(
        boarDto : BoardDto
    ){
        val boardEntity =BoardEntity(
            title = boarDto.title ,
            content =boarDto.content,
            name= boarDto.name
        )

        boardRepository.save(boardEntity)
    }

    fun getAll(): List<BoardDto>{
        val boardEntities=boardRepository.findAll()
        val boarDtoList = boardEntities.map { board->
            BoardDto(
                id = board.id,
                title = board.title,
                content = board.content,
                name= board.name
            )

        }
        return boarDtoList
    }

    fun getById(id:Long): BoardDto{
        val boardEntity = boardRepository.findById(id).get()
        val boardDto=BoardDto(
            id = boardEntity.id,
            title = boardEntity.title,
            content = boardEntity.content,
            name= boardEntity.name
        )
        return boardDto
    }fun update(boardDto: BoardDto){
        val id = boardDto.id!!
        val boardEntity=boardRepository.findById(id).get()

        boardEntity.update(boardDto)

        boardRepository.save(boardEntity)

    }

    fun deleteById(id:Long){
        boardRepository.deleteById(id)
    }


}