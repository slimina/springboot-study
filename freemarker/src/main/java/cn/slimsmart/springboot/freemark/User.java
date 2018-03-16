package cn.slimsmart.springboot.freemark;

/**
 * Created by zhutw on 2018/3/12.
 */
public class User {
    private Long Id;
    private String name;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
