//This piece of code helps to find out a particular student from a list of Student either by their name or by their ID

data class Student(val fullName:String, var id:Int, var grade:Double)

val students= listOf<Student>(
    Student("John",223,140.0),
    Student("Mark",548,120.0),
    Student("Natali",342,150.0),
    Student("Sara",781,130.0)
)


fun getStudentById(id:Int): Student{
    return students.find{it.id==id}!!
}

fun searchInStudents(name:String): Student?{
    return students.find { it.fullName.lowercase()==name.lowercase()}
}

fun main(){
    println("Please, Enter Students's ID Number:")
    val id= readln().toInt()
    println(getStudentById(id))
    println("Please enter Student's Name:")
    val name =readln()
    println(searchInStudents(name)?:"The Student is not found")
}
