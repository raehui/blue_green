package com.board.kwak

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalTime

@Entity
class BoardEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    var content: String,

    val name : String ,

//    val createdAt : LocalTime = LocalTime.now()
){
    fun update(boardDto: BoardDto){
        this.title = boardDto.title
        this.content =boardDto.content
    }
}
// id - 자동생성
// title
// cotent 
// name
// 생성자