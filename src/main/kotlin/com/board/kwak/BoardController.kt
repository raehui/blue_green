package com.board.kwak

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = arrayOf("/board"))
// localhost:8080/board
class BoardController(
    private val boardService: BoardService
) {

    @PostMapping
    fun create(
        @RequestBody boardDto : BoardDto
    ){
        boardService.create(boardDto)
    }

    @GetMapping
    fun getAll():List<BoardDto>{
        return boardService.getAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long):BoardDto{
        return boardService.getById(id)
    }
    @PatchMapping
    fun update(
        @RequestBody boardDto : BoardDto
    ){
        boardService.update(boardDto)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long){
        boardService.deleteById(id)
    }
}