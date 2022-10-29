package hello.login.web.posts;

import hello.login.domain.Posts.Posts;
//import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostsService {

    private static final Map<Long, Posts> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Posts save(Posts posts) {
        posts.setId(++sequence);
        store.put(posts.getId(), posts);
        return posts;
    }

    public Posts findById(Long id) {
        return store.get(id);
    }

    public List<Posts> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long postId, Posts updateParam) {
        Posts findPosts = findById(postId);
        findPosts.setTitle(updateParam.getTitle());
        findPosts.setAuthor(updateParam.getAuthor());
        findPosts.setContent(updateParam.getContent());
    }


    public void clearStore() {
        store.clear();
    }

}
