package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {

    NewsApi newsApi;

    @BeforeEach
    void setUp() {
            newsApi = new NewsApi();
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
    ApiExampleWrapper list = newsApi.getNewsStoryByTopic("Russia");

        Article article = list.getArticles().get(0);
        String articleTitle = article.getTitle();

        //Get the content of the article
        String articleContent = article.getContent();

        //Get the URL of the article
        String articleUrl = article.getUrl();
        String expected = articleTitle + " -\n"
                + articleContent
                + "\nFull article: " + articleUrl;


        //when



        //then
        assertEquals(list.getStatus(),"ok");
    }

    @Test
    void itShouldFindStory(){
        //given
        ApiExampleWrapper list = newsApi.getNewsStoryByTopic("Russia");
        Article article = list.getArticles().get(0);
        String articleTitle = article.getTitle();

        //Get the content of the article
        String articleContent = article.getContent();

        //Get the URL of the article
        String articleUrl = article.getUrl();
        String expected = articleTitle + " -\n"
                + articleContent
                + "\nFull article: " + articleUrl;
        //when
String actual = newsApi.findStory("Russia");
        //then
        assertEquals(actual,expected);
    }


}