package com.kwi.config;

public enum Property {
    BASE_URL("path.json.placeholder.url"),
    PATH_GET_USERS("path.get.users"),
    PATH_GET_POSTS("path.get.posts"),
    PATH_GET_COMMENTS("path.get.comments"),
    PATH_GET_USER_ID("path.get.user.id"),
    PATH_GET_POST_ID("path.get.post.id"),
    PATH_POST("path.post"),
    PATH_PUT_POSTS_ID("path.put.posts.id"),
    PATH_DELETE_POSTS_ID("path.delete.posts.id");


    private final String property;

    Property(String property) {
        this.property = property;
    }

    public String property() {
        return property;
    }
}
