package hello.login.web.posts;

import hello.login.domain.Posts.Posts;
//import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.Posts.PostsRepository;
import hello.login.domain.item.Item;
import hello.login.web.posts.dto.PostsListResponseDto;
import hello.login.web.posts.dto.PostsResponseDto;
import hello.login.web.posts.dto.PostsSaveRequestDto;
import hello.login.web.posts.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    /* View Counting*/
    @Transactional
    public int updateView(Long id) {
        return postsRepository.updateView(id);
    }

}

//    private static final Map<Long, Posts> store = new HashMap<>(); //static
//    private static long sequence = 0L; //static
//
//    public Posts save(Posts posts) {
//        posts.setId(++sequence);
//        store.put(posts.getId(), posts);
//        return posts;
//    }
//
//    public Posts findById(Long id) {
//        Posts posts =  store.get(id);
//        posts.updateViewCount(posts.getView());
//        return posts;
//    }
//
//    public Posts findForEditById(Long id) {
//        Posts posts =  store.get(id);
//        return posts;
//    }
//
//    public List<Posts> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void update(Long postId, Posts updateParam) {
//        Posts findPosts = findById(postId);
//        findPosts.setTitle(updateParam.getTitle());
//        findPosts.setContent(updateParam.getContent());
//    }
//
//
//    public void clearStore() {
//        store.clear();
//    }
