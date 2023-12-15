package network.data

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class Answer(val id : Int,val label :String)

@kotlinx.serialization.Serializable
data class Question(val id:Int, val label:String, @SerialName("correct_answer_id") val correctAnswerId:Int, val answers:List<Answer>)

@kotlinx.serialization.Serializable
data class Quiz(var questions : List<Question>)

