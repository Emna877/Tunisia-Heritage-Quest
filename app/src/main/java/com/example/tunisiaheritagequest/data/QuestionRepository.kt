package com.example.tunisiaheritagequest.data

import com.example.tunisiaheritagequest.R
import com.example.tunisiaheritagequest.model.Difficulty
import com.example.tunisiaheritagequest.model.Question

object QuestionRepository {
    fun getIslamicHeritageQuestions(): List<Question> {
        return listOf(
            // Easy Questions
            Question(
                id = 1,
                imageResId = R.drawable.great_mosque_of_kairouan,
                text = "What is the name of this mosque in Kairouan?",
                options = listOf(
                    "Great Mosque of Kairouan",
                    "Zitouna Mosque",
                    "Sidi Sahbi Mosque",
                    "Great Mosque of Sfax"
                ),
                correctAnswerIndex = 0,
                keyFact = "Founded in 670 AD, it's the oldest mosque in the Maghreb and a major center of early Islamic scholarship.",
                difficulty = Difficulty.EASY,
                location = "Kairouan"
            ),
            Question(
                id = 2,
                imageResId = R.drawable.zitouna_mosque,
                text = "Which mosque is known for being one of the oldest universities in the Islamic world?",
                options = listOf(
                    "Zitouna Mosque",
                    "Great Mosque of Kairouan",
                    "Kasbah Mosque",
                    "Sidi Mahrez Mosque"
                ),
                correctAnswerIndex = 0,
                keyFact = "Located in Tunis Medina, one of the oldest universities in the Islamic world, central to learning for over a millennium.",
                difficulty = Difficulty.EASY,
                location = "Tunis"
            ),
            Question(
                id = 3,
                imageResId = R.drawable.sidi_sahbi_mosque,
                text = "This Kairouan mosque is also known as the 'Barber's Mosque'. What is its name?",
                options = listOf(
                    "Sidi Sahbi Mosque",
                    "Mosque of the Three Doors",
                    "Great Mosque of Sfax",
                    "Sidi Bou Makhlouf Mosque"
                ),
                correctAnswerIndex = 0,
                keyFact = "Also called the 'Barber's Mosque,' it houses the tomb of a companion of Prophet Muhammad.",
                difficulty = Difficulty.EASY,
                location = "Kairouan"
            ),
            Question(
                id = 4,
                imageResId = R.drawable.mosque_of_the_three_doors,
                text = "Which mosque is famous for its intricately carved Kufic inscriptions on the façade?",
                options = listOf(
                    "Mosque of the Three Doors",
                    "Great Mosque of Testour",
                    "Hammouda Pasha Mosque",
                    "Sidi Bou Said"
                ),
                correctAnswerIndex = 0,
                keyFact = "Famous for its intricately carved Kufic inscriptions on the façade.",
                difficulty = Difficulty.EASY,
                location = "Kairouan"
            ),
            Question(
                id = 5,
                imageResId = R.drawable.great_mosque_of_sfax,
                text = "Which mosque reflects a fortress-like architectural style and was built in the 9th century?",
                options = listOf(
                    "Great Mosque of Sfax",
                    "Kasbah Mosque",
                    "Great Mosque of Mahdia",
                    "Zaouia of Sidi Ben Arous"
                ),
                correctAnswerIndex = 0,
                keyFact = "Built in the 9th century, it reflects a fortress-like architectural style.",
                difficulty = Difficulty.EASY,
                location = "Sfax"
            ),
            
            // Medium Questions
            Question(
                id = 6,
                imageResId = R.drawable.great_mosque_of_testour,
                text = "The Great Mosque of Testour was built by which group and has a unique feature regarding its clock?",
                options = listOf(
                    "Andalusian refugees; clock runs counterclockwise",
                    "Ottoman settlers; clock has Arabic numerals",
                    "Fatimid rulers; has no clock",
                    "Punic builders; has a water clock"
                ),
                correctAnswerIndex = 0,
                keyFact = "Built by Andalusian refugees; its clock runs counterclockwise.",
                difficulty = Difficulty.MEDIUM,
                location = "Testour"
            ),
            Question(
                id = 7,
                imageResId = R.drawable.kasbah_mosque,
                text = "Which mosque was constructed under the Almohads in the 13th century?",
                options = listOf(
                    "Kasbah Mosque",
                    "Sidi Mahrez Mosque",
                    "Youssef Dey Mosque",
                    "Hammouda Pasha Mosque"
                ),
                correctAnswerIndex = 0,
                keyFact = "Constructed under the Almohads in the 13th century near the government square.",
                difficulty = Difficulty.MEDIUM,
                location = "Tunis"
            ),
            Question(
                id = 8,
                imageResId = R.drawable.youssef_dey_mosque,
                text = "What distinction does the Youssef Dey Mosque hold in Tunisian architecture?",
                options = listOf(
                    "First Ottoman-style mosque in Tunisia, built in 1616",
                    "Last Fatimid mosque ever built",
                    "Only mosque built during the French colonial period",
                    "First mosque with a modernist design"
                ),
                correctAnswerIndex = 0,
                keyFact = "First Ottoman-style mosque in Tunisia, built in 1616.",
                difficulty = Difficulty.MEDIUM,
                location = "Tunis"
            ),
            Question(
                id = 9,
                imageResId = R.drawable.hammouda_pasha_mosque,
                text = "The Hammouda Pasha Mosque is known for which rare architectural feature?",
                options = listOf(
                    "Octagonal minaret",
                    "Spiral minaret",
                    "Square tower minaret",
                    "Twin minarets"
                ),
                correctAnswerIndex = 0,
                keyFact = "Known for its octagonal minaret—rare in Tunisian mosque architecture.",
                difficulty = Difficulty.MEDIUM,
                location = "Tunis"
            ),
            Question(
                id = 10,
                imageResId = R.drawable.zaouia_of_sidi_bou_makhlouf,
                text = "The Sidi Bou Makhlouf Mosque is distinguished by what architectural influence?",
                options = listOf(
                    "Unique façade and Andalusian influence",
                    "Byzantine dome structure",
                    "Gothic arch design",
                    "Chinese pagoda style"
                ),
                correctAnswerIndex = 0,
                keyFact = "Distinguished by its unique façade and Andalusian influence.",
                difficulty = Difficulty.MEDIUM,
                location = "El Kef"
            ),
            
            // Hard Questions
            Question(
                id = 11,
                imageResId = R.drawable.sidi_mahrez_mosque,
                text = "Which mosque is inspired by Ottoman architecture and is often compared to Istanbul mosques?",
                options = listOf(
                    "Sidi Mahrez Mosque",
                    "Great Mosque of Mahdia",
                    "Zaouia of Sidi Ben Arous",
                    "Zaouia of Sidi Bou Said"
                ),
                correctAnswerIndex = 0,
                keyFact = "Inspired by Ottoman architecture, often compared to Istanbul mosques.",
                difficulty = Difficulty.HARD,
                location = "Tunis"
            ),
            Question(
                id = 12,
                imageResId = R.drawable.zaouia_of_sidi_ben_arous,
                text = "Which zaouia is dedicated to a revered Sufi saint and is an important spiritual site?",
                options = listOf(
                    "Zaouia of Sidi Ben Arous",
                    "Zaouia of Sidi Bou Said",
                    "Mosque of the Three Doors",
                    "Sidi Sahbi Mosque"
                ),
                correctAnswerIndex = 0,
                keyFact = "Dedicated to a revered Sufi saint; important spiritual site.",
                difficulty = Difficulty.HARD,
                location = "Tunis"
            ),
            Question(
                id = 13,
                imageResId = R.drawable.zaouia_of_sidi_bou_said,
                text = "The Zaouia of Sidi Bou Said is the shrine of which saint?",
                options = listOf(
                    "Sidi Bou Said - the saint who gave the village its name",
                    "Sidi Ben Arous - a famous Islamic scholar",
                    "Sidi Sahbi - the Barber of the Prophet",
                    "Sidi Mahrez - an Ottoman governor"
                ),
                correctAnswerIndex = 0,
                keyFact = "Shrine of the saint who gave the village its name.",
                difficulty = Difficulty.HARD,
                location = "Sidi Bou Said"
            ),
            Question(
                id = 14,
                imageResId = R.drawable.great_mosque_of_mahdia,
                text = "What is notable about the architectural design of the Great Mosque of Mahdia?",
                options = listOf(
                    "Built by Fatimids; notable for lacking a traditional minaret",
                    "First mosque with a modern glass façade",
                    "Only mosque built entirely underground",
                    "Has the tallest minaret in North Africa"
                ),
                correctAnswerIndex = 0,
                keyFact = "Built by the Fatimids; notable for lacking a traditional minaret.",
                difficulty = Difficulty.HARD,
                location = "Mahdia"
            ),
            // Additional Question 15
            Question(
                id = 15,
                imageResId = R.drawable.zaouia_of_sidi_abdelkader,
                text = "What is the name of this shrine?",
                options = listOf(
                    "Zaouia of Sidi Abdelkader",
                    "Zaouia of Sidi Ben Arous",
                    "Zaouia of Sidi Bou Said",
                    "Zaouia of Sidi Bou Makhlouf"
                ),
                correctAnswerIndex = 0,
                keyFact = "Known for its decorative brickwork typical of southern Tunisia.",
                difficulty = Difficulty.HARD,
                location = "Tozeur"
            )
        )
    }
}

