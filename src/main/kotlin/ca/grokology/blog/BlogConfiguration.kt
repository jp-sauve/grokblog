package ca.grokology.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) =
        ApplicationRunner {
            val jpSauve = userRepository.save(User("jpsauve", "JP", "Sauve"))
            articleRepository.save(Article(
                title = "How I made a blog",
                headline = "Easy as 1..2..3",
                content = "Step 1. Do codes. Step 2. Run codes. Step 3. ????. Step 4. Profit!",
                author = jpSauve
            ))
            articleRepository.save(Article(
                title = "How I eat a snack",
                headline = "Easy as pie. Or cookies.",
                content = "Step 1. Make cash. Step 2. Buy snacks. Step 3. ????. Step 4. Nom nom nom!",
                author = jpSauve
            ))
        }

}