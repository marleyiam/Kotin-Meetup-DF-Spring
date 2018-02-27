package com.kotlinmeetup.controller

import com.kotlinmeetup.model.Article
import com.kotlinmeetup.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class ArticleController(private val articleRepository: ArticleRepository) {

    @GetMapping("/articles")
    fun all(): List<Article> =
            articleRepository.findAll()


    @PostMapping("/articles")
    fun create(@Valid @RequestBody article: Article): ResponseEntity<Article> {
        articleRepository.save(article)
        return ResponseEntity.created(URI("/api/articles/${article.id}")).body(article)
    }

    @GetMapping("/articles/{id}")
    fun show(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> {
        return articleRepository.findById(articleId).map { article ->
            ResponseEntity.ok(article)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/articles/{id}")
    fun update(@PathVariable(value = "id") articleId: Long,
                          @Valid @RequestBody newArticle: Article): ResponseEntity<Article> {

        return articleRepository.findById(articleId).map { oldArticle ->
            val updatedArticle: Article = oldArticle
                    .copy(title = newArticle.title, content = newArticle.content)

            ResponseEntity.ok().body(articleRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/articles/{id}")
    fun delete(@PathVariable(value = "id") articleId: Long): ResponseEntity<Void> {

        return articleRepository.findById(articleId).map { article  ->
            articleRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}