package ar.edu.davinci.view;

import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.davinci.controller.PostController;
import ar.edu.davinci.model.Post;
import ar.edu.davinci.model.User;

@Named
public class CreatePostMb {

	@Inject
	PostController postController;

	@Inject
	UserLoginMb userMb;

	public Post post;
	public static User user;

	public void setUser() {
		user = userMb.getCurrentUser();
	}

	public String create() {
		setUser();
		postController.create(post.getUser(), post.getContent());
		return "Loguin.xhtml?faces-redirect=true";
	}
}
