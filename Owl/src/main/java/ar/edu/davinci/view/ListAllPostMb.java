package ar.edu.davinci.view;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.davinci.controller.PostController;
import ar.edu.davinci.model.User;
import ar.edu.davinci.model.Post;

@Named
public class ListAllPostMb {

	@Inject
	PostController postController;

	@Inject
	UserLoginMb userMb;

	public static User user;

	public void setUser() {
		user = userMb.getCurrentUser();
	}

	public List<Post> getUserPost() {
		setUser();
		return postController.allFromOneUser(user);
	}

	public List<Post> allPost() {
		setUser();
		return postController.all();
	}

}
