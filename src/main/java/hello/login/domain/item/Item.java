//package hello.login.domain.item;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//
//@Entity
//@Data
//public class Item {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotEmpty
//    private String title;
//    @NotEmpty
//    private String author;
//    @NotEmpty
//    private String content;
//
//    @Column(columnDefinition = "integer default 0", nullable = false)
//    private int view;
//
//    public Item() {
//    }
//
//    public Item(String title, String author, String content, Integer view) {
//        this.title = title;
//        this.author = author;
//        this.content = content;
//        this.view = view;
//    }
//}