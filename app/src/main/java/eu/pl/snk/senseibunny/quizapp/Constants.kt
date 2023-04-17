package eu.pl.snk.senseibunny.quizapp

object Constants {

    const val USER_NAME: String ="user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestion():ArrayList<Question>{
        val questionsList=ArrayList<Question>()

        val que1 = Question(1, "Nad jaką rzeką leży Sanok",R.drawable.snk1, "Jesiotr", "Okoń", "wonsz", "San",4)
        questionsList.add(que1)
        val que2 = Question(2, "Kiedy Sanok otrzymał prawa miejeskie",R.drawable.snk2, "nie wiem", "nie dostał", "ukradli", "w 1339",4)
        questionsList.add(que2)
        val que3 = Question(3, "Jaki jest kod pocztowy Sanoka",R.drawable.snk3, "38-500", "29-600", "30-250", "69-420",1)
        questionsList.add(que3)
        val que4 = Question(4, "Jaki tablice rejestracyjne mają samochody w Sanoku",R.drawable.snk4 ,"RSA", "KRK", "RS", "PDW",1)
        questionsList.add(que4)
        val que5 = Question(5, "Kto jest patronem miasta Sanok",R.drawable.snk5, "Patron" ,"św Patryiarchat", "św Michał Archanioł", "św Grzesiek",3)
        questionsList.add(que5)
        val que6 = Question(6, "Jaki król Polski brał ślub w Sanoku",R.drawable.snk6, "Ktoś brał", "Zygmunt Waza V", "Jagiełło", "Mieszko I", 3)
        questionsList.add(que6)

        return questionsList
    }
}